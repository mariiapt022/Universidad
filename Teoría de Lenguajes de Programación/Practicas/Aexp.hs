{-

Programming Languages
Fall 2024

Semantics of Arithmetic Expressions

-}

module Aexp where

-- |----------------------------------------------------------------------
-- | Exercise 1 - Abstract Syntax and Semantics of Aexp
-- |----------------------------------------------------------------------
-- | Define the algebraic data type 'Aexp' for representing arithmetic
-- | expressions.

type VarId = String

data  Aexp  =  NumLit Integer
            |  Var VarId
            |  Add Aexp Aexp
            |  Mul Aexp Aexp
            |  Sub Aexp Aexp
            deriving Show

exp0 :: Aexp
exp0 = Add (Mul (Var "x") (NumLit 3)) (Sub (Var "y")(NumLit 5))

-- | Define the function 'aval' that computes the value of an arithmetic

-- | expression in a given state.

type Z = Integer
type State = VarId -> Z

-- s0 = { x -> 5, y -> 7, z -> -2 }
s0 :: State 
s0 "x" = 5
s0 "y" = 7
s0 "z" = -2
s0 _ = 0

nVal :: LitNum -> Z 
nVal n = read n 

aVal :: Aexp -> State -> Z
aVal (NumLit n) s = nVal n
aVal (Var x) s = s x
aVal (Add a1 a2) s = aVal a1 s + aVal a2 s
aVal (Mul a1 a2) s = aVal a1 s * aVal a2 s
aVal (Sub a1 a2) s = aVal a1 s - aVal a2 s



-- |----------------------------------------------------------------------
-- | Exercise 2 - Free variables of expressions
-- |----------------------------------------------------------------------
-- | Define the function 'fvAexp' that computes the set of free variables
-- | occurring in an arithmetic expression. Ensure that each free variable
-- | occurs only once in the resulting list.

fvAexp :: Aexp -> [VarId]
fvAexp = undefined

-- |----------------------------------------------------------------------
-- | Exercise 3 - Substitution of variables in expressions
-- |----------------------------------------------------------------------
-- | Define the algebraic data type 'Subst' for representing substitutions.

data Subst = VarId :->: Aexp

-- | Define a function 'substAexp' that takes an arithmetic expression
-- | 'a' and a substitution 'y -> a0' and returns the substitution 'a [y -> a0]';
-- | i.e., replaces every occurrence of 'y' in 'a' by 'a0'.

substAexp :: untyped
substAexp = undefined

-- |----------------------------------------------------------------------
-- | Exercise 4 - Update of state
-- |----------------------------------------------------------------------
-- | Define the algebraic data type 'Update' for representing state updates.

data Update = VarId :=>: Z

-- | Define a function 'update' that takes a state 's' and an update 'x -> v'
-- | and returns the updated state 's [x -> v]'

update :: State -> Update -> State
update s (y :=>: v) x = if x == y then v else s x 

-- | Define a function 'updates' that takes a state 's' and a list of updates
-- | 'us' and returns the updated states resulting from applying the updates
-- | in 'us' from head to tail. For example:
-- |
-- |    updates s {x -> 1, y > 2, x -> 3}
-- |
-- | returns a state that binds 'x' to 3 (the most recent update for 'x').

updates :: untyped
updates = undefined

-- |----------------------------------------------------------------------
-- | Exercise 5 - Folding expressions
-- |----------------------------------------------------------------------
-- | Define a function 'foldAexp' to fold an arithmetic expression.

foldAexp :: (LitNum -> b) -> (VarId -> b) -> (b->b->b) -> (b->b->b) -> (b->b->b) -> Aexp -> b
foldAexp nl v add mul sub a = recAexp a 
    where
        recAexp (NumLit n) = nl n 
        recAexp (Var x) = v x 
        recAexp (Add a1 a2) = ad (recAexp a1) (recAexp x2)

-- | Use 'foldAexp' to define the functions 'aVal', 'fvAexp', and 'substAexp'.

aVal' :: Aexp -> State -> Z
aVal' a s = foldAexp nVal s (+) (*) (-) a 

fvAexp' :: untyped
fvAexp' = undefined

substAexp' :: Aexp -> Subst -> Aexp
substAexp' a (x:->:a0) = foldAexp NumLit subsVar Add Mul Sub a 
    where 
    -- subsVar :: VarId -> Aexp
        subsVar y = if y == x then a0 else Var y
