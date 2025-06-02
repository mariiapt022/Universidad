reset;  
param Nsec integer, >0;  
param Ncol integer, >0;  
set DIS := 1 .. Ndis;  
set COL := 1 .. Ncol;  
param distritos {DIS};  
param colegios {COL}; 

param tiempo {DIS, COL} default 10000; 
 
var x{ DIS, COL} integer,>= 0;  
# funcion objectivo 
minimize z: sum { i in DIS, j in COL} 
tiempo[i,j]*x[i,j];  
# restricciones  
s.t. r1 { j in COL} : sum { i in SEC} x[i,j] = 
colegios[j];  
s.t. r2 { i in SEC} : sum { j in COL} x[i,j] = 
distritos[i]; 