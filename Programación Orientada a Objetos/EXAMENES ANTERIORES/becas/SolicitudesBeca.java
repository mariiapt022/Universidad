import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class SolicitudesBeca {
	/** 
	 * Conjunto con todas las becas disponibles. También se podía haber definido como privada.
	 */
	protected Set<Beca> becas;
	
	/**
	 * Correspondencia entre becas y conjuntos de estudiantes que las han solicitado
	 */
	protected Map<Beca,Set<Estudiante>> solicitudes;
	
	/**
	 * Constructor para crear una instancia de la clase donde la correspondencia de becas
	 * solicitadas está inicialmente vacía, y el conjunto de becas disponibles se carga
	 * a partir de un fichero, cuyo nombre se proporciona como parámetro.
	 * @param fichero		Nombre del fichero con la información sobre las becas
	 * @throws FileNotFoundException	En caso de que el fichero no se encuentre
	 */
	public SolicitudesBeca(String fichero) throws FileNotFoundException {
		becas = new HashSet<Beca>();
		solicitudes = new HashMap<Beca,Set<Estudiante>>();
		agregarBecas(fichero);
	}
	
	/**
	 * Método para agregar becas desde la información proporcionada en un fichero, cuyo nombre
	 * se pasa como argumento. La información en el fichero viene con el siguiente formato:
	 * 		código de la beca, cuantía de la beca, tipo de la beca
	 * @param fichero
	 * @throws FileNotFoundException
	 */
	public void agregarBecas(String fichero) throws FileNotFoundException {
		Scanner scFichero = new Scanner(new File(fichero));
		agregarBecas(scFichero);
		scFichero.close();
	}
	
	/**
	 * Método para agregar becas desde la información proporcionada a través de un scanner. 
	 * La información viene con el formato mencionado en el método agregarBecas(String).
	 * @param entrada	Scanner con la información sobre las becas
	 */
	public void agregarBecas(Scanner entrada) {
		while (entrada.hasNextLine()) {
			String linea = entrada.nextLine();
			becas.add(Beca.nuevaBeca(linea));
		}
	}
	
	/**
	 * Método para añadir una solicitud de beca por parte de un estudiante. El estudiante y la beca
	 * se pasan como primer y segundo argumentos. Si la beca no está entre las disponibles (conjunto 
	 * becas), entonces se lanza una excepción BecaException.
	 * 
	 * @param est	Estudiante que solicita la beca
	 * @param becaq	Beca solicitada
	 */
	public void agregarSolicitud(Estudiante est, Beca beca) {
		if (! becas.contains(beca)) throw new BecaException("La beca no pertenece a la oferta");
		Set<Estudiante> solicitantes = solicitudes.get(beca);
		if (solicitantes == null) {
			solicitantes = new HashSet<Estudiante>();
			solicitudes.put(beca, solicitantes);
		}
		solicitantes.add(est);
	}
	
	/**
	 * Devuelve un conjunto con los códigos de las becas solicitadas por el estudiante que se pasa
	 * como argumento.
	 * @param est	Estudiante
	 * @return		Devuelve el conjunto de códigos de becas solicitadas
	 */
	public Set<String> becasSolicitadas(Estudiante est) {
		Set<String> becasSols = new HashSet<String>();
		for(Beca beca : solicitudes.keySet()) {
			if (solicitudes.get(beca).contains(est)) becasSols.add(beca.getCodigo());
		}
		return becasSols;
	}
	
	/**
	 * Cada una de las becas solicitadas se asigna según el criterio que se pasa como argumento. El 
	 * criterio no es más que un orden entre estudiantes.
	 * @param criterio	Orden alternativo entre estudiantes
	 */
	public void asignarBecas(Comparator<Estudiante> criterio) {
		for (Beca beca : solicitudes.keySet()) {
			SortedSet<Estudiante> solicitantes = new TreeSet<Estudiante>(criterio);
			solicitantes.addAll(solicitudes.get(beca));
			Estudiante primero = solicitantes.first();
			beca.asignaBeca(primero);
		}
	}
	
	/**
	 * Guarda las becas asignadas en un fichero, cuyo nombre se pasa como argumento. La información
	 * se vuelca con el formato:
	 * 		beca -> becario
	 * @param fichero	Nombre del fichero
	 * @throws FileNotFoundException
	 */
	public void guardarBecasAsignadas(String fichero) throws FileNotFoundException {
		PrintWriter pwFichero = new PrintWriter(fichero);
		guardarBecasAsignadas(pwFichero);
		pwFichero.close();
	}
	
	/**
	 * Vuelca la información sobre las becas asignadas sobre un PrintWriter que se pasa como argumento.
	 * La información se vuelca con el formato:
	 * 		beca -> becario
	 * @param pw	PrintWriter
	 */
	public void guardarBecasAsignadas(PrintWriter pw) {
		for(Beca beca : solicitudes.keySet()) {
			Estudiante becario = beca.getBecario();
			if (becario != null) pw.println(beca + " -> " + becario);
		}
	}

}
