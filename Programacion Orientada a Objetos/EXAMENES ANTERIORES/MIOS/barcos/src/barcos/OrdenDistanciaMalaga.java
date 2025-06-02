package barcos;

import java.util.Comparator;

public class OrdenDistanciaMalaga implements Comparator<Barco>{

	@Override
	public int compare(Barco o1, Barco o2) {
		Posicion mlg=new Posicion(36.71,-4.37);
		double d1=o1.getPosicion().distancia(mlg);
		double d2=o2.getPosicion().distancia(mlg);
		int res= Double.compare(d1, d2);
		if(res==0) {
			res=o1.compareTo(o2);
		}
		return res;
	}

}
