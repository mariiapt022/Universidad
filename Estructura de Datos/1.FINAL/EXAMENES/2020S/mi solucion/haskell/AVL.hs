{------------------------------------------------------------------------------
 - Student's name:
 -
 - Student's group:
 -----------------------------------------------------------------------------}

module AVL 
  ( 
    Weight
  , Capacity
  , AVL (..)
  , Bin
  , emptyBin
  , remainingCapacity
  , addObject
  , maxRemainingCapacity
  , height
  , nodeWithHeight
  , node
  , rotateLeft
  , addNewBin
  , addFirst
  , addAll
  , toList
  , linearBinPacking
  , seqToList
  , addAllFold
  ) where

type Capacity = Int
type Weight= Int

data Bin = B Capacity [Weight] 

data AVL = Empty | Node Bin Int Capacity AVL AVL deriving Show


emptyBin :: Capacity -> Bin
emptyBin cap = B cap []

remainingCapacity :: Bin -> Capacity
remainingCapacity (B cap xs) = cap

addObject :: Weight -> Bin -> Bin
addObject w (B cap xs) = B (cap-w) (w:xs)

maxRemainingCapacity :: AVL -> Capacity
maxRemainingCapacity (Node bin h cap lt rt) = cap
maxRemainingCapacity Empty = 0

height :: AVL -> Int
height (Node bin h cap lt rt) = h
height Empty = 0


nodeWithHeight :: Bin -> Int -> AVL -> AVL -> AVL
nodeWithHeight bin@(B cap xs) alt lt rt = Node bin alt cap' lt rt 
  where
    cap' = max (cap) (maxHijos)
    maxHijos = max (maxRemainingCapacity lt) (maxRemainingCapacity rt)


node :: Bin -> AVL -> AVL -> AVL
node bin lt rt = nodeWithHeight bin h lt rt 
  where h = 1 + max (height lt) (height rt)

rotateLeft :: Bin -> AVL -> AVL -> AVL
rotateLeft c lt (Node bin alt cap rlt rrt) = node bin (node c lt rlt) rrt

addNewBin :: Bin -> AVL -> AVL
addNewBin bin@(B cap xs) Empty = Node bin 1 cap Empty Empty
addNewBin bin (Node bin' alt cap lt rt) 
  |(height rt) - (height lt) > 1 = rotateLeft bin' lt (addNewBin bin rt)
  | otherwise = Node bin' alt cap lt (addNewBin bin rt)
 
addFirst :: Capacity -> Weight -> AVL -> AVL
addFirst cap w avl@Empty = addNewBin (B (cap-w) [w]) avl
addFirst cap w avl@(Node bin alt c lt rt)
  | w > c = addNewBin (B (cap-w) [w]) avl 
  | w <= (remainingCapacity bin) = Node (addObject w bin) alt c lt rt
  | w <= (maxRemainingCapacity lt) = Node bin alt c (addFirst cap w lt) rt
  | otherwise = Node bin alt c lt (addFirst cap w rt)

addAll:: Capacity -> [Weight] -> AVL
addAll cap pesos = addAllAux cap pesos Empty
  where
    addAllAux cap [] solucion = solucion
    addAllAux cap (p:ps) solucion = addAllAux cap ps (addFirst cap p solucion)

toList :: AVL -> [Bin]
toList Empty = []
toList (Node bin alt cap lt rt) = toList lt ++ [bin] ++ toList rt

{-
	SOLO PARA ALUMNOS SIN EVALUACION CONTINUA
  ONLY FOR STUDENTS WITHOUT CONTINUOUS ASSESSMENT
 -}

data Sequence = SEmpty | SNode Bin Sequence deriving Show  

linearBinPacking:: Capacity -> [Weight] -> Sequence
linearBinPacking _ _ = undefined

seqToList:: Sequence -> [Bin]
seqToList _ = undefined

addAllFold:: [Weight] -> Capacity -> AVL 
addAllFold _ _ = undefined



{- No modificar. Do not edit -}

objects :: Bin -> [Weight]
objects (B _ os) = reverse os

  
instance Show Bin where
  show b@(B c os) = "Bin("++show c++","++show (objects b)++")"