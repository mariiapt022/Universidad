param n:=15;
set N:={1..n};

var x{i in N} integer;
var y{(i,j) in {N,N}} integer;


minimize objetivo: sum{i in N} x[i];
   
subject to r1 {j in N}: 
	sum{i in 1..n} i*y[i,j]=j;
subject to r2 {(i,j) in {N,N}}: 
	y[i,j]<=x[i];
subject to r3 {(i,j) in {N,N}}: 
	y[i,j]>=-x[i];



