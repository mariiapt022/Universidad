import java.io.*;
import java.util.*;


public class ColegioFamiliar extends Colegio {

	public ColegioFamiliar(String nombreFichero) throws IOException{
		super(nombreFichero);
	}
	
	public void asignarPlazas(Map<String,Integer> plazas){
	
		//Copiamos las plazas porque la asignación modifica el parámetro plazas
		Map<String,Integer> copia_plazas = new TreeMap<String,Integer>(plazas); 
		//Llamamos al asignarPlazaas de la superclase
		super.asignarPlazas(copia_plazas);
	}
	
	protected void asignarPlazasCurso(String curso,  Map<String,Integer> plazas){
		//Si quisiéramos hacer la asignación por el orden alternativo, primero reordenaríamos los solicitantes según el oden alternativo.
		//SortedSet<Solicitante> solicitantes = new TreeSet<Solicitante>(new SATSolicitante());
		//solicitantes.addAll(solicitudes.get(curso));
		
		SortedSet<Solicitante> solicitantes = solicitudes.get(curso);
		Integer numPlazas = plazas.get(curso);
		Iterator<Solicitante> i = solicitantes.iterator();
		while (i.hasNext() && numPlazas > 0){
			Solicitante sol = i.next();
			if (!sol.getTienePlaza()){
				//Se buscan todos los hermanos del solicitante, incluyéndolo a él
				SortedMap<String,List<Solicitante>> hermanos = buscarHermanos(sol.getNIF());
				//Se comprueba si hay plazas para todos los hermanos
				boolean hayPlazas = hayPlazasHermanos(hermanos,plazas); //Indica si hay plazas para todos los hermanos
				if (hayPlazas){
					//Se le asigna la plaza a todos los hermanos
					asignarPlazaHermanos(hermanos,plazas); //Esto modificará el número de plazas libres en cada curso
					numPlazas = plazas.get(curso);
				}//Si no hay plazas para los hermanos tampoco se le asigna a él
			}//Si el solicitante ya tiene plaza no se hace nada	
		}
	}
	
	//Método auxiliar que devuelve todos los hermanos, indicando su curso
	private SortedMap<String,List<Solicitante>> buscarHermanos(String nif){
		SortedMap<String,List<Solicitante>> hermanos = new TreeMap<String,List<Solicitante>>();
		for (String curso:solicitudes.keySet()){
			List<Solicitante> lista_hermanos = buscarHermanos(solicitudes.get(curso),nif);
			if (lista_hermanos != null){
				hermanos.put(curso, lista_hermanos);
			}
		}
		
		return hermanos;
	}
	
	//Método auxiliar que devuelve todos los hermanos en un curso determinado
	private List<Solicitante> buscarHermanos(SortedSet<Solicitante> curso, String nif){
		List<Solicitante> hermanos_curso = new ArrayList<Solicitante>();
		for (Solicitante sol:curso){
			if (sol.getNIF().equals(nif)){
				hermanos_curso.add(sol);
			}
		}
		return hermanos_curso;
	}

	//Método auxiliar que indica si hay plazas para todos los hermanos
	private boolean hayPlazasHermanos(SortedMap<String,List<Solicitante>> hermanos, Map<String,Integer> plazas){
		boolean hay = true;

		Set<Map.Entry<String, List<Solicitante>>> pares = hermanos.entrySet();
		Iterator<Map.Entry<String, List<Solicitante>>> i = pares.iterator();
		while (hay && i.hasNext()){
			Map.Entry<String, List<Solicitante>> n = i.next();
			Integer num_hermanos = n.getValue().size(); //numero de hermanos en un curso
			if (num_hermanos > 0){
				hay = plazas.get(n.getKey())!=null && num_hermanos <= plazas.get(n.getKey());
			}	
		}
		
		return hay;
	}
	
	//	Método auxiliar que le asigna plaza a los hermanos del solicitante, decrementando el numero de plazas
	private void asignarPlazaHermanos(SortedMap<String,List<Solicitante>> hermanos, Map<String,Integer> plazas){
		for (String curso:hermanos.keySet()){
			for (Solicitante hermano:hermanos.get(curso)){
				hermano.setTienePlaza(true);
				Integer num_plazas = plazas.get(curso);
				num_plazas--;
				plazas.put(curso,  num_plazas);
			}
		}
	}

}

