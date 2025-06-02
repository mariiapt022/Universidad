package prMaternidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Maternidad {
	private SortedMap<Persona,SortedSet<Persona>> pacientes;
	
	public Maternidad(){
		pacientes = new TreeMap<>(new OrdAlt());
	}
	
	public Maternidad(String fileName) throws FileNotFoundException{
		this();
		addPacientesFichero(fileName);
	}
	
	//Añade a la estructura de datos la información del fichero sobre las madres e hijos ingresados.
	public void addPacientesFichero (String fileName) throws FileNotFoundException{
			Scanner sc = new Scanner (new File(fileName));
			addPacientes(sc);
			sc.close();
	}
	
	public void addPacientes(Scanner sc){
		while (sc.hasNextLine()){
			addMadreBebes(sc.nextLine());
		}
	}
	
	private void addMadreBebes(String linea){
		StringTokenizer st = new StringTokenizer(linea, "#");
		try{
			Persona madre = leerPersona(st.nextToken());
			Set<Persona> bebes = new HashSet<>();
			while (st.hasMoreTokens()){
				bebes.add(leerPersona(st.nextToken()));
			}
			addMadreBebes(madre,bebes);
			
		}catch (NoSuchElementException e){
			//Si no hay ni siquiera madre, entonces filtramos esa línea y seguimos ejecutando.
		}
	}
	
	private Persona leerPersona(String datos){
		Persona p = null;
		StringTokenizer st = new StringTokenizer(datos, ":");
		try{
			p = new Persona(st.nextToken(), 
					 		Integer.parseInt(st.nextToken()), 
					 		Integer.parseInt(st.nextToken()));
		}catch (NoSuchElementException e){
			throw new MaternidadException("Faltan datos");
		}catch (NumberFormatException e){
			throw new MaternidadException("Datos incorrectos.");
		}
		return p;
	}
	
	
	public void addMadreBebes(Persona madre, Collection<Persona> bebes){
		if (!pacientes.containsKey(madre)){
			pacientes.put(madre, new TreeSet<Persona>());
		}
		pacientes.get(madre).addAll(bebes);
	};
	
	
	public void escribirFichero (String fileName) throws FileNotFoundException{
			PrintWriter pw = new PrintWriter(fileName);
			escribir(pw);
			pw.close();
		
	}
	
	public void escribir(PrintWriter pw){
		pw.print(this.toString());
	}

		
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Persona madre : pacientes.keySet()){
			sb.append(madre);
			for(Persona bebe : pacientes.get(madre)){
				sb.append("#");
				sb.append(bebe);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	//Calcula la media de hijos por madre. Aquellas madres que no tienen hijos asociados se tienen en cuenta al
	//no se tienen en cuenta para computar la media.
	public double mediaBebes(){
		double suma = 0.0;
		int madres = 0;
			
		for (SortedSet<Persona> bebes : pacientes.values()){
			if (bebes.size() > 0){
				suma += bebes.size();
				madres ++;
			}
		}
		return suma/madres;
	}
	
	//Encontrar el número de habitación de la madre correspondiente al bebé cuyo código se pasa como parámetro.
	public int encontrarMadre(int codigo){
		int habitacion = -1;
		Persona unaMadre = null;
		Persona p = new Persona(" ",codigo,0);
		
		Set<Persona> madres = pacientes.keySet();
		Iterator<Persona> it = madres.iterator();
		
		while (habitacion == -1 && it.hasNext()){
			unaMadre = it.next();
			if (pacientes.get(unaMadre).contains(p))
				habitacion = unaMadre.getHabitacion();
		}
		
		if (habitacion == -1)
			throw new MaternidadException("El bebé no está registrado en el servicio de maternidad");
		
		return habitacion;
	}
		
}
