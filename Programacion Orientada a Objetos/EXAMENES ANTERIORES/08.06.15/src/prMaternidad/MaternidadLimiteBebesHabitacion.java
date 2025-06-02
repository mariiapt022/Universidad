package prMaternidad;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MaternidadLimiteBebesHabitacion extends Maternidad{
	private Map<Integer,Integer> ocupacion; //Beb�s en cada habitaci�n
	private List<String> cambios; //cambios de habitaci�n que hay que hacer
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
	

	
	//redefinimos el m�todo para a�adir madres e hijos
	public void addMadreBebes(Persona madre, Collection<Persona> bebes){
		int hab, ocupantes;
		
		//se a�aden a la estructura de datos general
		super.addMadreBebes(madre, bebes);
		
		//Si se ha superado el l�mite se crea un mensaje informativo en el listado cambios
		
		for (Persona bebe : bebes){
			hab = bebe.getHabitacion();
			
			//Se actualizan las estructuras de datos
			ocupantes = ocupacion.getOrDefault(hab, 0) + 1;
			ocupacion.put(hab, ocupantes);
			
			//Si se super� el l�mite se a�ade un mensaje. A no ser que la habitaci�n sea
			//la incubadora (0)
			if (ocupantes > maximo && hab != 0)
				cambios.add("La habitaci�n " + hab + " ha superado el l�mite de beb�s permitidos");
		}
	}
	
	//Los mensajes de cambio se muestran l�nea a l�nea
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
