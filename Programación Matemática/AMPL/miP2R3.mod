param n=10;
set I:= 1..n;
set J:= 1..n;

var x{I,J} binary;

maximize objetivo: sum{i in I,j in J} x[i,j]; 

subject to solapar {i in I diff {1,n}, j in J diff {1,n}}:
   x[i,j]+x[i-1,j]+x[i+1,j]+x[i,j-1]+x[i,j+1]<=1;

subject to nulas1:
   sum{i in I} (x[i,1]+x[i,n])=0;
subject to nulas2:
   sum{j in J} (x[1,j]+x[n,j])=0;