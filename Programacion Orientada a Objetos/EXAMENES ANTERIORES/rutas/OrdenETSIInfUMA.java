package rutas;

import java.util.Comparator;

public class OrdenETSIInfUMA implements Comparator<Lugar> {
	final static Lugar ETSIInfUMA = new Lugar("E.T.S.I. Informática", 36.715, -4.477);

	public int compare(Lugar l1, Lugar l2) {
		double l1ETSIInf = l1.distancia(ETSIInfUMA);
		double l2ETSIInf = l2.distancia(ETSIInfUMA);
		return Double.compare(l1ETSIInf, l2ETSIInf);
	}
}
