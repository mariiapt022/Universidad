package vuelos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Clase que representa todos los vuelos de todos los aeropuertos, considerando
 * que son los mismos cada dí­a (es una simplificación para evitar contemplar el
 * dí­a de cada vuelo). Los vuelos se organizan asociando a ciudades de origen o
 * aeropuertos, el conjunto de vuelos que salen de ese origen.
 * 
 * @author POO
 */
public class Aeropuertos {
	/**
	 * Correspondencia entre aeropuertos y conjuntos de vuelos con ese origen.
	 */
	private Map<String, Set<Vuelo>> vuelos;

	/**
	 * Constructor que inicializa la estructura donde se almacenarán los vuelos.
	 */
	public Aeropuertos() {
		vuelos = new TreeMap<>();
	}

	/**
	 * Método para leer los vuelos almacenados en un fichero, con el siguiente
	 * formato en cada lÃ­nea: 
	 * 			VY6210-Vueling: Málaga-Roma (17:15, 150)
	 * 
	 * @param fichero
	 *            Nombre del fichero con los datos
	 * @throws FileNotFoundException
	 */
	public void leeVuelos(String fichero) throws FileNotFoundException {
		Scanner scFichero = new Scanner(new File(fichero));
		leeVuelos(scFichero);
		scFichero.close();
	}

	/**
	 * Método para leer la información de vuelos que llega a través de un scanner,
	 * organizados en lÃíneas con un formato como el siguiente: 
	 * 		VY6210-Vueling: Málaga-Roma (17:15, 150)
	 * 
	 * @param sc
	 *            Scanner por el que se accede a la información de los vuelos.
	 */
	public void leeVuelos(Scanner sc) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			try (Scanner scLinea = new Scanner(linea)) {
				scLinea.useDelimiter("[-:(,) ]+");
				String codVuelo = scLinea.next();
				String aerolinea = scLinea.next();
				String origen = scLinea.next();
				String destino = scLinea.next();
				int horaSalida = scLinea.nextInt();
				int minutoSalida = scLinea.nextInt();
				int duracionVuelo = scLinea.nextInt();
				Hora hora = new Hora(horaSalida, minutoSalida);
				Vuelo vuelo = new Vuelo(codVuelo, aerolinea, hora, duracionVuelo, origen, destino);
				agregaVuelo(vuelo);
			} catch (InputMismatchException ime) {
				throw new VuelosException("Alguno de los datos numÃ©ricos no se corresponden en la lÃ­nea: " + linea);
			} catch (NoSuchElementException nsee) {
				throw new VuelosException("El formato de la lÃ­nea es incorrecto: " + linea);
			} catch (IllegalArgumentException iae) {
				throw new VuelosException("La hora es incorrecto: " + linea);
			}
		}
	}

	/**
	 * MÃ©todo para agregar un vuelo a la estructura.
	 * 
	 * @param vuelo
	 *            Vuelo a añadir a la correspondencia.
	 */
	public void agregaVuelo(Vuelo vuelo) {
		String aeropuerto = vuelo.getOrigen().toUpperCase();
		Set<Vuelo> vuelosAerop = vuelos.getOrDefault(aeropuerto, new TreeSet<>());
		vuelos.putIfAbsent(aeropuerto, vuelosAerop);
		/*
		 * Otra forma de hacerlo 
		 * Set<Vuelo> vuelosAerop = vuelos.get(aeropuerto); 
		 * if (vuelosAerop == null) { 
		 * 	vuelosAerop = new TreeSet<>();
		 * 	vuelos.put(aeropuerto,vuelosAerop); 
		 * }
		 */
		vuelosAerop.add(vuelo);

	}

	/**
	 * Método para obtener el conjunto de vuelos que salen de una determinada ciudad
	 * (primer argumento) y salen después de la hora indicada en el segundo
	 * argumento, llegando antes de la hora indicada en el tercer argumento.
	 * 
	 * @param ciudad
	 *            Ciudad de salida
	 * @param desde
	 *            Hora mínima de salida del vuelo
	 * @param hasta
	 *            Hora máxima de llegada del vuelo
	 * @return Conjunto con los vuelos que salen de la ciudad
	 */
	public Set<Vuelo> vuelosDesde(String ciudad, Hora desde, Hora hasta) {
		Set<Vuelo> vuelosDesde = vuelos.getOrDefault(ciudad.toUpperCase(), new TreeSet<>());
		Set<Vuelo> resultado = new TreeSet<>(new OrdenVueloHoraSalida());
		for (Vuelo v : vuelosDesde)
			if (v.getHoraSalida().compareTo(desde) >= 0 && v.getHoraLlegada().compareTo(hasta) <= 0)
				resultado.add(v);
		return resultado;
	}

	/**
	 * De todos los vuelos que salen de la ciudad de origen, devuelve un conjunto
	 * ordenado por hora de llegada con aquellos vuelos que llegan a la ciudad de
	 * destino con una salida posterior a la hora indicada en el tercer argumento.
	 * Si cualquiera de los parámetros es null lanzará una NullPointerException.
	 *
	 * @param ciudadOrigen
	 * 				Nombre de la ciudad de origen
	 * @param ciudadDestino
	 * 				Nombre de la ciudad de destino
	 * @param desde
	 * 				Hora desde la que debe salir el vuelo
	 * @return		Conjunto ordenado por hora de llegada
	 */
	public SortedSet<Vuelo> vuelos(String ciudadOrigen, String ciudadDestino, Hora desde) {
		SortedSet<Vuelo> vuelosQueConectan = new TreeSet<>(new OrdenVueloHoraLlegada());
		Set<Vuelo> vuelosDesde = vuelos.getOrDefault(ciudadOrigen, new TreeSet<>());
		for (Vuelo v : vuelosDesde)
			if (desde.compareTo(v.getHoraSalida()) < 0 && ciudadDestino.equalsIgnoreCase(v.getDestino()))
				vuelosQueConectan.add(v);
		return vuelosQueConectan;
	}
	
	/**
	 * Método que devuelve un array con la secuencia de vuelos que van pasando por
	 * los aeropuertos en el array de entrada.
	 * 
	 * @param recorrido
	 *            Secuencia de aeropuertos por los que deben pasar la secuencia de
	 *            vuelos
	 * @return Array con la secuencia de vuelos.
	 */
	public Vuelo[] conexion(String[] recorrido) {
		if (recorrido.length <= 1)
			throw new VuelosException("El array debe incluir al menos dos aeropuertos");
		Vuelo[] vuelosConectados = new Vuelo[recorrido.length - 1];
		String ciudadOrigen = recorrido[0].toUpperCase();
		Hora horaOrigen = new Hora(0, 0);
		for (int i = 1; i < recorrido.length; i++) {
			String ciudadDestino = recorrido[i].toUpperCase();
			// Creamos un conjunto para almacenar los vuelos que conectan, ordenados por
			// hora de llegada
			SortedSet<Vuelo> vuelosQueConectan = vuelos(ciudadOrigen, ciudadDestino, horaOrigen);
			if (vuelosQueConectan.isEmpty())
				throw new VuelosException("ConexiÃ³n imposible");
			Vuelo proximoVuelo = vuelosQueConectan.first();
			// Añaadimos al array de vuelos conectados, el primero de vuelosQueConectan.
			// Como están ordenados por hora de llegada, tomamos el primero que es el que
			// mejor puede conectar con los siguientes vuelos.
			vuelosConectados[i - 1] = proximoVuelo;
			ciudadOrigen = ciudadDestino;
			horaOrigen = proximoVuelo.getHoraLlegada();
		}
		return vuelosConectados;
	}

	/**
	 * Método para guardar en un fichero los vuelos almacenados en el map.
	 *
	 * @param fichero
	 *            Nombre del fichero con los datos
	 * @throws FileNotFoundException
	 */
	public void muestraVuelos(String fichero) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fichero);
		muestraVuelos(pw);
		pw.close();
	}

	/**
	 * Método para imprimir la información almacenada en el map vuelos, considerando
	 * el siguiente formato: 
	 * BARCELONA 
	 * 	IBERIA: Barcelona -> Palma (22:40, 55 min.)
	 * 	IBERIA: Barcelona -> Roma (18:30, 105 min.) 
	 * BRUSELAS 
	 * 	BRUSSELSAIRLINES: Bruselas -> Ginebra (15:15, 75 min.) 
	 * FRANKFURT 
	 * 	LUFTHANSA: Frankfurt -> Munich (17:15, 55 min.) 
	 * GINEBRA 
	 * 	SWISS: Ginebra -> Madrid (18:20, 125 min.) 
	 * ...
	 *
	 * @param pw
	 *            PrintWriter sobre el que se imprime la información
	 */
	public void muestraVuelos(PrintWriter pw) {
		for (String aeropuerto : vuelos.keySet()) {
			pw.println(aeropuerto.toUpperCase());
			for (Vuelo vuelo : vuelos.get(aeropuerto))
				pw.println("\t" + vuelo);
		}
	}
}
