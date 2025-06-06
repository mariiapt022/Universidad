-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º ETSI Informática. UMA
-- Práctica 6 - Árboles generales en Haskell
--
-- Alumno: APELLIDOS, NOMBRE
-------------------------------------------------------------------------------

module Exercise7 where

import qualified DataStructures.Queue.LinearQueue as Q

data Tree a = Empty
            | Node a [Tree a]
            deriving Show

gtree1 :: Tree Int
gtree1 =
  Node 1 [ Node 2 [ Node 4 [ ]
                  , Node 5 [ ]
                  , Node 6 [ ]
                  ]
         , Node 3 [ Node 7 [ ] ]
         ]

-- |
-- >>> levels gtree1
-- [1,2,3,4,5,6,7]
levels :: Tree a -> [a]
levels Empty = []
levels (Node x xs) = [x] ++ levels' xs 

levels' :: [Tree a] -> [a] 
levels' [] = []
levels' ((Node x xs):ys) = [x] ++ (levels' xs) ++ (levels' ys)