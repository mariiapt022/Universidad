
module WellBalanced where
import Test.QuickCheck 
import DataStructures.Stack.LinearStack

wellBalanced :: String -> Bool
wellBalanced xs = wellBalanced' xs S.empty

wellBalanced' :: String -> Stack Char -> Bool
wellBalanced' [] s = isEmpty s
wellBalanced' (x:xs) s
   | x == '(' || x == '{' || x == '[' = wellBalanced' xs (push x s)
   | x == ')' || x == '}' || x == ']' = wellBalanced' xs (pop s) 
   | otherwise = wellBalanced' xs s