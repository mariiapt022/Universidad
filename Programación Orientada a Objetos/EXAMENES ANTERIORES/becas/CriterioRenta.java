	import java.util.Comparator;

	/**
	 * Clase que define un criterio de comparación entre estudiantes, considerando menor al estudiante 
	 * con menor renta familiar. En caso de igualdad, se considera menor al que más nota media tenga, 
	 * y por último, si persiste la igualdad, se consdiera el orden lexicográfico de los nombres. 
	 * Es decir, el primer estudiante será el que menor renta familiar tenga, y en caso de igualdad, 
	 * el que mayor nota media posea.
	 */
public class CriterioRenta implements Comparator<Estudiante> {
	public int compare(Estudiante est1, Estudiante est2) {
		int res = new Double(est1.getRentaFamiliar()).compareTo(est2.getRentaFamiliar());
		if (res == 0) {
			res = new Double(est2.getNotaMedia()).compareTo(est1.getNotaMedia());
			if (res == 0)
				res = est1.getNombre().compareToIgnoreCase(est2.getNombre());
		}
		return res;
	}
}

