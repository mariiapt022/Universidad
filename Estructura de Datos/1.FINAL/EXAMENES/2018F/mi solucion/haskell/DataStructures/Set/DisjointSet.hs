-------------------------------------------------------------------------------
-- Student's name:
-- Student's group:
--
-- Data Structures. February 2018. BSc. Computer Science. UMA.
-------------------------------------------------------------------------------

module DataStructures.Set.DisjointSet
                  ( DisjointSet
                  , empty
                  , isEmpty
                  , isElem
                  , numElements
                  , add
                  , areConnected
                  , kind
                  , union
                  , flatten
                  , kinds
                  ) where

import           Data.List                               (intercalate)
import           Data.Maybe                              (fromJust)
import qualified DataStructures.Dictionary.AVLDictionary as D

data DisjointSet a = DS (D.Dictionary a a)

-- | Exercise 1. empty

empty :: DisjointSet a
empty = DS D.empty


-- | Exercise 2.a isEmpty

isEmpty :: DisjointSet a -> Bool
isEmpty (DS dict) = D.isEmpty dict

-- | Exercise 2.b isElem

isElem :: (Ord a) => a -> DisjointSet a -> Bool
isElem x (DS dict) = D.isDefinedAt x dict 

-- | Exercise 3. numElements

numElements :: DisjointSet a -> Int
numElements (DS dict) = D.size dict

-- | Exercise 4. add

add :: Ord a => a -> DisjointSet a -> DisjointSet a
add x (DS dict)
  | isElem x (DS dict) = (DS dict)
  | otherwise = DS (D.insert x x dict)

-- | Exercise 5. root

root :: Ord a => a -> DisjointSet a -> Maybe a
root x (DS dict)
  | not(isElem x (DS dict)) = Nothing
  | k==x = Just x 
  | otherwise = root k (DS dict)
      where
        (Just k) = D.valueof x dict

-- | Exercise 6. isRoot

isRoot :: Ord a => a -> DisjointSet a -> Bool
isRoot x (DS dict) 
  | not(isElem x (DS dict)) = False 
  | otherwise = x==k 
    where
      (Just k) = D.valueof x dict

--  isRoot elem ds = Just elem == (root elem ds)

-- | Exercise 7. areConnected

areConnected :: Ord a => a -> a -> DisjointSet a -> Bool
areConnected x y ds@(DS dict) = precond && rootx==rooty
  where
    precond = isElem x (DS dict) && isElem y (DS dict)
    (Just rootx) = root x ds 
    (Just rooty) = root y ds

--  areConnected u v ds = root u ds == root v ds

-- | Exercise 8. kind

kind :: Ord a => a -> DisjointSet a -> [a]
kind x ds@(DS dict)
  | not(isElem x ds) = []
  | otherwise = [k | (k,v)<-D.keysValues dict, rootx==root' (root k ds)]
    where
      root' (Just r) = r 
      rootx = root' $ root x ds

-- kind u (DS d) = [k | k<-D.keys d, areConnected u k (DS d)]

-- | Exercise 9. union

union :: Ord a => a -> a -> DisjointSet a -> DisjointSet a
union x y ds@(DS dict)
  | not (isElem x (DS dict)) || not (isElem y (DS dict)) = error "No se encuentrar en la relacion de equivalencia"
  | rootx > rooty = (DS $ D.insert rootx rooty dict)
  | otherwise = (DS $ D.insert rooty rootx dict)
    where
      root' (Just r) = r 
      rootx = root' $ root x ds 
      rooty = root' $ root y ds

-- union u v (DS d) = DS (D.insert mayor menor d)
--  where
--    mayor = max raiz1 raiz2
--    menor = min raiz1 raiz2
--    raiz1 = fromJust (root u (DS d))
--    raiz2 = fromJust (root v (DS d))




-- |------------------------------------------------------------------------

flatten :: Ord a => DisjointSet a -> DisjointSet a
flatten = undefined

kinds :: Ord a => DisjointSet a -> [[a]]
kinds = undefined

-- |------------------------------------------------------------------------

instance (Ord a, Show a) => Show (DisjointSet a) where
  show (DS d)  = "DictionaryDisjointSet(" ++ intercalate "," (map show (D.keysValues d)) ++ ")"


{-

-- Examples

-- | Exercise 1. empty

>>> empty
DictionaryDisjointSet()

-- | Exercise 2.a isEmpty

>>> isEmpty empty
True

>>> isEmpty (add 1 empty)
False

-- | Exercise 2.b isElem

>>> isElem 1 empty
False

>>> isElem 1 (add 1 empty)
True

>>> isElem 2 (add 1 empty)
False

>>> isElem 1 (add 2 (add 1 empty))
True

-- | Exercise 3. numElements

>>> numElements empty
0

>>> numElements (add 1 empty)
1

>>> numElements (add 2 (add 1 empty))
2

-- | Exercise 4. add

>>> add 1 empty
DictionaryDisjointSet((1,1))

>>> add 2 (add 1 empty)
DictionaryDisjointSet((1,1),(2,2))

>>> add 1 (add 2 (add 1 empty))
DictionaryDisjointSet((1,1),(2,2))

-- | Exercise 5. root

>>> root 1 empty
Nothing

>>> root 1 (add 1 empty)
Just 1

>>> root 2 (add 2 (add 1 empty))
Just 2

>>> root 1 (union 1 2 (add 2 (add 1 empty)))
Just 1

>>> root 2 (union 1 2 (add 2 (add 1 empty)))
Just 1

>>> root 1 (union 1 3 (add 3 (add 2 (add 1 empty))))
Just 1

>>> root 2 (union 1 3 (add 3 (add 2 (add 1 empty))))
Just 2

>>> root 3 (union 1 3 (add 3 (add 2 (add 1 empty))))
Just 1

>>> root 4 (union 1 3 (add 3 (add 2 (add 1 DisjointSet.empty))))
Nothing

-- | Exercise 6. isRoot

>>> isRoot 1 empty
False

>>> isRoot 1 (add 1 empty)
True

>>> isRoot 1 (union 1 2 (add 2 (add 1 empty)))
True

>>> isRoot 2 (union 1 2 (add 2 (add 1 empty)))
False

>>> isRoot 1 (union 1 3 (add 3 (add 2 (add 1 empty))))
True

>>> isRoot 2 (union 1 3 (add 3 (add 2 (add 1 empty))))
True

>>> isRoot 3 (union 1 3 (add 3 (add 2 (add 1 empty))))
False

-- | Exercise 7. areConnected

>>> areConnected 1 3 (union 1 3 (add 3 (add 2 (add 1 empty))))
True

>>> areConnected 3 1 (union 1 3 (add 3 (add 2 (add 1 empty))))
True

>>> areConnected 1 1 (union 1 3 (add 3 (add 2 (add 1 empty))))
True

>>> areConnected 1 2 (union 1 3 (add 3 (add 2 (add 1 empty))))
False

>>> areConnected 1 2 (union 2 3 (union 1 3 (add 3 (add 2 (add 1 empty)))))
True

>>> areConnected 1 5 (union 2 3 (union 1 3 (add 3 (add 2 (add 1 empty)))))
False

-- | Exercise 8. kind

>>> kind 1 (add 2 (add 1 empty))
[1]

>>> kind 2 (add 2 (add 1 empty))
[2]

>>> kind 3 (add 2 (add 1 empty))
[]

>>> kind 1 (union 1 3 (add 3 (add 2 (add 1 empty))))
[1,3]

>>> kind 3 (union 1 3 (add 3 (add 2 (add 1 empty))))
[1,3]

>>> kind 2 (union 1 3 (add 3 (add 2 (add 1 empty))))
[2]

>>> kind 2 (union 2 3 (union 1 3 (add 3 (add 2 (add 1 empty)))))
[1,2,3]

-- | Exercise 9. union

>>> union 1 2 (add 2 (add 1 empty))
DictionaryDisjointSet((1,1),(2,1))

>>> union 2 1 (add 2 (add 1 empty))
DictionaryDisjointSet((1,1),(2,1))

>>> union 1 1 (add 2 (add 1 empty))
DictionaryDisjointSet((1,1),(2,2))

>>> union 1 3 (add 3 (add 2 (add 1 empty)))
DictionaryDisjointSet((1,1),(2,2),(3,1))

>>> union 1 2 (add 1 empty)
*** Exception: union: missing element(s)

-}
