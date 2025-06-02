package prMaternidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Maternidad {
	private SortedMap<Persona,SortedSet<Persona>> pacientes;
	
	public Maternidad() {
		pacientes=new TreeMap<Persona,SortedSet<Persona>>(new OrdAlt());
	}
	
	public Maternidad(String nomFich) throws FileNotFoundException {
		this();
		addPacientesFichero(nomFich);
	}
	
	protected void addPacientesFichero(String nomFich) throws FileNotFoundException {
		Scanner sc=new Scanner(new File(nomFich));
		addPacientes(sc);
		sc.close();
	}
	
	private void addPacientes(Scanner sc) {
		while(sc.hasNextLine()) {
			addMadreBebes(sc.nextLine());
		}
	}
	
	private void addMadreBebes(String linea) {
		try {
			Scanner sc=new Scanner(linea);
			sc.useDelimiter("#");
			sc.useLocale(Locale.ENGLISH);
			Persona madre=leerPersona(sc.next());
			Set<Persona> bebes=new HashSet<>();
			while(sc.hasNext()) {
				bebes.add(leerPersona(sc.next()));
			}
			addMadreBebes(madre,bebes);
			sc.close();
		}catch (NoSuchElementException e){
			//Si no hay ni siquiera madre, entonces filtramos esa línea y seguimos ejecutando.
		}
		
	}
	
	private Persona leerPersona(String linea) {
		Persona res=null;
		try {
			Scanner sc=new Scanner(linea);
			sc.useDelimiter(":");
			String nombre=sc.next();
			int codigo=sc.nextInt();
			int hab=sc.nextInt();
			res=new Persona(nombre,codigo,hab);
			sc.close();
		}catch (NoSuchElementException e){
			throw new MaternidadException("Faltan datos");
		}catch (NumberFormatException e){
			throw new MaternidadException("Datos incorrectos.");
		}
		return res;
	}
	
	protected void addMadreBebes(Persona madre,Collection<Persona> bebes) {
		if(!pacientes.containsKey(madre)) {
			pacientes.put(madre, new TreeSet<Persona>());
		}
		pacientes.get(madre).addAll(bebes);
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
	
	public void escribirFichero(String nomFich) throws FileNotFoundException {
		PrintWriter pw=new PrintWriter(nomFich);
		escribir(pw);
		pw.close();
	}
	
	private void escribir(PrintWriter pw) {
		pw.print(this.toString());
	}
	
	public double mediaBebes() {
		double suma=0;
		int madres=0;
		
		for(SortedSet<Persona> bebes: pacientes.values()) {
			if(bebes.size()>0) {
				suma=suma+bebes.size();
				madres++;
			}
		}
		return suma/madres;
	}
	
	
	public int encontrarMadre(int codigoBebe) {
		int hab=-1;
		Persona madre;
		Persona abuscar=new Persona(" ",codigoBebe,0);
		
		Iterator<Persona> it=pacientes.keySet().iterator();
		
		while(hab==-1&&it.hasNext()) {
			madre=it.next();
			if(pacientes.get(madre).contains(abuscar)) {
				hab=madre.getHabitacion();
			}
		}
		if(hab==-1) {
			throw new MaternidadException("Madre no encontrada");
		}
		
		return hab;
	}

	
	
}
