
import Test.QuickCheck
import Data.List

-- Ej2

maximoYresto :: Ord a => [a] -> (a,[a])
maximoYresto [] = error "array vacio"
maximoYresto xs = (maximum xs, sol)
    where sol = [d | d <- xs, d /= maximum xs]
    -- where sol = filter (<x) xs

reparte :: [a] -> ([a],[a])
reparte [] = ([],[])
reparte [x] = ([x],[])
reparte (x:y:xs) = ([x]++a,[y]++b)
    where (a,b) = reparte xs 

distintos :: Eq a => [a] -> Bool
distintos [] = True
distintos (x:xs)
    | [d | d<-xs , d==x]/=[] = False
    -- (elem x xs) = False
    | otherwise = distintos xs 

replicate' :: Int -> a -> [a]
replicate' n x 
    | n == 0 = []
    | otherwise = x:replicate' (n-1) x

divideA :: Integer -> Integer -> Bool
divideA x d = x `mod` d == 0

divisores :: Integer -> [Integer]
divisores x = [d | d <- [1..x], divideA x d]

divisores' :: Integer -> [Integer]
divisores' x 
    | x > 0 = divisores x
    | x < 0 = xs ++ ys
    where
        ys = divisores (-x)
        xs = [(-d) | d <- ys]
        
mcd :: Integer -> Integer -> Integer
mcd x y = maximum ([d | d <- divisores' x, divideA y d])

prop_mcd x y z = x/=0 && y/=0 && z/=0 ==> mcd (z*x) (z*y) == abs(z)* (mcd x y)

esPrimo :: Integer -> Bool
esPrimo x = divisores x == [1,x]

primosHasta :: Integer -> [Integer]
primosHasta x = [d | d <-[1..x], esPrimo d]

primosHasta' :: Integer -> [Integer]
primosHasta' x = filter esPrimo [1..x]

take' :: Int -> [a] -> [a]
take' n xs = [x | (p,x)<-zip[0..(n-1)] xs]

drop' :: Int -> [a] -> [a]
drop' n xs = [x | (p,x)<- zip[0..(length xs)] xs, p <= n]

concat' :: [[a]]->[a]
concat' xs = foldr (++) [] xs 

{-
takeWhile' :: (a->Bool) -> [a] -> [a]
takeWhile f xs = foldr g [] xs
    where g cab solCola = f cab : solCola

takeWhile' f xs = [x | x<-xs, f x]
takeWhile' f (x:xs) 
    | f x = maximum([x | x<-xs, f x], takeWhile' )


takeWhile' f (x:xs)
    | f x = x:takeWhile' f xs 
    | otherwise = takeWhile' f xs
-}

inserta :: Ord a => a -> [a] -> [a]
inserta a [] =[a]
inserta a (x:xs)
    | a <= x = (a:x:xs)
    | a > x = x : inserta a xs 

ordena :: Ord a => [a] -> [a]
ordena xs = foldr inserta [] xs 

primeroComun :: Ord a => [a] -> [a] -> a 
primeroComun _ [] = error "no hay comun"
primeroComun [] _ = error "no hay comun"
primeroComun (x:xs) (y:ys)
    | x == y = x 
    | x < y = primeroComun xs (y:ys)
    | otherwise = primeroComun (x:xs) ys

primeroComunDeTres :: Ord a => [a] -> [a] -> [a] -> a 
primeroComunDeTres xs ys zs = resultado
    where
        x1 = [x | y<-ys, x<-xs, y==x]
        resultado = head [z | z<-zs, x<-x1, x==z]


-- 33,37,26, 28, 34, 35

--26

comb :: Ord a => Int -> [a] -> [[a]]
comb m xs
    | m==0 = []
    | m==(length xs) = [xs]
    | m==2 && (length xs)>2 = result
        where result = [] ++ (head xs, )
    | otherwise = tail xs : [head xs] ++ comb (m-1) xs 








