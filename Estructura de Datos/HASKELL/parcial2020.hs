-- Parcial 2020 María Peinado Toledo

module SetMultiMap ( SetMultiMap
                    , empty
                    , isEmpty
                    , size
                    , insert
                    , deleteKey
                    , deleteKeyValue
                    , valuesOf
                    , filterValues
                    , fold 
                    ) where

import Data.List (intercalate)
import Test.QuickCheck

import qualified DataStructures.Set.LinearSet as S

data SetMultiMap a b = Empty
                     | Node a (S.set b) (SetMultiMap a b)
                     deriving Eq

m1 :: SetMultiMap String Int
m1 = Node "alfredo" (mkSet [9]) (
     Node "juan" (mkSet [0,1,8]) (
     Node "maria" (mkSet [4,-6,8])
     Empty ))

mkSet :: Eq a => [a] -> S.Set a 
mkSet = foldr S.insert S.empty

-- Ejercicio 1
empty :: SetMultiMap a b
empty = Empty 

isEmpty :: SetMultimap a b -> Bool
isEmpty Empty = True
isEmpty _ = False

size :: SetMultimap a b -> Integer
size Empty = 0
size (Node x xs ys) = 1 + size ys 

isDefinedAt :: (Ord a, Eq b) => a -> SetMultiMap a b -> Bool
isDefinedAt Empty = False
isDefinedAt a (Node x xs ys) 
    | a == x = True
    | otherwise = isDefinedAt a ys 

insert :: (Ord a, Eq b) => a -> b -> SetMultiMap a b ->  SetMultiMap a b 
insert k v Empty  = Node k (S.insert v S.empty) Empty
insert k v (Node x xs ys) 
    | k > x && not(isDefinedAt k (Node x xs ys)) == Node x xs (Node k (S.insert v S.empty) ys)
    | k == x = Node x (S.insert v xs) ys
    | otherwise = Node x xs (insert k v ys)

valuesOf :: (Ord a, Eq b) => a -> SetMultiMap a b -> Maybe(S.Set b)
valuesOf _ Empty = Nothing
valuesOf k (Node x xs ys) 
    | k == x = Just xs 
    | k > x = Nothing
    | otherwise = valuesOf k ys

deleteKey :: (Ord a, Eq b) => a -> SetMultiMap a b -> SetMultiMap a b 
deleteKey k Empty = Empty
deleteKey k (Node x xs ys)
    | k==x = ys 
    | otherwise = Node x xs (delete k ys)

deleteKeyValue :: (Ord a, Eq b) => a -> b -> SetMultiMap a b -> SetMultiMap a b 
deleteKeyValue k v Empty = Empty
deleteKeyValue k v (Node x xs ys)
    | k == x = if(S.size(S.delete v xs) == 0) then ys else Node x (S.delete v xs) ys 
    | otherwise = Node x xs (deleteKeyValue k v ys)

filterValues :: (Ord a, Eq b) => (b -> Bool) -> SetMultiMap a b -> SetMultiMap a b
filterValues p Empty = Empty
filterValues p (Node x xs ys)
    | funcional == S.empty = filterValues p ys 
    | otherwise = Node x funcional (filterValues p ys)
        where
            funcional = (S.fold (\s q -> if p s then S.insert s q else q) S.empty xs)

ax_deleteKeyValue_empty x y = deleteKeyValue x y empty == empty 
ax_deleteKeyValue_1 k v q = not(isDefinedAt k q) ==> deleteKeyValue k v q == q 