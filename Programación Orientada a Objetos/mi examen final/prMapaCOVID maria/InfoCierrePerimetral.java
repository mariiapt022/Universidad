package covid;
//Mar�a Peinado Toledo. Doble Grado Ingenier�a Inform�tica y Matem�ticas. Grupo A
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
