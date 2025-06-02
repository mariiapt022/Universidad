package becas;

import java.util.Comparator;

public class CriterioNota implements Comparator<Estudiante>{

	@Override
	public int compare(Estudiante o1, Estudiante o2) {
		int res=Double.compare(o2.getNotaMedia(), o1.getNotaMedia());
		if(res==0) {
			res=Double.compare(o1.getRentaFamiliar(), o2.getRentaFamiliar());
		}
		if(res==0) {
			res=o1.getNombre().compareToIgnoreCase(o2.getNombre());
		}
		return res;
	}

}
