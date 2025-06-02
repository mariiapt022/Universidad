package vuelos;

import java.util.Comparator;

public class OrdenAlt implements Comparator<Vuelo>{

	@Override
	public int compare(Vuelo v1, Vuelo v2) {
		int res=v1.horaLlegada().compareTo(v2.horaLlegada());
		if(res==0) {
			res=v1.compareTo(v2);
		}
		return res;
	}
	
}
