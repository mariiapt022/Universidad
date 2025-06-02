set NODOS;   

set ARCOS within {NODOS,NODOS};

param flujo {NODOS}; # producto ofertado (>0) o demandado (<0)

check: sum {i in NODOS} flujo[i] = 0;

param coste {ARCOS};       # coste unitario de transporte
param cota {ARCOS};        # cota superior de producto enviado

var x {ARCOS} >= 0;        # unidades de producto enviadas

minimize Total_Cost:
   sum {(i,j) in ARCOS} coste[i,j] * x[i,j];

subject to FlowEqui {i in NODOS}:
   sum {(i,j) in ARCOS} x[i,j] - sum {(k,i) in ARCOS} x[k,i] = flujo[i];
subject to CotaSup {(i,j) in ARCOS}:
   x[i,j] <= cota[i,j];

