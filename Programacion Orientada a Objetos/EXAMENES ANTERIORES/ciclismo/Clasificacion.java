import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;


public class Clasificacion {
	private Map<Ciclista, Tiempo> tiempos;

	public Clasificacion() {
		tiempos = new HashMap<Ciclista, Tiempo>();
	}

	public void agrega(Ciclista ciclista, Tiempo tiempo) {
		Tiempo tiempoCiclista = tiempos.get(ciclista);
		if (tiempoCiclista == null) {
			tiempos.put(ciclista,  tiempo);
		} else {
			tiempoCiclista.incrementa(tiempo);
		}
	}
	
	public SortedMap<Tiempo, List<Ciclista>> porTiempos() {
		SortedMap<Tiempo, List<Ciclista>> porTiempos = new TreeMap<Tiempo, List<Ciclista>>();
		for(Ciclista ciclista : tiempos.keySet()) {
			Tiempo tiempo = tiempos.get(ciclista);
			List<Ciclista> lista = porTiempos.get(tiempo);
			if (lista == null) {
				lista = new ArrayList<Ciclista>();
				porTiempos.put(tiempo, lista);
			}
			lista.add(ciclista);
		}
		return porTiempos;
	}
	
	public Ciclista liderClasificacion() {
		SortedMap<Tiempo, List<Ciclista>> porTiempos = porTiempos();
		List<Ciclista> list = porTiempos.get(porTiempos.firstKey());
		return list.get(0);
	}
	
	public Tiempo tiempoEquipo(String nombreEquipo) {
		Tiempo tiempo = new Tiempo();
		for (Ciclista ciclista : tiempos.keySet()) {
			if (ciclista.getEquipo().equals(nombreEquipo)) {
				tiempo.incrementa(tiempos.get(ciclista));
			}
		}
		return tiempo;
	}
	
	public void muestraClasificacion(String fichero) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fichero);
		muestraClasificacion(pw);
		pw.close();
	}
	
	public void muestraClasificacion(PrintWriter pw) {
		SortedMap<Tiempo, List<Ciclista>> porTiempos = porTiempos();
		for (Tiempo tiempo : porTiempos.keySet()) {
			pw.println(tiempo);
			for (Ciclista ciclista : porTiempos.get(tiempo)) {
				pw.println("\t"+ciclista);
			}
		}
	}
	
	public Clasificacion nuevaClasificacion(String fichero) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fichero));
		Clasificacion clasificacion = nuevaClasificacion(sc);
		sc.close();
		return clasificacion;
	}
	
	public Clasificacion nuevaClasificacion(Scanner sc) {
		Clasificacion clasificacion = new Clasificacion();		
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			Scanner scL = new Scanner(linea);
			scL.useDelimiter("[,:]+");
			try {
				String nombre = scL.next();
				String equipo = scL.next();
				int dorsal = scL.nextInt();
				int horas = scL.nextInt();
				int minutos = scL.nextInt();
				int segundos = scL.nextInt();
				scL.close();
				Ciclista ciclista = new Ciclista(nombre, equipo, dorsal);
				Tiempo tiempo = new Tiempo(horas, minutos, segundos);
				Tiempo tiempoCiclista = tiempos.get(ciclista);
				if (tiempoCiclista != null) {
					tiempo.incrementa(tiempoCiclista);
				}
				clasificacion.agrega(ciclista, tiempo);
			} catch (InputMismatchException e) {
				throw new RuntimeException("Error. Datos no numericos en la linea : " + linea);				
			} catch (NoSuchElementException e) {
				throw new RuntimeException("Error. Faltan elementos en la linea : " + linea);
			} finally {
				scL.close();
			}
		}
		return clasificacion;
	}
}
