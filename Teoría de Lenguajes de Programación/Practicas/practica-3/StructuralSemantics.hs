{-|

Programming Languages
Fall 2024

Implementation of the Structural Operational Semantics of the WHILE Language

Author:

-}

module StructuralSemantics where

import           Aexp
import           Bexp
import           State
import           While

-- representation of configurations for WHILE

data Config = Inter Stm State  -- <S, s>
            | Final State      -- s
            | Stuck Stm State  -- <S, s>

isFinal :: Config -> Bool
isFinal (Final _) = True
isFinal _         = False

isInter :: Config -> Bool
isInter (Inter _ _) = True
isInter _           = False

isStuck :: Config -> Bool
isStuck (Stuck _ _) = True
isStuck _           = False

-- representation of the transition relation <S, s> => gamma

sosStm :: Config -> Config

-- x := a

sosStm (Inter (Ass x a) s) = Final (update s x (aVal a s))
    where
        update s x v = \ y -> if y==x then x else s y

-- skip

sosStm (Inter Skip s) = Final s


-- s1; s2

sosStm (Inter (Comp ss1 ss2) s)
    | isInter gamma = Inter (Comp ss1' ss2) s'
    where
        gamma = sosStm (Inter ss1 s)
        Inter ss1' s' = gamma

sosStm (Inter (Comp ss1 ss2) s)
    | isFinal gamma = Inter ss2 s'
    where
        gamma = sosStm (Inter ss1 s)
        Final s' = gamma

sosStm (Inter (Comp ss1 ss2) s)
    | isStuck gamma = Stuck (Comp ss1 ss2) s
    where
        gamma = sosStm (Inter ss1 s)
        Stuck ss' s' = gamma

-- if b then s1 else s2

sosStm (Inter (If b ss1 ss2) s)
    | bVal b s = sosStm (Inter ss1 s)

sosStm (Inter (If b ss1 ss2) s)
    | not (bVal b s) = sosStm (Inter ss2 s)

-- while b do s
sosStm (Inter (While b ss) s) = Inter (If b (Comp ss (While b ss)) Skip) s
    


-- repeat s until b

-- todo

-- for x a1 to a2 s

-- todo

-- abort

sosStm (Inter Abort s) = Stuck Abort s
