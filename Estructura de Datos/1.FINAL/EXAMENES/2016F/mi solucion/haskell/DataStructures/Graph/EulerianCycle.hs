-------------------------------------------------------------------------------
-- Student's name:
-- Student's group:
--
-- Data Structures. Grado en Informática. UMA.
-------------------------------------------------------------------------------

module DataStructures.Graph.EulerianCycle(isEulerian, eulerianCycle) where

import DataStructures.Graph.Graph
import Data.List

--H.1)
isEulerian :: Eq a => Graph a -> Bool
isEulerian g = [v | v <- vertices g, even (degree g v)] == vertices g

-- H.2)
remove :: (Eq a) => Graph a -> (a,a) -> Graph a
remove g (v,u) = deleteVertexs g2 [v | v<- vertices g2, degree g2 v == 0]
    where g2 = deleteEdge g (v,u)

deleteVertexs :: (Eq a) => Graph a -> [a] -> Graph a 
deleteVertexs g [] = g 
deleteVertexs g (v:vs) = deleteVertexs (deleteVertex g v) vs 


-- H.3)
extractCycle :: (Eq a) => Graph a -> a -> (Graph a, Path a)
extractCycle g v0 = aux v0 (head(successors g v0)) g [v0]

aux :: (Eq a) => a -> a -> Graph a -> Path a -> (Graph a, Path a)
aux v0 v g path 
    | v0 == v = (g,reverse(v0:path))
    | otherwise = aux v0 u (remove g (v,u)) (v:path)
        where u = head(successors g v)

-- H.4)
connectCycles :: (Eq a) => Path a -> Path a -> Path a
connectCycles [] ys = ys
connectCycles xs (y:ys) = aux2 xs y ys

aux2 :: (Eq a) => Path a -> a -> Path a -> Path a 
aux2 (x:xs) y ys 
    | x==y = (y:ys)++xs 
    | otherwise = x : aux2 xs y ys

-- H.5)
vertexInCommon :: (Eq a) => Graph a -> Path a -> a
vertexInCommon g cycle = head (comunes (vertices g) cycle)
    where
        comunes xs ys = [x | x <- xs , elem x cycle]


-- H.6) 
eulerianCycle :: Eq a => Graph a -> Path a 
eulerianCycle g
    | not (isEulerian g) = error ""
    | otherwise = eulerianCycle' g' cycle 
        where
            v0 = head [v | v<-vertices g]
            (g',cycle) = extractCycle g v0

eulerianCycle' :: Eq a => Graph a -> Path a -> Path a
eulerianCycle' isEmpty xs = xs
eulerianCycle' g cycle = connectCycles cycle (eulerianCycle' g' cycle')
    where
        (g',cycle')=extractCycle g (vertexInCommon g cycle)
