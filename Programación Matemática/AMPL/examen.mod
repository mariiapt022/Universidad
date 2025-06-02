reset;  
param n >=0, integer;  
param m >=0,integer;  
set IND := {1..n};  
set RES := {1..m};  
param a {RES,IND};  
param c {IND};  
param b {RES};  
var x {IND} >=0;  
 
# funcion objetivo  
minimize z: sum { i in IND} c[i]*x[i];  
 
# restricciones  
s.t. r { j in RES}: sum { i in IND} 
x[i]*a[j,i]<=b[j];  