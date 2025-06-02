
module SetMultiMap ( SetMultiMap
                , empty
                , isEmpty
                , size
                , isDefinedAt
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
                     | Node a (S.Set b) (SetMultiMap a b)
                     deriving Eq 

m1 :: SetMultiMap String Int 
m1 = Node "alfredo" (mkSet [9]) (Node "juan" (mkSet [0,1,8]) (Node "maria" (mkSet [4,-6,8]) Empty))

mkSet :: Eq a => [a] -> S.Set a 
mkSet = foldr S.insert S.empty 

empty :: SetMultiMap a b 
empty = Empty

isEmpty :: SetMultiMap a b -> Bool
isEmpty Empty = True 
isEmpty _ = False 

size :: SetMultiMap a b -> Integer
size Empty = 0
size (Node x xs ys) = 1 + size ys 

isDefinedAt :: (Ord a, Eq b) => a -> SetMultiMap a b -> Bool
isDefinedAt _ Empty = False
isDefinedAt b (Node x xs ys)
    | b == x = True 
    | otherwise = isDefinedAt b ys

insert :: (Ord a, Eq b) => SetMultiMap a b -> a -> b -> SetMultiMap a b
insert Empty k v = Node k (S.insert v S.empty) Empty
insert (Node x xs ys) k v
    | k > x && not(isDefinedAt k (Node x xs ys)) == Node x xs (Node k (S.insert v S.empty) ys)
    | k == x = Node x (S.insert v xs) ys 
    | otherwise = Node x xs (insert k v ys)

valuesOf :: (Ord a, Eq b) => SetMultiMap a b -> a -> Maybe(S.Set b)
valuesOf (Node x xs ys) k 
    | k == x = Just xs 
    | not(isDefinedAt k (Node x xs ys)) = Nothing
    | k < x = valuesOf ys k 

deleteKey :: (Ord a, Eq b) => a -> SetMultiMap a b -> SetMultiMap a b 
deleteKey k (Node x xs ys) 
    | k == x = ys
    | otherwise = Node x xs (deleteKey k ys)

deleteKeyValue :: (Ord a, Eq b) => a -> b -> SetMultiMap a b -> SetMultiMap a b 
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
ax_deleteKeyValue_1 k v xs = not(isDefinedAt k q) ==> deleteKeyValue k v q == q 