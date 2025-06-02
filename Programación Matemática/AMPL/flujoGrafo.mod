set DISTRITOS; # Distritos a los que pertenecen los alumnos.
set COLEGIOS; # Colegios a los que se envían los alumnos desde cada distrito.
set CONEXIONES within { DISTRITOS, COLEGIOS };
# Conexiones existentes entre distritos y colegios.
set PREFERENCIAS within { CONEXIONES, COLEGIOS};
# Conexiones con preferencias.

# Parámetros del modelo:
param demandaDistritos { DISTRITOS } >= 0;
param ofertaColegios { COLEGIOS } >= 0;
param tiempoDesplazarse { CONEXIONES } >= 0;
param tiempoTotalDesplazMaximo >= 0;

param demandapreferencias { CONEXIONES } >= 0; 
# Número de alumnos del distrito Di que prefieren ir al colegio Cj. 

# Variables de decisión y restricciones de no negatividad:
var numAlumnos { PREFERENCIAS } >= 0, integer;
# Son los alumnos que van del distrito Di al colegio Cj, siendo Ck su colegio preferido.

# Función objetivo del modelo:
maximize totalAlumnosContentos: 
    sum { (i,j,k) in PREFERENCIAS: j = k } numAlumnos[i,j,k];
    
# Restricciones del modelo:

subject to restriccionPreferencia { (i,k) in CONEXIONES }:
    sum { j in COLEGIOS: (i,j,k) in PREFERENCIAS } numAlumnos[i,j,k] = demandapreferencias[i,k];

subject to restriccionOferta { j in COLEGIOS }:
    sum { (i,j,k) in PREFERENCIAS } 
        numAlumnos[i,j,k] = ofertaColegios[j];
    
subject to restriccionTiempo:
    sum { (i,j,k) in PREFERENCIAS } 
    	tiempoDesplazarse[i,j] * numAlumnos[i,j,k] <= tiempoTotalDesplazMaximo;

