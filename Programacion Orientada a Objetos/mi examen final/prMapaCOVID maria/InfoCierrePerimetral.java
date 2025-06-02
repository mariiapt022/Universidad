package covid;
//María Peinado Toledo. Doble Grado Ingeniería Informática y Matemáticas. Grupo A
import java.util.HashSet;
import java.util.Set;

public class InfoCierrePerimetral implements InfoCOVID{
	
	private final static int CASOS_CIERRE=500;
	
	public InfoCierrePerimetral() {
		
	}
	
	@Override
	public Set<String> obtenerInfo(MapaCOVID mapa) {
		Set<String> res=new HashSet<>();
		for(String prov:mapa.getProvincias()) {
			if(mapa.incidenciaProvincia(prov)>CASOS_CIERRE) {
				res.add(prov);
			}
		}
		
		return res;
	}

}
