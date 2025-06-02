package barcos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * La clase Regata mantiene información en una estructura adecuada de todos 
 * los barcos participantes en una regata, ordenados según su distancia a Málaga
 * 
 * @author POO
 *
 */
public class Regata {
	/**
	 * Conjunto ordenado para almacenar la información de los participantes en la regata
	 */
	private SortedSet<Barco> participantes;
		
	/** 
	 * Constructor para crear regatas. Se inicializa el conjunto ordenado de 
	 * forma adecuada.
	 */
	public Regata() {
		participantes = new TreeSet<>(new OrdenDistanciaMalaga()); 
	}
		
	/** 
	 * Agrega un barco a los participantes si no estaba incluido.
	 * @param b
	 */
	public void agrega(Barco b) {
		participantes.add(b);
	}
	
	
	/**
	 * Método para hacer que todos los barcos participantes avancen según su rumbo y velocidad durante los minutos
	 * establecidos en el argumento.
	 * @param mnt Tiempo 
	 */
	public void avanzaTodos(int mnt) {
		for(Barco b : participantes) {
			b.avanza(mnt);
		}
	}
	
	/** 
	 * Método para establecer si hay algún barco con velocidad superior a
	 * la indicada en el argumento.
	 * @param velocidad
	 * @return
	 */
	public boolean velocidadSuperiorA(int velocidad) {
		Iterator< Barco> it = participantes.iterator();
		// Mientras haya más elementos y no se haya encontrado ningún barco rápido
		while (it.hasNext() && it.next().getVelocidad() < velocidad) {
		}
		// Si después de salir del bucle sigue habiendo elementos (true) es porque
		// se ha encontrado uno con velocidad alta. Si no hay más elementos (false) es
		// porque todos están por debajo de la velocidad indicada.
		return it.hasNext();
	}
	
	/** 
	 * Devuelve cierto si alguno de los barcos participantes está sin arrancada (velocidad igual a 0)
	 * @return cierto si hay algún barco parado
	 */
	public boolean hayBarcoSinArrancada() {
		Iterator< Barco> it = participantes.iterator();
		boolean res = false; // Variable que determina si hay algún barco con velocidad cero. Inicialmente, no lo hay.
		// Mientras haya más barcos y no haya barco sin arrancada
		while (it.hasNext() && ! res) {
			res = it.next().getVelocidad() == 0;
		}
		return res;
	}
	
	/**
	 * Devuelve el barco que va primero en la regata
	 * @return El primer barco
	 */
	public Barco primero() {
		return participantes.first();
	}
	
	/**
	 * Devuelve el barco que va último en la regata
	 * @return El último barco
	 */
	public Barco ultimo() {
		return participantes.last();
	}
	
	/**
	 * Devuelve una lista con todos los barcos que están dentro de un círculo con centro
	 * la posición indicada como primer argumento y radio la distancia indicada en el segundo argumento.
	 * @param p
	 * @param km
	 * @return Lista de barcos dentro del círculo
	 */
	public List<Barco> dentroDelCirculo(Posicion p, int km) {
		List<Barco> barcos = new ArrayList<>(); 
		for(Barco b : participantes) {
			if (b.getPosicion().distancia(p) < km) {
				barcos.add(b);
			}
		}
		return barcos;
	}
	
	/**
	 * Devuelve una lista con todos los barcos que están fuera de un círculo con centro en
	 * la posición indicada como primer argumento y radio la distancia indicada en el segundo argumento.
	 * @param p		Posición de referencia
	 * @param km	Distancia de separación
	 * @return Lista de barcos fuera del alcance
	 */
	public List<Barco> fueraDeAlcance(Posicion p, int km) {
		List<Barco> barcos = new ArrayList<>(); 
		for(Barco b : participantes) {
			if (b.getPosicion().distancia(p) > km) {
				barcos.add(b);
			}
		}
		return barcos;
	}
	
	/**
	 * Se llama cota de un barco al entero que resulta de dividir la velocidad del mismo por 10.
	 * Este método devuelve una correspondencia que a cada cota le asocia los barcos participantes con esa cota. 
	 * Por ejemplo, si un barco va a 34 km/h se asociará a la cota 3 (34/10 = 3). 
	 * @return Correspondencia que asocia a cada cota los barcos que van en ese rango de velocidad
	 */
	public Map<Integer, Set<Barco>> barcosPorVelocidad() {
		Map<Integer, Set<Barco>> map = new TreeMap<>();
		for(Barco b: participantes) {
			int v = b.getVelocidad()/10;
			// Los barcos van ordenados (para cada velocidad) según orden natural (no el orden de distancia a Málaga)
			Set<Barco> cjto = map.getOrDefault(v,new TreeSet<>());
			cjto.add(b);
			map.putIfAbsent(v, cjto);
			/* Otra forma de hacerlo (antes de la 1.8)
			if (set == null) {
				set = new TreeSet<>();
				map.put(v, set);
			}
			set.add(b);
			*/
		}
		return map;
	}
	
	/**
	 * Método que devuelve una correspondencia que asocia a cada cuadrante (desde el 1 al 4)
	 * los barcos que se desplazan en ese cuadrante. El cuadrante en el que se desplaza un barco
	 * viene determinado por su rumbo. 
	 * Por ejemplo, si un barco tiene rumbo 300 se está desplazando en el 4º cuadrante, 
	 * mientras que si su rumbo es 70 grados, se mantiene en el cuadrante 1º.
	 * @return Correspondencia que asocia a cada cota los barcos que van en ese rango de velocidad
	 */
	public Map<Integer, Set<Barco>> barcosPorCuadrante() {
		Map<Integer, Set<Barco>> map = new TreeMap<>();
		for(Barco b: participantes) {
			// A partir del rumbo (de 0 a 359), generamos el cuadrante (de 1 a 4)
			int cuad = b.getRumbo()/90 + 1;
			// Para cada cuadrante, los barcos de ese cuadrante se ordenan por orden natural (no el orden de distancia a Málaga)
			Set<Barco> cjto = map.getOrDefault(cuad,new TreeSet<>());
			cjto.add(b);
			map.putIfAbsent(cuad, cjto);
			/* Otra forma de hacerlo (antes de la 1.8)
			if (set == null) {
				set = new TreeSet<>();
				map.put(v, set);
			}
			set.add(b);
			*/
		}
		return map;
	}
	
	/** 
	 * Método que devuelve el conjunto de barcos
	 * @return
	 */
	public Set<Barco> getParticipantes() {
		return participantes;
	}
	
	/**
	 * Método para obtener los barcos participantes en un conjunto ordenados según el nombre del barco (orden natural)
	 * @return Conjunto de participantes ordenados por nombre
	 */
	public Set<Barco> ordenadosPorNombre() {
		Set<Barco> set = new TreeSet<>();
		set.addAll(participantes);
		return set;
	}
	
	/**
	 * Método estático que crea un barco a partir de una cadena de caracteres con el formato siguiente:
	 * 	 Gamonal, -30, 290, 0, 24
	 * @param dato Cadena de caracteres con la información de un barco
	 * @return	Objeto barco correspondiente a la cadena
	 */
	public static Barco creaBarcoString(String dato) {
		try (Scanner sc = new Scanner(dato)) {
			sc.useDelimiter("[: ]+");
			String nombre = sc.next();
			double lat = sc.nextDouble();
			double lon = sc.nextDouble();
			Posicion posicion = new Posicion(lat, lon);
			int rumbo = sc.nextInt();
			int velocidad = sc.nextInt();
			return new Barco(nombre, posicion, rumbo, velocidad);
		} catch (InputMismatchException e) {
			throw new RegataException("Algun dato numerico es erroneo en " + dato);
		} catch (NoSuchElementException e) {
			throw new RegataException("Faltan datos  en " + dato);			
		}
	}
	
	/**
	 * Incorpora los barcos cuya información se proporciona en el fichero cuyo nombre se pasa como argumento.
	 * @param nFichero	Nombre del fichero con los datos
	 * @throws FileNotFoundException
	 */
	public void leeBarcos(String nFichero) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File(nFichero))) {
			leeBarcos(scanner);
		}
	}
	
	/** 
	 * Incorpora  los barcos proporcionados a través del scanner al conjunto de participantes
	 * @param sc Scanner a través del que se proporcionan los datos de los barcos
	 */
	public void leeBarcos(Scanner sc) {
		while (sc.hasNextLine()) {
			agrega(creaBarcoString(sc.nextLine()));
		}
	}
	
	/**
	 * Guarda la información de los barcos participantes en un fichero
	 * @param nFichero	Nombre del fichero
	 * @throws FileNotFoundException
	 */
	public void guardaBarcos(String nFichero) throws FileNotFoundException {
		try (PrintWriter printWriter = new PrintWriter(nFichero)) {
			guardaBarcos(printWriter);
		}
	}
	
	/**
	 * Transfiere la información de los barcos participantes en el printwriter indicado como argumento
	 * @param pw 	PrintWriter para trasvasar la información de los participantes
	 */
	public void guardaBarcos(PrintWriter pw) {
		for (Barco b: participantes) {
			pw.println(b);
		}
	}
 }

