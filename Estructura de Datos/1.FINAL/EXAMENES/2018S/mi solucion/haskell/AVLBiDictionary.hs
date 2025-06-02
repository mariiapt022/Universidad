-------------------------------------------------------------------------------
-- Apellidos, Nombre: 
-- Titulacion, Grupo: 
--
-- Estructuras de Datos. Grados en Informatica. UMA.
-------------------------------------------------------------------------------

module AVLBiDictionary( BiDictionary
                      , empty
                      , isEmpty
                      , size
                      , insert
                      , valueOf
                      , keyOf
                      , deleteByKey
                      , deleteByValue
                      , toBiDictionary
                      , compose
                      , isPermutation
                      , orbitOf
                      , cyclesOf
                      ) where

import qualified DataStructures.Dictionary.AVLDictionary as D
import qualified DataStructures.Set.BSTSet               as S

import           Data.List                               (intercalate, nub,
                                                          (\\))
import           Data.Maybe                              (fromJust, fromMaybe,
                                                          isJust)
import           Test.QuickCheck


data BiDictionary a b = Bi (D.Dictionary a b) (D.Dictionary b a)

-- | Exercise a. empty, isEmpty, size

empty :: (Ord a, Ord b) => BiDictionary a b
empty = Bi D.empty D.empty

isEmpty :: (Ord a, Ord b) => BiDictionary a b -> Bool
isEmpty (Bi a b) = (D.isEmpty a)&&(D.isEmpty b)

size :: (Ord a, Ord b) => BiDictionary a b -> Int
size (Bi a b) = D.size a

-- | Exercise b. insert

insert :: (Ord a, Ord b) => a -> b -> BiDictionary a b -> BiDictionary a b
insert x y (Bi a b) 
  | D.isDefinedAt x a = (Bi (D.insert x y a) (D.insert y x (D.delete (fromJust(D.valueOf x a)) b)))
  | otherwise = (Bi (D.insert x y a) (D.insert y x b))


-- | Exercise c. valueOf

valueOf :: (Ord a, Ord b) => a -> BiDictionary a b -> Maybe b
valueOf x (Bi a b) = D.valueOf x a 

-- | Exercise d. keyOf

keyOf :: (Ord a, Ord b) => b -> BiDictionary a b -> Maybe a
keyOf y (Bi a b) = D.valueOf y b

-- | Exercise e. deleteByKey

deleteByKey :: (Ord a, Ord b) => a -> BiDictionary a b -> BiDictionary a b
deleteByKey x (Bi a b)
  | D.isDefinedAt x a = (Bi (D.delete x a)(D.delete (fromJust(D.valueOf x a)) b))
  | otherwise = (Bi a b)

-- | Exercise f. deleteByValue

deleteByValue :: (Ord a, Ord b) => b -> BiDictionary a b -> BiDictionary a b
deleteByValue y (Bi a b)
  | D.isDefinedAt y b = (Bi (D.delete (fromJust (D.valueOf y b)) dk) (D.delete y b))
  | otherwise = (Bi a b)

-- | Exercise g. toBiDictionary

toBiDictionary :: (Ord a, Ord b) => D.Dictionary a b -> BiDictionary a b
toBiDictionary d
  | D.isEmpty d = (Bi (D.empty) (D.empty))
  | inyectiva (D.values d) = insertRec (D.keys d) empty
  | otherwise = error "Diccionario no inyectivo"
    where 
      insert [] bid = bid 
      insert (x:xs) bid = insertRec xs (D.insert x (fromJust (D.valueOf x d)) bid)

inyectiva :: (Ord b) => [b] -> Bool 
inyectiva [] = True
inyectiva (x:xs)
  | elem x xs = False
  | otherwise = inyectiva xs

-- | Exercise h. compose

compose :: (Ord a, Ord b, Ord c) => BiDictionary a b -> BiDictionary b c -> BiDictionary a c
compose (Bi dk1 dv1) (Bi dk2 dv2) = aux (D.keys dv1) (D.keys dk2) empty
  where
    aux [] (y:ys) dict = dict 
    aux (x:xs) (y:ys) dict
      | elem x (y:ys) = aux xs (y:ys) (D.insert (fromJust(D.valueOf x dv1)) (fromJust(D.valueOf x dk2)) dict)
      | otherwise = aux xs (y:ys) dict

-- | Exercise i. isPermutation

isPermutation :: Ord a => BiDictionary a a -> Bool
isPermutation (Bi a b) = (D.keys a) == (D.keys b)



-- |------------------------------------------------------------------------


-- | Exercise j. orbitOf

orbitOf :: Ord a => a -> BiDictionary a a -> [a]
orbitOf = undefined

-- | Exercise k. cyclesOf

cyclesOf :: Ord a => BiDictionary a a -> [[a]]
cyclesOf = undefined

-- |------------------------------------------------------------------------


instance (Show a, Show b) => Show (BiDictionary a b) where
  show (Bi dk dv)  = "BiDictionary(" ++ intercalate "," (aux (D.keysValues dk)) ++ ")"
                        ++ "(" ++ intercalate "," (aux (D.keysValues dv)) ++ ")"
   where
    aux kvs  = map (\(k,v) -> show k ++ "->" ++ show v) kvs
