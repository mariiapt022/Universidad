package vuelos;

import java.util.Comparator;

/**
 * Clase que define un orden alternativo para los objetos de la clase Vuelo, que
 * ordena los vuelos según la hora de llegada, y en caso de coincidir, utiliza el
 * orden natural.
 * 
 * @author POO
 */
public class OrdenVueloHoraLlegada implements Comparator<Vuelo> {
	public int compare(Vuelo v1, Vuelo v2) {
		int res = v1.getHoraLlegada().compareTo(v2.getHoraLlegada());
		if (res == 0)
			res = v1.compareTo(v2);
		return res;
	}
}