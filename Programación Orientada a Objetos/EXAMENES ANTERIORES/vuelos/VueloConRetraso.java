package vuelos;

/**
 * Clase que representa vuelos con posibles retrasos. El retraso se establece aleatoriamente
 * con una limitaci�n de tres veces la duraci�n estimada del vuelo. El retraso afectar� a la
 * hora de salida y hora de llegada del vuelo.
 * 
 * @author POO
 *
 */
public class VueloConRetraso extends Vuelo {
	// Variable de clase para generar n�meros aleatorios
	private static java.util.Random rnd = new java.util.Random();
	// Variable de instancia que establece el retraso de vuelo
	private int retraso;

	// Constructor para crear vuelos con retraso, y donde se da valor al retraso.
	public VueloConRetraso(String comp, String codVuelo, Hora salida, int dur, String or, String dest) {
		super(comp, codVuelo, salida, dur, or, dest);
		retraso = rnd.nextInt(3 * getDuracionMinutos());
	}

	/**
	 * Redefinici�n del m�todo para repercutir el retraso calculado en el constructor.
	 * Tal y como está definido el m�todo getHoraLlegada, no es necesario redefinirlo, 
	 * porque se calcula en funci�n de getHoraSalida.
	 */
	public Hora getHoraSalida() {
		return super.getHoraSalida().horaTrasMinutos(getDuracionMinutos() + retraso);
	}
}
