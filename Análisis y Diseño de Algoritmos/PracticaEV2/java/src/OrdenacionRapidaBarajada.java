////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: María Peinado Toledo 77666802B
// GRUPO: Grupo D
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapidaBarajada extends OrdenacionRapida {
	
	// Implementación de QuickSort con reordenación aleatoria inicial (para comparar tiempos experimentalmente)
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		barajar(v);
		ordRapidaRec(v, 0, v.length - 1);
    }

	// reordena aleatoriamente los datos de un vector
    private static <T> void barajar(T v[]) {
    	for (int i = v.length - 1; i > 0; i--) {
            int j = aleat.nextInt(i+1);
            intercambiar(v, i, j);
    	}
    }	
	

}
