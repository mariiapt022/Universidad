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
empareja [] _ = []
empareja _ [] = []
empareja (x:xs) (y:ys) = [(x,y)] ++ empareja xs ys

prop_empareja_OK :: (Eq b, Eq a) => [a] -> [b] -> Bool
prop_empareja_OK xs ys = zip xs ys == empareja xs ys 

----------------------------------------------------------------------
-- Ejercicio - emparejaCon
----------------------------------------------------------------------

emparejaCon ::  (a -> b -> c) -> [a] -> [b] -> [c]
emparejaCon f [] _ = []
emparejaCon f _ [] = []
emprejaCon f (x:xs) (y:ys) = f x y : emparejaCon f xs ys 

prop_emparejaCon_OK :: Eq c => (a -> b -> c) -> [a] -> [b] -> Bool
prop_emparejaCon_OK f xs ys = emparejaCon xs ys == zipWith f xs ys 

----------------------------------------------------------------------
-- Ejercicio - separa
----------------------------------------------------------------------

separaRec :: (a -> Bool) -> [a] -> ([a], [a])
separaRec f [] = []
separaRec f (x:xs) 
    | f x = (x:true,false)
    | otherwise = (true,x:impares)
        where
            (true,false) = separaRec f xs


separaC :: (a -> Bool) -> [a] -> ([a], [a])
separaC f xs = ([x | x<-xs, f x],[y | y<-xs, not(f y)])

separaP :: (a -> Bool) -> [a] -> ([a], [a])
separaP f xs = foldr g ([],[]) xs
    where
        g cab solCola
            | f cab = (cab:a,b)
            | otherwise = (a,cab:b)
                where
                    (a,b) = solCola


prop_separa_OK :: Eq a => (a -> Bool) -> [a] -> Bool
prop_separa_OK f xs = separaRec f xs == separaC f xs && separaC f xs && separaP f xs == separaC f xs

----------------------------------------------------------------------
-- Ejercicio - lista de pares
----------------------------------------------------------------------

cotizacion :: [(String, Double)]
cotizacion = [("apple", 116), ("intel", 35), ("google", 824), ("nvidia", 67)]

buscarRec :: Eq a => a -> [(a,b)] -> [b]
buscarRec _ [] = []
buscarRec x (y:xs) 
    | x == fst y = [snd y]
    | otherwise = buscarRec x xs 

buscarC :: Eq a => a -> [(a, b)] -> [b]
buscarC x [] = []
buscarC x xs = [head [snd y | y <- xs, fst y == x]]

buscarP :: Eq a => a -> [(a, b)] -> [b]
buscarP x xs = foldr f [] xs
    where
        f cab solCola
            | x == fst cab = [snd cab]
            | otherwise = solCola

prop_buscar_OK :: (Eq a, Eq b) => a -> [(a, b)] -> Bool
prop_buscar_OK x xs = buscarC x xs == buscarP x xs

{-

Responde las siguientes preguntas si falla la propiedad anterior.

¿Por qué falla la propiedad prop_buscar_OK?

Realiza las modificaciones necesarias para que se verifique la propiedad.

-}

head' :: [Double] -> Double
head' [] = 0
head' xs = head xs 

valorCartera :: [(String, Double)] -> [(String, Double)] -> Double
valorCartera xs ys = sum (map (mapeado) [fst y | y <- xs])
    where
        mapeado = \x -> head' (buscaRec x ys) * head [snd z | z <- xs, fst z==x]


----------------------------------------------------------------------
-- Ejercicio - mezcla
----------------------------------------------------------------------

mezcla :: Ord a => [a] -> [a] -> [a]
mezcla (x:xs) (y:ys) 
    | x < y = [x] ++ mezcla xs (y:ys)
    | otherwise = [y] ++ mezcla (x:xs) ys

----------------------------------------------------------------------
-- Ejercicio - takeUntil
----------------------------------------------------------------------

takeUntil :: (a -> Bool) -> [a] -> [a]
takeUntil f (x:xs) 
    | f x = []
    | otherwise = [x] ++ takeUntil f xs 

prop_takeUntilOK :: Eq a => (a -> Bool) -> [a] -> Bool
prop_takeUntilOK f xs = takeWhile f (takeUntil f xs) == []

----------------------------------------------------------------------
-- Ejercicio - número feliz
----------------------------------------------------------------------

digitosDe :: Integer -> [Integer]
digitosDe x 
    | x==0 = []
    | otherwise = digitosDe (div x 10) ++ [mod x 10]

sumaCuadradosDigitos :: Integer -> Integer
sumaCuadradosDigitos x = sum (map (^2) (digitosDe x))

esFeliz :: Integer -> Bool
esFeliz x = esFelizAc [] x 
    where
        esFelizAc xs x 
            | x `elem` xs = False 
            | s == 1 = True 
            | otherwise = esFelizAc (x:xs) s 
            where
                s = sumaCuadradosDigitos x


felicesHasta :: Integer -> [Integer]
felicesHasta x = [y | y<-[1..x], esFeliz y]

{-

Responde a la siguiente pregunta.

¿Cuántos números felices hay menores o iguales que 1000?

-}

----------------------------------------------------------------------
-- Ejercicio - borrar
----------------------------------------------------------------------

borrarRec :: Eq a => a -> [a] -> [a]
borrarRec x (y:xs) 
    | x==y = borrarRec x xs 
    | otherwise = [y] ++ borrarRec x xs 

borrarC :: Eq a => a -> [a] -> [a]
borrarC x xs = [y | y<-xs, y/=x]

borrarP :: Eq a => a -> [a] -> [a]
borrarP x xs = foldr f [] xs
    where
        f cab solCola
            | cab == x = solCola
            | otherwise = [cab] ++ solCola

prop_borrar_OK :: Eq a => a -> [a] -> Bool
prop_borrar_OK x xs = borrarRec x xs == borrarC x xs && borrarC x xs == borrarP x xs

----------------------------------------------------------------------
-- Ejercicio - agrupar
----------------------------------------------------------------------

agrupar :: Eq a => [a] -> [[a]]
agrupar xs = foldr f [] xs 
    where    f x []     = [[x]]
             f x (y:xs) | x == (head y) = ((x:y):xs)
                        | otherwise = ([x]:y:xs)

{-
agrupar2 :: Eq a => [a] -> [[a]]
agrupar2 (x:y:xs)
    | length xs == 0 = [[x]++[y]]
    | length xs == 1 = [[x]++[y]++xs]
    | length xs >0 && x==y = [[x]++[y]] ++ agrupar2 xs
    | otherwise = [x] ++ [y] ++ agrupar2 xs
-}


----------------------------------------------------------------------
-- Ejercicio - aplica
----------------------------------------------------------------------

aplicaRec :: a -> [ a -> b] -> [b]
aplicaRec _ [] = []
aplicaRec x (y:xs) = [y x] ++ aplicaRec x xs 

aplicaC :: a -> [ a -> b] -> [b]
aplicaC x xs = [f x | f <- xs]

aplicaP :: a -> [ a -> b] -> [b]
aplicaP x xs = foldr f [] xs
    where
        f cab solCola = cab x:solCola

aplicaM :: a -> [ a -> b] -> [b]
aplicaM x [] = []
aplicaM x (y:xs) = map y [x] ++ aplicaM x xs

prop_aplica_OK :: Eq b => a -> [a -> b] -> Bool
prop_aplica_OK x xs = aplicaRec x xs == aplicaC x xs && aplicaP x xs == aplicaM x xs && aplicaRec x xs == aplicaP x xs

