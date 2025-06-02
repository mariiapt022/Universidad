reset;
param unidadesAmpl integer, >0;
param costeAmpl integer, >0;
param NPob integer, >0;
param NAlm integer, >0;

set poblaciones;
set almacenes ordered;
param coste {almacenes};
param capacidad {almacenes};
param demanda {poblaciones}; 
param costeP {almacenes,poblaciones};

var x{almacenes, poblaciones} integer,>= 0;  #Xij=producto abastecido desde Ai hasta Pj
var y{almacenes} binary;  #yi=1 si el almacen i se usa
var z{almacenes} binary; #zi=1 si el almacen i se amplia

# funcion objectivo 
minimize f: 
sum { i in almacenes, j in poblaciones} costeP[i,j]*x[i,j] + 
sum {i in almacenes} (coste[i] + z[i]*costeAmpl); 
 
# restricciones  
s.t. abastecer { j in poblaciones} : sum { i in almacenes }x[i,j]= demanda[j];

s.t. sinSuperar { i in almacenes} : sum { j in poblaciones} x[i,j] <= capacidad[i]+ unidadesAmpl*z[i];

s.t. soloSeAmpliaUno : z[last(almacenes)]=0;

s.t. soloSeAmpliaSiSeUsa {i in almacenes}: y[i]>=z[i];