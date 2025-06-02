package vuelos;

import java.util.Comparator;

/**
 * Clase que define un orden alternativo para los objetos de la clase Vuelo, que
 * ordena los vuelos según la hora de salida, y en caso de coincidir, utiliza el
 * orden natural.
 * 
 * @author POO
 */
public class OrdenVueloHoraSalida implements Comparator<Vuelo> {
	public int compare(Vuelo v1, Vuelo v2) {
		int res = v1.getHoraSalida().compareTo(v2.getHoraSalida());
		if (res == 0)
			res = v1.compareTo(v2);
		return res;
	}
}
