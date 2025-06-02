-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º Curso. ETSI Informática. UMA
--
-- Titulación: Doble Grado en Ingeniería Informática y Matemáticas.
-- Alumno: Peinado Toledo, María
-- Fecha de entrega: DIA | MES | AÑO
--
-- Relación de Ejercicios 1. Ejercicios resueltos: 1-17
--
-------------------------------------------------------------------------------
import Test.QuickCheck

-- Ejercicio 1
-- a) Define la función 
esTerna :: Integer -> Integer -> Integer -> Bool
esTerna x y z
    | (x*x+y*y)==(z*z) = True
    | otherwise = False

-- b) Escribe una función terna que tome dos parámetros y devuelva una terna pitagórica
terna :: Integer -> Integer -> (Integer, Integer, Integer)
terna x y
    | x > y && x>0 && y>0 = (x*x-y*y,2*x*y,x*x+y*y)
    | otherwise = error "x<=y"

-- c) y d) QuickCheck
p_ternas x y = x>0 && y>0 && x>y ==> esTerna l1 l2 h
    where
        (l1,l2,h) = terna x y


-- Ejercicio 2. Define una función polimórfica 
intercambia :: (a,b) -> (b,a)
intercambia (a, b) = (b, a)

-- Ejercicio 3. 
-- a) Define una función sobrecargada para tipos con orden
ordena2 :: Ord a => (a, a) -> (a, a)
ordena2 (a, b)
    | a < b = (a, b)
    | otherwise = (b, a)

p1_ordena2 x y = enOrden (ordena2 (x,y))
    where enOrden (x,y) = x<=y
p2_ordena2 x y = mismosElementos (x,y) (ordena2 (x,y))
    where mismosElementos (x,y) (x',y') = (x==x' && y==y') || (x==y' && y==x')

-- b) Define una función sobrecargada para tipos con orden
ordena3 :: Ord b => (b, b, b) -> (b, b, b)
ordena3 (a, b, c)
    | a > b = ordena3 (b, a, c)
    | a > c = ordena3 (b, c, a)
    | b > c = ordena3 (a, c, b)
    | otherwise = (a, b, c)

-- c) QuickCheck
p1_ordena3 x y z = enOrden (ordena3 (x,y,z))
    where enOrden (x,y,z) = x<=y && y<=z
p2_ordena3 x y z = mismosElementos (x,y,z) (ordena3 (x,y,z))
    where 
        mismosElementos (x,y,z) (x',y',z') = (x==x' && y==y' && z==z') || (x==y' && y==z' && z==x') || (x==y' && y==x' && z==z') || (x==z' && y==x' && z==y') || (x==z' && y==y' && z==x')

-- Ejercicio 4
-- a)Define una nueva función max2
max2 :: Ord a => a -> a -> a
max2 x y
    | x<y = y
    | otherwise = x

-- b) QuickCheck
p1_max2 x y = (x == max2 x y) || (y == max2 x y)
p2_max2 x y = (x >= max2 x y) && (y >= max2 x y)
p3_max2 x y = (x >= y) && (x == max2 x y)
p4_max2 x y = (y >= x) && (y == max2 x y)

-- Ejercicio 5
entre :: Ord a => a -> (a,a) -> Bool
entre x (min,max)
    | x>=min && x<=max = True
    | otherwise = False

-- Ejercicio 6
iguales3 :: Eq a => (a,a,a) -> Bool
iguales3 (a,b,c)
    | a==b && b==c = True
    | otherwise = False

-- Ejercicio 7
-- a) Define una función descomponer.

type TotalSegundos = Integer 
type Horas = Integer
type Minutos = Integer
type Segundos = Integer

descomponer :: TotalSegundos -> (Horas,Minutos,Segundos)
descomponer x = (horas, minutos, segundos)
    where
        horas = div x 3600
        minutos = (div x 60) `mod` 60
        segundos = mod x 60


-- b) QuickCheck
p_descomponer x = x>=0 ==> h*3600 + m*60 + s == x && entre m (0,59) && entre s (0,59)
    where (h,m,s) = descomponer x

-- Ejercicio 8
unEuro :: Double
unEuro = 166.386
-- a) Define una función pesatasAEuros
pesetasAEuros :: Double -> Double
pesetasAEuros x = x/unEuro

-- b) Define la función eurosAPesetas
eurosAPesetas :: Double -> Double
eurosAPesetas x = x*unEuro

-- c) QuickCheck
p_inversas x = eurosAPesetas (pesetasAEuros x) == x

-- Ejercicio 9
infix 4~=
(~=) :: Double -> Double -> Bool
x ~= y = abs (x-y) < epsilon
    where epsilon = 1/1000

p_inversas2 x = eurosAPesetas (pesetasAEuros x) ~= x

-- Ejercicio 10 ax^2 + bx + c = 0
-- a) Defince una función raíces
raíces :: Double -> Double -> Double -> (Double, Double)
raíces a b c
    | raiz < 0 = error "Raíces no reales"
    | otherwise = ((-b+sqrt raiz)/(2*a), (-b-sqrt raiz)/(2*a))
    where
        raiz = b*b-4*a*c

-- b) QuickCheck
p1_raíces a b c = esRaíz r1 && esRaíz r2
    where
        (r1,r2)= raíces a b c
        esRaíz r = a*r^2 + b*r + c ~= 0

p2_raíces a b c = b*b-4*a*c >= 0 && a /= 0 ==> esRaíz r1 && esRaíz r2
    where
        (r1,r2)= raíces a b c 
        esRaíz r = a*r^2 + b*r + c ~= 0

-- Ejercicio 11. Define una función esMúltiplo
esMúltiplo :: Integer -> Integer -> Bool
esMúltiplo x y = mod x y == 0 

-- Ejericio 12. Define el operador de implicación lógica (==>>)
infixl 4 ==>>
(==>>) :: Bool -> Bool -> Bool
x ==>> y = not x || y 


-- Ejercicio 13. Años bisiestos
esBisiesto :: Integer -> Bool
esBisiesto x = mod x 4 == 0 && ((mod x 100 == 0) ==>> (mod x 400 == 0))

-- Ejercicio 14. 
-- a) Define la función recursiva potencia
potencia :: Integer -> Integer -> Integer
potencia b n 
    | n > 0 = b*potencia b (n-1)
    | n == 0 = 1

-- b) Utilizando otra propiedad
potencia' :: Integer -> Integer -> Integer
potencia' b n 
    | n > 0 && mod n 2 == 1 = b * potencia' b (n-1)
    | n > 0 && mod n 2 == 0 = (potencia' b n_2)*(potencia' b n_2)
    | n == 0 = 1
    where
        n_2=div n 2

-- c) QuickCheck
p_pot b n = n>=0 ==> potencia b n == sol && potencia' b n == sol
    where sol = b^n

-- Ejercicio 15. Permutaciones y factorial.
factorial :: Integer -> Integer
factorial n
    | n < 2 = 1
    | otherwise = n*factorial(n-1)

-- Ejercicio 16. 
-- a) Define divideA
divideA :: Integer -> Integer -> Bool
divideA x y = mod y x == 0

-- b) QuickCheck
p1_divideA x y = y/=0 && y `divideA` x ==> div x y * y == x

-- c) QuickCheck 2
p2_divideA x y z = x/=0 && (y+z /= 0) && x `divideA` y && x `divideA` z ==> x `divideA` (y+z)

-- Ejericio 17. Mediana
mediana :: Ord a => (a,a,a,a,a) -> a 
mediana (x,y,z,t,u)
    | x > z = mediana (z,y,x,t,u)
    | y > z = mediana (x,z,y,t,u)
    | t < z = mediana (x,y,t,u,u)
    | u < z = mediana (x,y,u,t,z)
    | otherwise = z 


