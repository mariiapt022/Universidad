set fabricas;
set localizaciones;

param flujos{fabricas, fabricas};
param costes{localizaciones, localizaciones };

var x{fabricas,localizaciones} binary;
var y{fabricas,fabricas,localizaciones,localizaciones} binary;
# Se definen más variables de las necesarias puesto que los dos 
# primeros índices deben ser distintos al igual que los dos últimos
maximize objetivo: sum{i in fabricas,j in fabricas,k in localizaciones, l in localizaciones} 
        (flujos[i,j]*costes[k,l]*y[i,j,k,l]);

subject to fabricaLocalizada {i in fabricas}:
   sum {j in localizaciones} x[i,j] = 1;

subject to localizacionUsada {j in localizaciones}:
   sum {i in fabricas} x[i,j] = 1;
subject to tectnicas1 {i in fabricas,j in fabricas,k in localizaciones, l in localizaciones}:
   y[i,j,k,l]<=x[i,k];
subject to tectnicas2 {i in fabricas,j in fabricas,k in localizaciones, l in localizaciones}:
   y[i,j,k,l]<=x[j,l];
subject to tectnicas3 {i in fabricas,j in fabricas,k in localizaciones, l in localizaciones}:
   x[i,k]+x[j,l]<=y[i,j,k,l]+1;