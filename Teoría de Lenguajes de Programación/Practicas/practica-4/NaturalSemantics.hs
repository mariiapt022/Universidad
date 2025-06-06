{-|

Programming Languages
Fall 2024

Implementation of the Natural Semantics of the WHILE Language
with Blocks and Procedures (Static Scope)

Author:

-}

module NaturalSemantics where

import           Aexp
import           Bexp
import           State
import           While

{-

  WHILE is an imperative, block-structured programming language with
  static scope and parameterless procedures.

  Note two important differences with respect to the PROC language as
  defined by Nielson & Nielson.

  First, in PROC 'next' is a special location (a register) that refers
  to the next free cell in the store. In WHILE, 'next' is stored at
  the location 0 of the store.

  Second, in PROC global variables (i.e., undefined variables) are
  stored in location 0 of the store. This means that global variables
  are aliased: there is only one global variable. The advantage of
  this approach is that the variable environment is a total function.
  However, in WHILE global variables are not allowed. Accessing an
  undefined (global) variable raises a runtime error. Therefore, the
  variable environment is a partial function. Similarly, accessing a
  non-allocated location raises a runtime error, thus the store is a
  partial function.

-}

----------------------------------------------------------------------
-- Variable Declarations
----------------------------------------------------------------------

-- locations

type Loc = Z

-- variable environment

type EnvVar = Var -> Loc

-- store

type Store = Loc -> Z

-- the register 'next' is actually stored at location 0 of the store:
-- 'sto next' refers to the first available cell in the store 'sto'

next :: Loc
next = 0

-- rudimentary stack-based memory allocation
new :: Loc -> Loc
new l = l + 1

{-

   After processing the local variable declarations:

     var x:= 8;
     var y:= 5;

   we get the envV and sto shown below:

                        ┌───────┐
                      3 │       │◄──────┐
                        ├───────┤       │
                      2 │   5   │       │
      x ──► 1           ├───────┤       │
                      1 │   8   │       │
      y ──► 2           ├───────┤       │
                      0 │   3   ├───────┘
                        └───────┘  next

       envV                sto

-}

-- | Exercise 1.1 - update envV and sto

-- update a variable environment with a new binding envV [x -> l]
updateV :: EnvVar -> Var -> Loc -> EnvVar
updateV envV x l = \ y -> if y == x then l else envV y

-- update a store with a new binding sto [l -> v]
updateS :: Store -> Loc -> Z -> Store
updateS sto l v = \ p -> if p == l then v else sto p

-- | Exercise 1.2 - natural semantics for variable declarations

-- variable declaration configurations

data ConfigD = InterD DecVar EnvVar Store  -- <Dv, envV, store>
             | FinalD EnvVar Store         -- <envV, store>

nsDecV :: ConfigD -> ConfigD

-- var x:= a
nsDecV (InterD (Dec x a decs) envV store) = nsDecV (InterD decs envV' store')
  where
    l = store next
    v = aVal a (store. envV)
    envV' = updateV envV x l
    store' = updateS (updateS store l v) next (new l)

-- epsilon
nsDecV (InterD EndDec envV store)         = FinalD envV store

----------------------------------------------------------------------
-- Procedure Declarations
----------------------------------------------------------------------

-- procedure environment (note this environment is not a function)

--                    p    s    snapshots    previous
--                    |    |     /     \        |
data EnvProc = EnvP Pname Stm EnvVar EnvProc EnvProc
             | EmptyEnvProc

-- | Exercise 2.1 - update envP

-- update the procedure environment envP
updP :: DecProc -> EnvVar -> EnvProc -> EnvProc
updP (Proc p s procs) envV envP = updP procs envV (EnvP p s envV envP envP)
updP EndProc envV envP          = envP

-- | Exercise 2.2 - look up procedure definitions

-- lookup procedure p
envProc :: EnvProc -> Pname -> (Stm, EnvVar, EnvProc)
envProc (EnvP q s envV envP envs) p = if p == q then (s, envV, envP) else envProc envs p
envProc EmptyEnvProc p              = error $ "undefined procedure " ++ p

----------------------------------------------------------------------
-- Natural Semantics for WHILE
----------------------------------------------------------------------

-- representation of configurations for WHILE

data Config = Inter Stm Store  -- <S, sto>
            | Final Store      -- sto

-- representation of the transition relation envV, envP |- <S, sto> -> sto'

nsStm :: EnvVar -> EnvProc -> Config -> Config

-- | Exercise 3.1

nsStm = undefined

-- semantic function for Natural Semantics
sNs :: Stm -> Store -> Store
sNs s sto = sto'
   where
     Final sto' = nsStm initEnvV EmptyEnvProc (Inter s sto)
     initEnvV :: EnvVar
     initEnvV x = error $ "undefined variable " ++ x
