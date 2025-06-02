-- Aexp.hs - Implementation of Aexp

-- -------------------------------------------------------------------
-- Abstract syntax of arithmetic expressions
-- -------------------------------------------------------------------

module Aexp where

import           State

type  NumLit = String

data  Aexp  =  N NumLit
            |  V Var
            |  Add Aexp Aexp
            |  Mult Aexp Aexp
            |  Sub Aexp Aexp
            deriving (Show, Eq)

---------------------------------------------------------------------
-- Semantics of arithmetic expressions
---------------------------------------------------------------------

numLit :: NumLit -> Z
numLit = read

aVal :: Aexp -> State -> Z
aVal (N n) _        =  numLit n
aVal (V x) s        =  s x
aVal (Add a1 a2) s  =  aVal a1 s + aVal a2 s
aVal (Mult a1 a2) s =  aVal a1 s * aVal a2 s
aVal (Sub a1 a2) s  =  aVal a1 s - aVal a2 s

reduce :: Aexp -> Aexp
reduce (N n)        =  N n
reduce (V x)        =  V x
reduce (Add a1 a2)  =  let a1' = reduce a1
                           a2' = reduce a2
                       in case (a1', a2') of
                            (N n1, N n2) -> N (show (numLit n1 + numLit n2))
                            _            -> Add a1' a2'
reduce (Mult a1 a2)  =  let a1' = reduce a1
                            a2' = reduce a2
                       in case (a1', a2') of
                            (N n1, N n2) -> N (show (numLit n1 * numLit n2))
                            _            -> Mult a1' a2'
reduce (Sub a1 a2)  =  let a1' = reduce a1
                           a2' = reduce a2
                       in case (a1', a2') of
                            (N n1, N n2) -> N (show (numLit n1 - numLit n2))
                            _            -> Sub a1' a2'

swap :: V -> V -> State -> State
swap (V x) (V y) s = \ z -> if z == x then s y else if z == y then s x else s z