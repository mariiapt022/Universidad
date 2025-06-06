-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º ETSI Informática. UMA
-- Práctica 2 - Ejercicios extra
--
-- Alumno: APELLIDOS, NOMBRE
-------------------------------------------------------------------------------

module Practica2Extra where

import           Data.Char
import           Test.QuickCheck
import           Text.Show.Functions

----------------------------------------------------------------------
-- Ejercicio - empareja
----------------------------------------------------------------------

empareja :: [a] -> [b] -> [(a, b)]
empareja = undefined

prop_empareja_OK :: (Eq b, Eq a) => [a] -> [b] -> Bool
prop_empareja_OK = undefined

----------------------------------------------------------------------
-- Ejercicio - emparejaCon
----------------------------------------------------------------------

emparejaCon ::  (a -> b -> c) -> [a] -> [b] -> [c]
emparejaCon = undefined

prop_emparejaCon_OK :: Eq c => (a -> b -> c) -> [a] -> [b] -> Bool
prop_emparejaCon_OK = undefined

----------------------------------------------------------------------
-- Ejercicio - separa
----------------------------------------------------------------------

separaRec :: (a -> Bool) -> [a] -> ([a], [a])
separaRec = undefined

separaC :: (a -> Bool) -> [a] -> ([a], [a])
separaC = undefined

separaP :: (a -> Bool) -> [a] -> ([a], [a])
separaP = undefined

prop_separa_OK :: Eq a => (a -> Bool) -> [a] -> Bool
prop_separa_OK = undefined

----------------------------------------------------------------------
-- Ejercicio - lista de pares
----------------------------------------------------------------------

cotizacion :: [(String, Double)]
cotizacion = [("apple", 116), ("intel", 35), ("google", 824), ("nvidia", 67)]

buscarRec :: Eq a => a -> [(a,b)] -> [b]
buscarRec = undefined

buscarC :: Eq a => a -> [(a, b)] -> [b]
buscarC = undefined

buscarP :: Eq a => a -> [(a, b)] -> [b]
buscarP = undefined

prop_buscar_OK :: (Eq a, Eq b) => a -> [(a, b)] -> Bool
prop_buscar_OK = undefined

{-

Responde las siguientes preguntas si falla la propiedad anterior.

¿Por qué falla la propiedad prop_buscar_OK?

Realiza las modificaciones necesarias para que se verifique la propiedad.

-}

valorCartera :: [(String, Double)] -> [(String, Double)] -> Double
valorCartera = undefined

----------------------------------------------------------------------
-- Ejercicio - mezcla
----------------------------------------------------------------------

mezcla :: Ord a => [a] -> [a] -> [a]
mezcla = undefined

----------------------------------------------------------------------
-- Ejercicio - takeUntil
----------------------------------------------------------------------

takeUntil :: (a -> Bool) -> [a] -> [a]
takeUntil = undefined

prop_takeUntilOK :: Eq a => (a -> Bool) -> [a] -> Bool
prop_takeUntilOK = undefined

----------------------------------------------------------------------
-- Ejercicio - número feliz
----------------------------------------------------------------------

digitosDe :: Integer -> [Integer]
digitosDe = undefined

sumaCuadradosDigitos :: Integer -> Integer
sumaCuadradosDigitos = undefined

esFeliz :: Integer -> Bool
esFeliz = undefined

felicesHasta :: Integer -> [Integer]
felicesHasta = undefined

{-

Responde a la siguiente pregunta.

¿Cuántos números felices hay menores o iguales que 1000?

-}

----------------------------------------------------------------------
-- Ejercicio - borrar
----------------------------------------------------------------------

borrarRec :: Eq a => a -> [a] -> [a]
borrarRec = undefined

borrarC :: Eq a => a -> [a] -> [a]
borrarC = undefined

borrarP :: Eq a => a -> [a] -> [a]
borrarP = undefined

prop_borrar_OK :: Eq a => a -> [a] -> Bool
prop_borrar_OK = undefined

----------------------------------------------------------------------
-- Ejercicio - agrupar
----------------------------------------------------------------------

agrupar :: Eq a => [a] -> [[a]]
agrupar = undefined

----------------------------------------------------------------------
-- Ejercicio - aplica
----------------------------------------------------------------------

aplicaRec :: a -> [ a -> b] -> [b]
aplicaRec = undefined

aplicaC :: a -> [ a -> b] -> [b]
aplicaC = undefined

aplicaP :: a -> [ a -> b] -> [b]
aplicaP = undefined

aplicaM :: a -> [ a -> b] -> [b]
aplicaM = undefined

prop_aplica_OK :: Eq b => a -> [a -> b] -> Bool
prop_aplica_OK = undefined
