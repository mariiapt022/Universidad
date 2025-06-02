package prMaternidad;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MaternidadLimiteBebesHabitacion extends Maternidad{
	private Map<Integer,Integer> ocupacion; //Bebés en cada habitación
	private List<String> cambios; //cambios de habitación que hay que hacer
	private int maximo;
	
	public MaternidadLimiteBebesHabitacion(int maximo){
		super();
		ocupacion = new HashMap<>();
		cambios = new ArrayList<>();
		this.maximo = maximo;
	}
	
	
	public MaternidadLimiteBebesHabitacion(int maximo, String filename) throws FileNotFoundException{
		//Se inicializan las estructuras 
		this(maximo);
		
		//Y se rellenan
		addPacientesFichero(filename);
	}
	

	
	//redefinimos el método para añadir madres e hijos
	public void addMadreBebes(Persona madre, Collection<Persona> bebes){
		int hab, ocupantes;
		
		//se añaden a la estructura de datos general
		super.addMadreBebes(madre, bebes);
		
		//Si se ha superado el límite se crea un mensaje informativo en el listado cambios
		
		for (Persona bebe : bebes){
			hab = bebe.getHabitacion();
			
			//Se actualizan las estructuras de datos
			ocupantes = ocupacion.getOrDefault(hab, 0) + 1;
			ocupacion.put(hab, ocupantes);
			
			//Si se superó el límite se añade un mensaje. A no ser que la habitación sea
			//la incubadora (0)
			if (ocupantes > maximo && hab != 0)
				cambios.add("La habitación " + hab + " ha superado el límite de bebés permitidos");
		}
	}
	
	//Los mensajes de cambio se muestran línea a línea
	public String toString(){
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("\n");
		for (String mensaje : cambios){
			sb.append(mensaje);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
