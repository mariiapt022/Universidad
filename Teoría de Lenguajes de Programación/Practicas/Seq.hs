----------------------------------------------------------------
-- Lenguajes de Programación
-- 4 del Grado en Ingeniería Informática, mención en Computación
-- Pablo López
----------------------------------------------------------------

{-# LANGUAGE DeriveFoldable #-}
{-# LANGUAGE DeriveFunctor  #-}

module Seq where

data Seq a = Nil
           | Cons a (Seq a)
           deriving (Show, Functor, Foldable)

-- |
-- >>> list2seq [1..5]
-- Cons 1 (Cons 2 (Cons 3 (Cons 4 (Cons 5 Nil))))
list2seq :: [Integer] -> Seq Integer
list2seq = foldr Cons Nil

seq1_5 :: Seq Integer
seq1_5 = list2seq [1..5]

-- |
-- >>> aplica (*2) seq1_5
-- Cons 2 (Cons 4 (Cons 6 (Cons 8 (Cons 10 Nil))))
aplica :: untyped
aplica = undefined

-- |
-- >>> plegar (+) 0 seq1_5
-- 15
plegar :: untyped
plegar = undefined
