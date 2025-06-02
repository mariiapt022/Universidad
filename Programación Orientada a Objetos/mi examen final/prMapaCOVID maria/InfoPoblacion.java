package covid;
//María Peinado Toledo. Doble Grado Ingeniería Informática y Matemáticas. Grupo A
import java.util.HashSet;
import java.util.Set;

public class InfoPoblacion implements InfoCOVID{
	
	private int minPoblacion,maxPoblacion;
	
	public InfoPoblacion(int min,int max) {
		minPoblacion=min;
		maxPoblacion=max;
	}
	
	@Override
	public Set<String> obtenerInfo(MapaCOVID mapa) {
		Set<String> res=new HashSet<>();
		
		for(DistritoSanitario d:mapa.getDistritos()) {
			if(d.getPoblacion()>minPoblacion&&d.getPoblacion()<maxPoblacion) {
				res.add(d.getNombre());
			}
		}
		
		return res;
	}
	
}
