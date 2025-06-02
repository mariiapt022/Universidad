import java.util.Comparator;

/**
 * Clase que define un criterio de comparación entre estudiantes, considerando menor al estudiante 
 * con mayor nota media. En caso de igualdad, se considera menor el que menor renta tenga. Si, aún así,
 * se da igualdad, entonces se considera el orden lexicográfico de los nombres. 
 * Es decir, el primero en el orden debe ser el de mejor nota, y en caso de igualdad el de menor renta.
 */
public class CriterioNota implements Comparator<Estudiante> {
	public int compare(Estudiante est1, Estudiante est2) {
		int res = new Double(est2.getNotaMedia()).compareTo(est1.getNotaMedia());
		if (res == 0) {
			res = new Double(est1.getRentaFamiliar()).compareTo(est2.getRentaFamiliar());
			if (res == 0)
				res = est1.getNombre().compareToIgnoreCase(est2.getNombre());
		}
		return res;
	}
}
