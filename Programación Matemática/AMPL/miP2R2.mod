param n;

set I:= 1..n;

param value{I,I};
param blocks{I,I};

set cells = {i in I, j in I: value[i,j] <= 0}; 

var x{cells,I} binary;

subject to noVacia {(i,j) in cells}:
   sum {k in I} x[i,j,k] = 1;

subject to rowConstr {i in I, k in I}:
   sum {(i,j) in cells} x[i,j,k] = 1-sum{j in I: value[i,j]=k} 1;
   
subject to columnConstr {j in I, k in I}:
   sum {(i,j) in cells} x[i,j,k] = 1-sum{i in I: value[i,j]=k} 1;

subject to blockConstr {m in I, k in I}:
    sum {(i,j) in cells: blocks[i,j]=m} x[i,j,k]=1-sum{i in I, j in I: blocks[i,j]=m && value[i,j]=k} 1;

   
