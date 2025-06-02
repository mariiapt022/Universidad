package vuelos;

/**
 * La clase Vuelo representa información sobre un vuelo de una determinada
 * aerolínea con un código de vuelo, la hora de salida, la duración del vuelo,
 * la ciudad de origen y la de destino.
 * 
 * @author POO
 */
public class Vuelo implements Comparable<Vuelo> {

	private String aerolinea;
	private String codigoVuelo;
	private Hora horaSalida;
	private int tiempoViaje;
	private String origen;
	private String destino;

	/**
	 * Constructor para crear objetos de la clase Vuelo. Comprueba si la duración es
	 * estrictamente positiva; en caso contrario, lanza una excepción
	 * VuelosException
	 * 
	 * @param comp
	 *            Nombre de la aerolÃ­nea
	 * @param codVuelo
	 *            Identificador del vuelo
	 * @param salida
	 *            Hora de salida
	 * @param dur
	 *            Tiempo en minutos que dura el viaje
	 * @param or
	 *            Nombre de la ciudad de origen
	 * @param dest
	 *            Nombre de la ciudad de destino
	 * @throws VuelosException
	 */
	public Vuelo(String comp, String codVuelo, Hora salida, int dur, String or, String dest) {
		if (dur < 0)
			throw new VuelosException("La duración de un vuelo no puede ser negativa");
		aerolinea = comp;
		codigoVuelo = codVuelo;
		horaSalida = salida;
		tiempoViaje = dur;
		origen = or;
		destino = dest;
	}

	/**
	 * Devuelve el nombre de la aerolínea
	 * 
	 * @return Nombre de la aerolínea
	 */
	public String getAerolinea() {
		return aerolinea;
	}

	/**
	 * Devuelve el identificador del vuelo
	 * 
	 * @return Código del vuelo
	 */
	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	/**
	 * Devuelve la hora de salida
	 * 
	 * @return Hora de salida
	 */
	public Hora getHoraSalida() {
		return horaSalida;
	}

	/**
	 * Devuelve la duración en minutos del vuelo
	 * 
	 * @return Duración (en minutos)
	 */
	public int getDuracionMinutos() {
		return tiempoViaje;
	}

	/**
	 * Devuelve la ciudad de origen
	 * 
	 * @return Nombre de la ciudad de origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * Devuelve la ciudad de destino
	 * 
	 * @return Nombre de la ciudad de destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * Devuelve la hora de llegada del vuelo a la ciudad de destino
	 * 
	 * @return Hora de llegada
	 */
	public Hora getHoraLlegada() {
		return getHoraSalida().horaTrasMinutos(tiempoViaje);
	}

	/**
	 * Redefinición del método equals, por el que dos vuelos son iguales cuando
	 * coinciden las ciudades de origen y destino, y también el código de vuelo.
	 * Todo ello, independientemente de mayúsculas y minúsculas.
	 */
	public boolean equals(Object o) {
		boolean res = o instanceof Vuelo;
		Vuelo v = res ? (Vuelo) o : null;
		return res && codigoVuelo.equalsIgnoreCase(v.codigoVuelo) && origen.equalsIgnoreCase(v.origen)
				&& destino.equalsIgnoreCase(v.destino);
	}

	/**
	 * Redefinición del método hashCode acorde al método equals.
	 */
	public int hashCode() {
		return codigoVuelo.toUpperCase().hashCode() + origen.toUpperCase().hashCode()
				+ destino.toUpperCase().hashCode();
	}

	/**
	 * Un vuelo es menor que otro cuando la ciudad de origen es anterior
	 * lexicográficamente. En caso de que tengan la misma ciudad de origen, se
	 * considerará el orden lexicográfico de la ciudad de destino. Y si se
	 * mantiene la coincidencia, el orden lexicográfico del código de vuelo. 
	 * En todos los casos, no se tendrán en cuenta las mayúsculas o minúsculas.
	 * 
	 * @param vuelo
	 * @return Devuelve un entero indicando si el receptor es menor (negativo),
	 *         igual (cero) o mayor (positivo) que el argumento.
	 */
	public int compareTo(Vuelo vuelo) {
		int res = origen.compareToIgnoreCase(vuelo.origen);
		if (res == 0)
			res = destino.compareToIgnoreCase(vuelo.destino);
		if (res == 0)
			res = codigoVuelo.compareToIgnoreCase(vuelo.codigoVuelo);
		return res;
	}

	/**
	 * La representación textual de un vuelo vendrá dada por el código de vuelo (en
	 * mayúsculas) seguido de ":" y la ciudad de origen y destino (separadas por
	 * "->"), y la hora de salida y la duración en minutos entre paréntesis y
	 * separados por una coma. Por ejemplo: 
	 * 		IB5090: Málaga -> Barcelona (14:30, 95 min.)
	 */
	public String toString() {
		return codigoVuelo.toUpperCase() + ": " + origen + " -> " + destino 
				+ " (" + horaSalida + ", " + tiempoViaje + " min.)";
	}
}
