
{-
module WellBalanced where
import Test.QuickCheck 
import DataStructures.Stack.LinearStack

wellBalanced :: String -> Bool
wellBalanced xs = wellBalanced' xs S.empty

wellBalanced' :: String -> Stack Char -> Bool
wellBalanced' [] s = isEmpty s
wellBalanced' (x:xs) s
   | x == '(' || x == '{' || x == '[' = wellBalanced' xs (push x s)
   | x == ')' || x == '}' || x == ']' = wellBalanced' xs (pop s) 
   | otherwise = wellBalanced' xs s

-}

{-
module Expression (
    Item (..)
  , Expression
  , value
  , showExpr
  , sample1, sample2
  ) where

data Item = Add | Dif | Mul | Value Integer | LeftP | RightP deriving Show 
type Expression = [Item]

-- sample1 corresponde con 5 + (6 -2) * 3
sample1 = [Value 5, Add, LeftP, Value 6, Dif, Value 2, RightP, Mul, Value 3]

evaluateInFix :: Expression -> Stack Integer -> Stack Item -> Integer
evaluateInFix (x:xs) a b
    | x Integer = push a x 
    | x Item = push b x 
    | x=='LeftP' = evaluateInFix xs 
    | x== 'RightP' = top (push x s)

-}

{-
module FoldStackQueue where
import qualified DataStructures.Stack.LinearStack as S 
import qualified DataStructures.Queue.LinearQueue as Q
import Test.QuickCheck

foldrStack :: (a->b->b) -> b -> S.Stack a -> b 
foldrStack f z s 
    | S.isEmpty s = z
    | otherwise = S.top s `f` foldrStack f z (S.pop s)

listToStack :: [a] -> S.Stack a
listToStack xs = foldr S.push S.empty xs 

stackToList :: S.Stack a -> [a]
stackToList xs = foldrStack (:) [] xs 

mapStack :: (a->b) -> S.Stack a -> S.Stack b 
mapStack f xs = foldrStack g S.empty xs
    where
        g cab solCola = S.push (f cab) solCola

sizeStack :: Stack a -> Int 
sizeStack isEmpty = 0
sizeStack s = foldrStack f 0 s 
    where f cab solCola = 1 + solCola
-}

{-
module FoldStackQueue where
import qualified DataStructures.Stack.LinearStack as S 

foldrQueue :: (a->b->b) -> b -> Queue a -> b 
foldrQueue f z q 
    | S.isEmpty q = z
    | otherwise = f (S.first q) (foldrQueue f z (S.dequeue q))

listToQueue :: [a] -> Queue a 
listToQueue s = foldr Q.enqueue Q.isEmpty s

stackToQueue :: Stack a -> Queue a 
stackToQueue s = foldrStack Q.enqueue Q.isEmpty s 

queueToStack :: Queue a -> Stack a 
queueToStack s = foldrQueue S.enqueue S.empty s 

queueToList :: Queue a -> [a]
queueToList s = foldrQueue (:) [] s 

mapQueue :: (a-> b) -> Queue a -> Queue b 
mapQueue f a = foldrQueue g Q.isEmpty a 
    where g cab solCola = Q.enqueue (f cab) solCola
-}


{-
module Entero (Entero, cero, isCero, isPos, isNeg, suc, pre) where

import Test.QuickCheck

instance Show Entero where show = show . enteroToInteger

data Entero = Cero | Suc Entero | Pre Entero deriving Eq

enteroToInteger :: Entero -> Integer
enteroToInteger Cero = 0
enteroToInteger (Suc n) = enteroToInteger n + 1 
enteroToInteger (Pre n) = enteroToInteger n - 1

cero :: Entero
cero = Cero

suc, pre :: Entero -> Entero
pre (Suc n) = n
pre n = Pre n 
suc (Pre n) = n 
suc n = Suc n 


isCero, isPos, isNeg :: Entero -> Bool 
isCero Cero = True
isPos n = enteroToInteger n > 0
isNeg n = enteroToInteger n < 0

ax1 n = suc (pre n) == n 
ax1' n = pre (suc n) == n 
ax2 n = isPos n ==> isPos (suc n)
ax2' n = isNeg n ==> isNeg (pre n)

instance Arbitrary Entero where
    arbitrary = do 
        i <- arbitrary
        return (fromInteger i)
    
instance Num Entero where
    -- fromInteger :: Integer -> Entero 
    fromInteger 0 = Cero 
    fromInteger i | i > 0 = Suc (fromInteger (i-1))
    fromInteger i | otherwise = Pre (fromInteger (i+1))

    x + Cero = x 
    x + Suc y = suc (x+y)
    x + Pre y = pre (x+y)
    x - Cero = x 
    x*Cero = Cero 
    abs(Pre x) = Pre (abs x)
    signum Cero = 0
-}
{-
module Stack where

import           Test.QuickCheck

data Stack a = Empty
             | Node a (Stack a)
             deriving (Show, Eq)

empty :: Stack a 
empty = Empty

push :: a -> Stack a -> Stack a
push x s = Node x s 

pop :: Stack a -> Stack a
pop Empty = error "stack vacio"
pop (Node x s) = s 

top :: Stack a -> a
top (Node x s) = x 

isEmpty :: Stack a -> Bool
isEmpty = undefined

instance Arbitrary a => Arbitrary (Stack a) where
  arbitrary =  do
                xs <- listOf arbitrary
                return (foldr push empty xs)

prop1 
-}

module Expression (
    Item (..)
  , Expression
  , value
  , showExpr
  , sample1, sample2
  ) where

data Item = Add | Dif | Mul | Value Integer | LeftP | RightP deriving Show 
type Expression = [Item]

-- sample1 corresponde con 5 + (6 -2) * 3
sample1 = [Value 5, Add, LeftP, Value 6, Dif, Value 2, RightP, Mul, Value 3]

evaluateInFix :: Expression -> Stack Integer -> Stack Item -> Integer
evaluateInFix (x:xs) (y:z:ys) b 
    | (x:xs) == [] && (y:z:ys) == [y] = y 
    | x == Add = evaluateInFix xs (y:z:ys) (push Add b)
    | x == Dif = evaluateInFix xs (y:z:ys) (push Dif b)
    | x == Mul = evaluateInFix xs (y:z:ys) (push Mul b)
    | Integer x = evaluateInFix xs ()
    | x == LeftP = evaluateInFix xs (y:z:ys) b
    | x == RightP = evaluateInFix xs (push sol ys) (pop b)
            where sol 
                    | top b == "Add" = z+y 
                    | top b == "Dif" = z-y 
                    | top b == "Mul" = z*y

