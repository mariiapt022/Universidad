////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: Mar�a Peinado Toledo 77666802B
// GRUPO: Grupo D
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapida extends Ordenacion {
  
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
	    ordRapidaRec(v, 0, v.length-1);
	}

	// Debe ordenar ascendentemente los primeros @n elementos del vector @v con 
	// una implementaci�n recursiva del m�todo de ordenaci�n r�pida.	
	public static <T extends Comparable<? super T>> void ordRapidaRec(T v[], int izq, int der) {
		if (izq < der) {
			int p = partir(v, v[izq], izq, der);
			ordRapidaRec(v, izq, p-1);
			ordRapidaRec(v, p + 1, der);
		}
	}
	   
   public static <T extends Comparable<? super T>> int partir(T v[], T pivote, int izq, int der) {
	   int i = izq; 
	   int j = der;
	   
	   while (i < j){
		   while(v[j].compareTo(pivote) > 0 && j > 0){ 
			   		j--; 
		   }
		   while(v[i].compareTo(pivote) <= 0 && i < v.length-1){ 
		    	   i++;
		   }
		   if (i<j){
			   Ordenacion.intercambiar(v,i,j);
		   }
	   }
	   Ordenacion.intercambiar(v,izq,j);
	   
	   return j;   	
   }

	// Peque�os ejemplos para pruebas iniciales.
	public static void main (String args[]) {
	
		// Un vector de enteros
		Integer vEnt[] = {3,8,6,5,2,9,1,1,4};
		ordenar(vEnt);
		System.out.println(vectorAString(vEnt));

		// Un vector de caracteres
		Character vCar[] = {'d','c','v','b'};
		ordenar(vCar);
		System.out.println(vectorAString(vCar));

	}	
    
}
