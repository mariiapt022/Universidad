
param n:=4, integer, > 0;

set N := 1..n^2;

var s integer;

var x{i in 1..n, j in 1..n, k in N}, binary;


s.t. completa {i in 1..n,j in 1..n}: sum{k in N} x[i,j,k] = 1;
s.t. todos {k in N}:sum{i in 1..n, j in 1..n} x[i,j,k] =1;
s.t. filas {i in 1..n}: sum{j in 1..n, k in N} k* x[i,j,k] = s;
s.t. columnas {j in 1..n}: sum{i in 1..n, k in N} k * x[i,j,k] = s;
s.t. diagonal : sum{i in 1..n, k in N} k * x[i,i,k] = s;
s.t. otraDiagonal : sum{i in 1..n, k in N} k * x[i,n-i+1,k] = s;
