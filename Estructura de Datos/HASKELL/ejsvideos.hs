
-- Ejercicios foldr
rev :: [a] -> [a]
rev xs = foldr (\cont x -> x:cont) [] xs


prefixes :: [a] -> [[a]]
prefixes = foldr (\x acc -> [x]:(map ((:) x) acc)) [] 


