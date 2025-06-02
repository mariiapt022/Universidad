reset;

param n >=0, integer;  
param m>=0, integer;  
set IND := 1 ..n;  
set RES := 1 ..m;  
param a {RES,IND};  
param b { RES}; 
param c {IND} ;  
 
var x {IND} integer, >=0;  
 
# variable objetivo 
minimize z: sum { i in IND} c[i]*x[i];

# restricciones  
s.t. r1 { j in RES} : sum { i in IND} 
a[j,i]*x[i]<= b[j];  



