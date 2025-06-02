package rutas;

/**
 * Clase que representa posiciones GPS con latitud y longitud expresadas en
 * grados decimales
 * 
 * @author POO
 *
 */
public class Lugar {
	/**
	 * Constante que representa la media del radio de la Tierra. Utilizada para
	 * calcular la distancia entre dos puntos geográficos.
	 */
	private final static double RADIO_TIERRA = 6378.137;

	/**
	 * Variables para almacenar la latitud y longitud (GPS) de un lugar.
	 */
	private double latitud, longitud;

	/**
	 * Cadena de caracteres que determina la identificación del lugar. Por ejemplo,
	 * nombre de ciudad, lugar turístico, accidente físico, etc.
	 */
	private String nombre;

	/**
	 * Crea un lugar con un determinado nombre, y con la latidud y la longitud
	 * indicadas en los argumentos
	 * 
	 * @nombre n Nombre
	 * @param lt Latitud
	 * @param lg Longitud
	 */
	public Lugar(String n, double lt, double lg) {
		if (Math.abs(lt) > 90)
			throw new RutasException("La latitud debe estar en el rango [-90, 90] grados");
		if (Math.abs(lg) > 180)
			throw new RutasException("La longitud debe estar en el rango [-180, 180] grados");
		nombre = n;
		latitud = lt;
		longitud = lg;
	}

	/**
	 * Devuelve el nombre del lugar
	 * 
	 * @return Nombre del lugar
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve la longitud del lugar
	 * 
	 * @return Longitud
	 */
	public double getLongitud() {
		return longitud;
	}

	/**
	 * Devuelve la latitud del lugar
	 * 
	 * @return Latitud
	 */
	public double getLatitud() {
		return latitud;
	}

	/**
	 * Cambia el nombre del lugar
	 * 
	 * @param nuevoNombre Nuevo nombre del lugar
	 */
	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;
	}

	/**
	 * Función para calcular la distancia geográfica en kilómetros entre dos
	 * posiciones. Utiliza la fórmula de Haversine, que da una buena aproximación.
	 * El resultado se devuelve con tres decimales
	 * 
	 * @param pos Posición con respecto a la que se quiere calcular la distancia
	 * @return Distancia entre la posición que recibe el mensaje y la posición pos
	 */
	public double distancia(Lugar pos) {
		double ltRad = Math.toRadians(latitud);
		double lgRad = Math.toRadians(longitud);
		double pltRad = Math.toRadians(pos.latitud);
		double plgRad = Math.toRadians(pos.longitud);
		double distancia = RADIO_TIERRA * Math.acos(
				Math.cos(ltRad) * Math.cos(pltRad) * Math.cos(plgRad - lgRad) + Math.sin(ltRad) * Math.sin(pltRad));
		return Math.ceil(distancia * 1000) / 1000; // Devuelve la distancia con tres decimales
		// Alternativa utilizando método estático
		// return Haversine.distancia(latitud,longitud,pos.latitud,pos.longitud);
	}

	/**
	 * Dos posicones son iguales cuando coinciden el nombre (independientemente de
	 * mayúsculas o minúsculas) y las respectivas longitudes y latitudes.
	 */
	public boolean equals(Object o) {
		boolean res = o instanceof Lugar;
		Lugar p = res ? (Lugar) o : null;
		return res && p.nombre.equalsIgnoreCase(nombre) && p.longitud == longitud && p.latitud == latitud;
	}

	/**
	 * Redefinición del método hashCode acorde a la redefinición de equals
	 */
	public int hashCode() {
		// return (new Double(latitud + longitud)).hashCode() +
		// nombre.toUpperCase().hashCode;
		return nombre.toUpperCase().hashCode() + Double.hashCode(latitud + longitud);
	}

	/**
	 * Representación textual de una posición, indicando la latitud y longitud entre
	 * paréntesis. Por ejemplo: MAROMA(36.904,-4.044)
	 */
	public String toString() {
		// return nombre.toUpperCase() + "(" + latitud + "," + longitud + ")";
		return nombre.toUpperCase() + ":" + latitud + "," + longitud;
	}

}
