package vuelos;

/**
 * Clase que representa vuelos con posibles retrasos. El retraso se establece aleatoriamente
 * con una limitación de tres veces la duración estimada del vuelo. El retraso afectará a la
 * hora de salida y hora de llegada del vuelo.
 * 
 * @author POO
 *
 */
public class VueloConRetraso extends Vuelo {
	// Variable de clase para generar números aleatorios
	private static java.util.Random rnd = new java.util.Random();
	// Variable de instancia que establece el retraso de vuelo
	private int retraso;

	// Constructor para crear vuelos con retraso, y donde se da valor al retraso.
	public VueloConRetraso(String comp, String codVuelo, Hora salida, int dur, String or, String dest) {
		super(comp, codVuelo, salida, dur, or, dest);
		retraso = rnd.nextInt(3 * getDuracionMinutos());
	}

	/**
	 * Redefinición del método para repercutir el retraso calculado en el constructor.
	 * Tal y como estÃ¡ definido el método getHoraLlegada, no es necesario redefinirlo, 
	 * porque se calcula en función de getHoraSalida.
	 */
	public Hora getHoraSalida() {
		return super.getHoraSalida().horaTrasMinutos(getDuracionMinutos() + retraso);
	}
}
