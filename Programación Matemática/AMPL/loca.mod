set ubicaciones;
set clientes;

param costes {ubicaciones}; #costes de mantenimiento 
param capacidad {ubicaciones}; #capacidad de producción 
param demanda {clientes}; #demanda de producto 
param beneficios {ubicaciones,clientes}; #beneficios unitarios por servir demanda 

var x{ubicaciones} binary;
var y{ubicaciones,clientes} binary;

maximize beneficioTotal:
   sum {i in ubicaciones, j in clientes} beneficios[i,j]*demanda[j]*y[i,j]-
   sum {i in ubicaciones} costes[i]*x[i];
   
subject to localiza {i in ubicaciones}:
   sum {j in clientes} demanda[j]*y[i,j] <= capacidad[i]*x[i];
subject to servicio {j in clientes}:
   sum {i in ubicaciones} y[i,j] = 1;
   
   #xi=1 si se fabrica la planta i
   #yij=1 si a la ubicación i se le asigna el cliente j
   
   #Funcion objetivo: max: sum(beneficios(i,j)*demanda(j)*y(i,j)) - sum(costes(i)*x(i))
   
   #Restricciones
   #No sobrepasamos la capacidad de los almacences: para todo i
   #sum(demanda[j]*y(i,j))<=capacidad(i)*x(i)
   #Cada cliente se abastece con un unico local: para todo j
   #sum(y(i,j))=1