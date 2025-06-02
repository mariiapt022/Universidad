package barcos;

import java.util.Comparator;

/**
 * Clase que define un orden alternativo para Barco, consistente en ordenar
 * por la cercanía a la ciudad de Málaga, considerando esta en la posición
 * de latitud 36.7585406 y longitud -4.3971722.
 * Esta es una versión simplificada. Otra alternativa más genérica hubiese 
 * sido definir una clase OrdenDistancia a la que se podría pasar en el 
 * constructor la posición de referencia para realizar la comparación.
 * 
 * @author POO
 *
 */
public class OrdenDistanciaMalaga implements Comparator<Barco> {
	private static Posicion MALAGA = new Posicion(36.71,-4.41);
	public int compare(Barco b1, Barco b2) {
		double d1 = b1.getPosicion().distancia(MALAGA);
		double d2 = b2.getPosicion().distancia(MALAGA);
		int res = Double.compare(d1, d2);
		if (res == 0) {
			res = b1.compareTo(b2);
		}
		return res;
	}
}