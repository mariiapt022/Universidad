package rutas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ruta {
	/**
	 * Nombre de la ruta.
	 */
	private String nombre;

	/**
	 * Lista con los lugares que determinan la ruta.
	 */
	protected List<Lugar> recorrido;

	/**
	 * Constructor para crear rutas con un determinado nombre
	 * 
	 * @param n Nombre de la ruta
	 */
	public Ruta(String n) {
		nombre = n;
		recorrido = new ArrayList<>();
	}

	/**
	 * Devuelve el nombre de la ruta.
	 * 
	 * @return Nombre de la ruta
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para agregar un lugar, proporcionado en el argumento, al array de
	 * lugares recorridos.
	 * 
	 * @param lugar Lugar para agregar a la ruta
	 */
	public void agregar(Lugar lugar) {
		if (lugar == null)
			throw new RutasException("El lugar a agregar no puede ser null");
		recorrido.add(lugar);
	}

	/**
	 * Añade al recorrido los lugares existentes en el fichero determinado por el
	 * primer argumento.
	 * 
	 * @param fichero Nombre del fichero con los datos
	 * @throws FileNotFoundException
	 */
	public void agregarLugares(String fichero) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(fichero))) {
			agregarLugares(sc);
		}
	}

	/**
	 * Añade al recorrido los lugares que se obtienen a través de un scanner, donde
	 * la información viene organizada por líneas con el siguiente formato: 
	 * Nombre del lugar@latitud:longitud
	 * 
	 * @param sc Scanner a través del que se obtiene la información
	 */
	public void agregarLugares(Scanner sc) {

		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			try (Scanner scLinea = new Scanner(linea)) {
				// scLinea.useLocale(new Locale("SP")); // Para usar punto decimal, en vez de
				// coma
				scLinea.useDelimiter("[@:]+");
				String nombre = scLinea.next();
				double latitud = scLinea.nextDouble();
				double longitud = scLinea.nextDouble();
				agregar(new Lugar(nombre, latitud, longitud));
			} catch (InputMismatchException ime) {
				throw new RutasException("Se espera un dato numérico en la línea: " + linea);
			} catch (NoSuchElementException nsee) {
				throw new RutasException("Se esperaban más datos en la línea: " + linea);
			} catch (RutasException re) {
				throw new RutasException("Los datos geoposicionales no están en el rango en la línea: " + linea);
			}
		}
	}

	/**
	 * Método para guardar información de la ruta en un fichero.
	 * 
	 * @param fichero Nombre del fichero
	 * @throws FileNotFoundException
	 */
	public void guardarRuta(String fichero) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(fichero)) {
			guardarRuta(pw);
		}
	}

	/**
	 * Método para pasar la información de la ruta a través de un PrintWriter, con
	 * el formato siguiente: NOMBRE DE LA RUTA Info del lugar 1 Info del lugar 2 ...
	 * La información de cada lugar es el que proporcione toString.
	 * 
	 * @param pw PrintWriter para volcar la información de la ruta
	 */
	public void guardarRuta(PrintWriter pw) {
		pw.println(nombre.toUpperCase() + ":");
		for (Lugar lugar : recorrido) {
			pw.println("\t" + lugar);
		}
	}

	/**
	 * Devuelve el origen de la ruta. En caso de no haberse iniciado esta (la lista
	 * está vacía) se lanzará una excepción.
	 * 
	 * @return Lugar donde se inicia la ruta
	 */
	public Lugar origen() {
		if (recorrido.isEmpty())
			throw new RutasException("Aún no se ha comenzado la ruta");
		return recorrido.get(0);
	}

	/**
	 * Devuelve el destino de la ruta. En caso de no haberse iniciado esta (el array
	 * está vacío) se lanzará una excepción.
	 * 
	 * @return Lugar donde se finaliza la ruta
	 */
	public Lugar destino() {
		if (recorrido.isEmpty())
			throw new RutasException("Aún no se ha comenzado la ruta");
		return recorrido.get(recorrido.size() - 1);
	}

	/**
	 * Devuelve true si el recorrido incluye el lugar dado en el argumento
	 * 
	 * @param lugar Lugar a localizar en el recorrido
	 * @return Si el lugar está en el recorrido
	 */
	public boolean estaEnRuta(Lugar lugar) {
		return recorrido.contains(lugar);
		/*
		boolean encontrado = false;
		Iterator<Lugar> itRecorrido = recorrido.iterator();
		while (!encontrado && itRecorrido.hasNext()) {
			encontrado = itRecorrido.next().equals(lugar);
		}
		return encontrado;
		*/
	}

	/**
	 * Devuelve la distancia acumulada de la ruta, considerando la suma de las
	 * distancias entre lugares consecutivos en el recorrido
	 * 
	 * @return La distancia de toda la ruta
	 */
	public double distanciaRuta() {
		double distancia = 0;
		// Tomamos como lugarPrevio el primero en caso de que
		// se haya comenzado la ruta (el recorrido no está vacío)
		Lugar lugarPrevio = !recorrido.isEmpty() ? recorrido.get(0) : null;
		for (Lugar lugar : recorrido) {
			// El primer lugar coincide con lugarPrevio, pero la distancia es 0
			distancia += lugarPrevio.distancia(lugar);
		}
		// Si la ruta está vacía, o solo tiene un lugar, se devuelve 0
		return distancia;
	}

}
