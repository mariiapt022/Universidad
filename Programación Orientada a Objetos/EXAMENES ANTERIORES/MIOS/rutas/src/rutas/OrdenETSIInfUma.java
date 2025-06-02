package rutas;

import java.util.Comparator;

public class OrdenETSIInfUma implements Comparator<Lugar>{

	@Override
	public int compare(Lugar l1, Lugar l2) {
		Lugar ETSI=new Lugar("ETSI",36.715,-4.477);
		double d1=l1.distancia(ETSI);
		double d2=l2.distancia(ETSI);
		return Double.compare(d1, d2);
	}
	
}
