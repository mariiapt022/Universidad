# nxn dimension of the magic matrix
param n:=4, integer, > 0;

set N := 1..n^2;
param p {i in N}:=i; # N es es un conjunto definido previamente


var x{i in 1..n, j in 1..n, k in N}, binary;
/* x[i,j,k] = 1 means that cell (i,j) contains integer p[k] */
var redun;

minimize redundancia: redun;

s.t. a{i in 1..n, j in 1..n}: sum{k in N} x[i,j,k] = 1;
/* each cell must be assigned exactly to one element of p */

s.t. b{k in N}: sum{i in 1..n, j in 1..n} x[i,j,k] <= redun;
/* each element of p must be assigned to exactly to one cell */

var s, integer;
/* the magic sum */

s.t. r{i in 1..n}: sum{j in 1..n, k in N} p[k] * x[i,j,k] = s;
/* the sum in each row must be the magic sum */

s.t. c{j in 1..n}: sum{i in 1..n, k in N} p[k] * x[i,j,k] = s;
/* the sum in each column must be the magic sum */

s.t. d: sum{i in 1..n, k in N} p[k] * x[i,i,k] = s;
/* the sum in the diagonal must be the magic sum */

s.t. e: sum{i in 1..n, k in N} p[k] * x[i,n-i+1,k] = s;
/* the sum in the co-diagonal must be the magic sum */

