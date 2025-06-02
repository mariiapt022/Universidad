-------------------------------------------------------------------------------
-- Estructuras de Datos. Grado en Informática, IS e IC. UMA.
-- Examen de Febrero 2015.
--
-- Implementación del TAD Deque
--
-- Apellidos:
-- Nombre:
-- Grado en Ingeniería ...
-- Grupo:
-- Número de PC:
-------------------------------------------------------------------------------

module TwoListsDoubleEndedQueue
   ( DEQue
   , empty
   , isEmpty
   , first
   , last
   , addFirst
   , addLast
   , deleteFirst
   , deleteLast
   ) where

import Prelude hiding (last)
import Data.List(intercalate)
import Test.QuickCheck

data DEQue a = DEQ [a] [a]

-- Complexity:
empty :: DEQue a
empty = DEQ [] []

-- Complexity:
isEmpty :: DEQue a -> Bool
isEmpty (DEQ [] []) = True
isEmpty (DEQ _ _) = False

-- Complexity:
addFirst :: a -> DEQue a -> DEQue a
addFirst x (DEQ [] []) = DEQ [x] []
addFirst x (DEQ xs ys) = DEQ (x:xs) ys

-- Complexity:
addLast :: a -> DEQue a -> DEQue a
addLast x (DEQ [] []) = DEQ [] [x]
addLast x (DEQ xs ys) = DEQ xs (x:ys)

-- Complexity:
first :: DEQue a -> a
first (DEQ [] []) = error ""
first (DEQ (x:xs) ys) = x

-- Complexity:
last :: DEQue a -> a
last (DEQ [] []) = error ""
last (DEQ xs (y:ys)) = y

-- Complexity:
deleteFirst :: DEQue a -> DEQue a
deleteFirst (DEQ [] []) = DEQ [] []
deleteFirst (DEQ (x:xs) ys) = DEQ xs ys 
deleteFirst (DEQ [] ys) = deleteFirst (DEQ (reverse xs') ys')
   where
      (ys',xs') = splitAt mitad ys
      mitad
         | length ys `mod` 2 ==0 = length ys `div` 2
         | otherwise = (length ys `div` 2) + 1


-- Complexity:
deleteLast :: DEQue a -> DEQue a
deleteLast (DEQ [] []) = DEQ [] []
deleteLast (DEQ xs (y:ys)) = DEQ xs ys 
deleteLast (DEQ xs []) = deleteLast (DEQ xs' (reverse ys') )
   where
      (xs',ys')= splitAt mitad xs 
      mitad = length xs `div` 2


instance (Show a) => Show (DEQue a) where
   show q = "TwoListsDoubleEndedQueue(" ++ intercalate "," [show x | x <- toList q] ++ ")"

toList :: DEQue a -> [a]
toList (DEQ xs ys) =  xs ++ reverse ys

instance (Eq a) => Eq (DEQue a) where
   q == q' =  toList q == toList q'

instance (Arbitrary a) => Arbitrary (DEQue a) where
   arbitrary =  do
      xs <- listOf arbitrary
      ops <- listOf (oneof [return addFirst, return addLast])
      return (foldr id empty (zipWith ($) ops xs))
