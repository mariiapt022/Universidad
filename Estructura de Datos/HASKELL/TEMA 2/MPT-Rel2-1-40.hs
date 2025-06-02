-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º Curso. ETSI Informática. UMA
--
-- Titulación: Doble Grado en Ingeniería Informática y Matemáticas.
-- Alumno: Peinado Toledo, María
-- Fecha de entrega: DIA | MES | AÑO
--
-- Relación de Ejercicios 2. Ejercicios resueltos: 1-40
--
-------------------------------------------------------------------------------
import Test.QuickCheck
import Data.List

-- Ejercicio 1
-- a) (<<)
data Direction = North | South | East | West deriving (Eq,Enum,Show)

(<<) :: Direction -> Direction -> Bool
(<<) x y = fromEnum x < fromEnum y 

p_menor x y = (x < y) == (x << y)
instance Arbitrary Direction where
    arbitrary = do
        n <- choose (0,3)
        return $ toEnum n

-- b) Ord
instance Ord Direction
    where
        North <= _ = True
        South <= North = False
        South <= _ = True
        East <= North = True
        East <= South = True
        East <= _ = False
        West <= North = False
        West <= South = False
        West <= East = False
        West <= _ = True


-- Ejercicio 2
-- a) máximoYresto orden arbitrario
máximoYResto :: Ord a => [a] -> (a,[a])
máximoYResto [] = error "máximoYResto: Lista vacía"
máximoYResto (xs) = (x,ys)
    where
        x = maximum xs
        ys = filter (<x) xs

-- b) máximoYresto orden importa
máximoYRestoOrden :: Ord a => [a] -> (a,[a])
máximoYRestoOrden [] = error "máximoYresto: Lista vacía"
máximoYRestoOrden (xs) = (x,ys)
    where
        x = maximum xs
        ys = sort(filter (<x) xs)

-- Ejercicio 3
reparte :: [a] -> ([a],[a])
reparte [x] = ([x],[])
reparte (x:y:xs) = (x:a,y:b)
    where
        (a,b) = reparte xs

-- Ejercicio 4
distintos :: Eq a => [a] -> Bool
distintos [] = True
distintos (x:xs)
    | (elem x xs) = False
    | otherwise = distintos xs 

-- Ejercicio 5
-- a) replicate'
replicate' :: Int -> a -> [a]
replicate' 0 x = []
replicate' n x = x : replicate' (n-1) x 

-- b) propiedad
p_replicate' n x = n >= 0 && n <= 1000 ==> length (filter (==x) xs) == n && length (filter(/=x) xs) == 0 
    where xs = replicate' n x 

-- Ejercicio 6
divideA :: Integer -> Integer -> Bool
divideA x y = mod y x == 0

divisores :: Integer -> [Integer]
divisores x 
    | x <= 0 = error "divisores: argumento <=0"
    | otherwise = [d| d <-[1..x], divideA d x]

divisores' :: Integer -> [Integer]
divisores' x 
    | x == 0 = error "divisores': argumento = 0"
    | otherwise = ys ++ xs
    where
        xs = divisores x 
        ys = [d | d <-[(-x)..(-1)], divideA d x]

-- Ejercicio 7
-- a) mcd
mcd :: Integer -> Integer -> Integer
mcd x y = maximum ([d| d <- divisores (abs(x)), divideA d (abs(y))])

-- b) quickCheck
prop_mcd x y z = x/=0 && y/=0 && z/=0 ==> mcd (z*x) (z*y) == abs(z) * (mcd x y)

-- c) mcd y mcm
mcm :: Integer -> Integer -> Integer
mcm x y = div (x*y) (mcd x y)

-- Ejercicio 8
-- a) esPrimo
esPrimo :: Integer -> Bool
esPrimo x 
    | (x <= 0) = error "Argumento no positivo"
    | (x > 0) && (divisores x == [1,x]) = True
    | otherwise = False

-- b) primosHasta
primosHasta :: Integer -> [Integer]
primosHasta x 
        | (x<=0) = error "primosHasta: argumento no positivo"
        | otherwise = [d| d<-[2..x], esPrimo d]

-- c) primosHasta'
primosHasta' :: Integer -> [Integer]
primosHasta' x 
    | (x<=0) = error "Argumento no positivo"
    | otherwise = filter (esPrimo) [1..x]

-- d) quickCheck
p1_primos x = primosHasta x == primosHasta' x

-- Ejercicio 9
-- a) pares
pares :: Integer -> [(Integer,Integer)]
pares x 
    | mod x 2 /= 0 = []
    | otherwise = [(a,b)|a<-[1..x], b<-[1..x], esPrimo a, esPrimo b, (a+b==x)]

-- b) goldbach
goldbach :: Integer -> Bool
goldbach x = x>2 && mod x 2 == 0 && not(null(pares x)) 
    

-- c) goldbachHasta
goldbachHasta :: Integer -> Bool
goldbachHasta x = and(map goldbach [d|d<-[3..x], even d, goldbach d])

-- d) goldbachDébilHasta
goldbachDébilHasta :: Integer -> [(Integer, Integer, Integer)]
goldbachDébilHasta x 
    | (mod x 2 /= 0) && (x>5) = [(3,a,b)| a<-[1..x], b<-[a..x], esPrimo a, esPrimo b, (a+b+3==x)]
    | otherwise = [(0,a,b) | a<-[1..x], b<-[a..x], esPrimo a, esPrimo b, (a+b==x)]

-- Ejercicio 10
-- a) esPerfecto
esPerfecto :: Integer -> Bool
esPerfecto x = sum([d|d<-[1..(x-1)], divideA d x])==x 

-- b) perfectosMenoresQue
perfectosMenoresQue :: Integer -> [Integer]
perfectoMenoresQue x = [d|d<-[1..x], esPerfecto d]
