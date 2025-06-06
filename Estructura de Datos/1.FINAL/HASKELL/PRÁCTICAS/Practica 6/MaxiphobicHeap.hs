-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º Curso. ETSI Informática. UMA
--
-- PRACTICA 6. Montículos maxifóbicos en Haskel
--
-- Alumno: APELLIDOS, NOMBRE
-------------------------------------------------------------------------------

-- Solo tienes que completar el código de la función 'merge' de acuerdo con
-- las explicaciones del enunciado.

module MaxiphobicHeap
  ( Heap
  , empty
  , isEmpty
  , minElem
  , delMin
  , insert
  , merge
-- los siguientes son auxiliares
  , mkHeap
  , verifyOP
  , drawOnWith
  ) where

import           DataStructures.Graphics.DrawTrees
import           Test.QuickCheck

data Heap a = Empty | Node a Int (Heap a) (Heap a) deriving Show

-- number of elements
size :: Heap a -> Int
size Empty           = 0
size (Node _ sz _ _) = sz

empty :: Heap a
empty  = Empty

isEmpty :: Heap a -> Bool
isEmpty Empty = True
isEmpty _     = False

singleton :: a -> Heap a
singleton x  = Node x 1 Empty Empty

insert :: (Ord a) => a -> Heap a -> Heap a
insert x h  = merge h (singleton x)

minElem :: Heap a -> a
minElem Empty          = error "minElem on empty heap"
minElem (Node x _ _ _) = x

delMin :: (Ord a) => Heap a -> Heap a
delMin Empty            = error "delMin on empty heap"
delMin (Node _ _ lh rh) = merge lh rh

----------------------------------------------------------
-- VVVVVVVVVVVV-SOLO TOCAR ABAJO-VVVVVVVVVVVV-------------
----------------------------------------------------------

-- recursively merges smallest subheaps. Achieves O(log n) complexity
sort3 :: Heap a -> Heap a -> Heap a -> (Heap a, Heap a, Heap a)
sort3 h1 h2 h3
  | s1 >= s2 && s1 >= s3 = (h1,h2,h3)
  | s2 >= s1 && s2 >= s3 = (h2,h1,h3)
  | otherwise = (h3,h1,h2)
    where
      s1 = size h1 
      s2 = size h2
      s3 = size h3

merge :: (Ord a) => Heap a -> Heap a -> Heap a
merge Empty h2 = h2 
merge h1 Empty = h1 
merge h1@(Node a pa ai ad) h2@(Node b pb bi bd)
  | a<b = combina a ai ad h2
  | otherwise = combina b h1 bi bd
  where
    combina x h1 h2 h3 = Node x (pa+pb) winner (merge l1 l2)
      where 
        (winner,l1,l2) = sort3 h1 h2 h3
  
----------------------------------------------------------
-- ^^^^^^^^^^^^^^-- SOLO TOCAR ARRIBA ^^^^^^^^^^^ --------
----------------------------------------------------------

-- Efficient O(n) bottom-up construction for heaps
mkHeap :: (Ord a) => [a] -> Heap a
mkHeap []  = empty
mkHeap xs  = mergeLoop (map singleton xs)
  where
    mergeLoop [h] = h
    mergeLoop hs  = mergeLoop (mergePairs hs)

    mergePairs []        = []
    mergePairs [h]       = [h]
    mergePairs (h:h':hs) = merge h h' : mergePairs hs

-------------------------------------------------------------------------------
-- Generating arbitrary Heaps
-------------------------------------------------------------------------------

instance (Ord a, Arbitrary a) => Arbitrary (Heap a) where
  arbitrary  = do
    xs <- arbitrary
    return (mkHeap xs)

-------------------------------------------------------------------------------
-- Invariants
-------------------------------------------------------------------------------

verifyOP :: (Ord a) => Heap a -> Bool
verifyOP Empty             = True
verifyOP (Node x _ lh rh)  = x `lessEq` lh && x `lessEq` rh
                           && verifyOP lh && verifyOP rh
 where
  x `lessEq` Empty           = True
  x `lessEq` (Node x' _ _ _) = x<=x'

-------------------------------------------------------------------------------
-- Drawing a Heap
-------------------------------------------------------------------------------

instance Subtrees (Heap a) where
  subtrees Empty            = []
  subtrees (Node _ _ lh rh) = [lh,rh]

  isEmptyTree Empty = True
  isEmptyTree _     = False

instance (Show a) => ShowNode (Heap a) where
  showNode (Node x _ _ _) = show x

drawOnWith :: FilePath -> (a -> String) -> Heap a -> IO ()
drawOnWith file toString = _drawOnWith file showHeap
 where
  showHeap (Node x _ _ _) = toString x
