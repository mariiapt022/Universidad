package prMaternidad;

import java.util.Comparator;

public class OrdAlt implements Comparator<Persona>{
	public int compare(Persona p1,Persona p2) {
		int res=p1.getNombre().compareToIgnoreCase(p2.getNombre());
		if(res==0) {
			res=Integer.compare(p1.getCodigo(), p2.getCodigo());
		}
		return res;
	}

}
