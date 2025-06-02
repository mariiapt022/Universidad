package ciclismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class Clasificacion {
	private Map<Ciclista,Tiempo> clasif;
	
	public Clasificacion() {
		clasif=new HashMap<>();
	}
	
	public void agrega(Ciclista corredor,Tiempo tiempo) {
		Tiempo tiempocorredor=clasif.get(corredor);
		if(tiempocorredor==null) {
			clasif.put(corredor, tiempo);
		}else {
			tiempocorredor.incrementa(tiempo);
		}
	}
	
	public SortedMap<Tiempo,List<Ciclista>> porTiempos(){
		SortedMap<Tiempo,List<Ciclista>> res=new TreeMap<>();
		for(Ciclista c:clasif.keySet()) {
			Tiempo tiempo=clasif.get(c);
			List<Ciclista> ciclistas= res.get(tiempo);
			if(ciclistas==null) {
				ciclistas = new ArrayList<Ciclista>();
				res.put(tiempo, ciclistas);
			}
			ciclistas.add(c);
		}		
		return res;
	}
	
	
	public Ciclista liderClasificacion() {
		SortedMap<Tiempo, List<Ciclista>> porTiempos = porTiempos();
		List<Ciclista> list = porTiempos.get(porTiempos.firstKey());
		return list.get(0);
	}
	
	public Tiempo tiempoEquipo(String equipo) {
		Tiempo tiempo = new Tiempo();
		for (Ciclista ciclista : clasif.keySet()) {
			if (ciclista.getEquipo().equals(equipo)) {
				tiempo.incrementa(clasif.get(ciclista));
			}
		}
		return tiempo;
	}
	
	
	
}
