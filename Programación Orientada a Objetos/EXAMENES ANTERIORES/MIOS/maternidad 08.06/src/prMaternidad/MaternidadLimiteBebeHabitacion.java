package prMaternidad;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaternidadLimiteBebeHabitacion extends Maternidad{
	private int maximo;
	private List<String> cambios;
	private Map<Integer,Integer> ocupacion;
	
	
	public MaternidadLimiteBebeHabitacion(int max) {
		super();
		cambios=new ArrayList<>();
		ocupacion= new HashMap<>();
		maximo=max;
	}
	
	public MaternidadLimiteBebeHabitacion(int max,String nomFich) throws FileNotFoundException {
		this(max);
		addPacientesFichero(nomFich);
	}
	
	
	@Override
	public void addMadreBebes(Persona madre,Collection<Persona> bebes) {
		int hab, ocupantes;
		
		super.addMadreBebes(madre, bebes);
		
		for (Persona bebe : bebes){
			hab = bebe.getHabitacion();
			
			ocupantes = ocupacion.getOrDefault(hab, 0) + 1;
			ocupacion.put(hab, ocupantes);
			
			if (ocupantes > maximo && hab != 0)
				cambios.add("La habitación " + hab + " ha superado el límite de bebés permitidos");
		}
	}
	
	
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
