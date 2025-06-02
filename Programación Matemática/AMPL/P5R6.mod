param n;
param m;

set I:= 1..m;
set J:= 1..n;

param c{J}; 
param b{I};
param A{I,J};

var x{J}>=0;

minimize z: sum {j in J} c[j]*x[j];

subject to constr {i in I}:
   sum {j in J} A[i,j] * x[j] <= b[i];