
import Data.List(intercalate)
import Test.QuickCheck

data Seq a = Empty | Node a (Seq a)

testSeq1 :: Seq Int
testSeq1 = Node 10 (Node 40 (Node 30 Empty))
-- [10,40,30]

-- completar size insert get invert

empty :: Seq a
empty = Empty

isEmpty :: Seq a -> Bool
isEmpty Empty = True
isEmpty _ = False

size :: Seq a -> Integer
size Empty = 0
size (Node x xs) = 1 + size xs

insert :: (Ord a) => Integer -> a -> Seq a -> Seq a
insert _ x Empty = Node x Empty
insert i x (Node y ys)
    | i < 0 || i > size (Node y ys) = error "wrong index"
    | i == 0 = Node x (Node y ys)
    | otherwise = Node y (insert (i-1) x ys)


inverse :: Seq a -> Seq a 
inverse Empty = Empty
inverse xs = f xs empty
    where 
        f Empty xs = xs 
        f (Node a as) bs = f as (Node a bs)


get :: Integer -> Seq a -> a
get i (Node x xs)
    | i < 0 || i > size (Node x xs) = error "wrong index"
    | i == 0 = x
    | otherwise = get (i-1) xs

instance (Show a) => Show (Seq a) where
    show q = "LinearSeq(" ++ intercalate "," (aux q) ++ ")"
        where
            aux Empty = []
            aux (Node x q) = show x : aux q