package rutas;

public class Haversine {
	/**
	 * Constante que representa la media del radio de la Tierra.
	 * Utilizada para calcular la distancia entre dos puntos geográficos.
	 */
	private final static double RADIO_TIERRA = 6378.137;
	
	/**
	 * Devuelve la distancia utilizando la fórmula de Havershine entre 
	 * dos posiciones GPS.
	 * @param lat1 Latitud de la primera posición
	 * @param lon1 Longitud de la primera posición
	 * @param lat2 Latitud de la segunda posición
	 * @param lon2 Longitud de la segunda posición
	 * @return	Distancia Havershine entre ambas posiciones
	 */
	public static double distancia(double lat1, double lon1, double lat2, double lon2) {
		// Se pasa a radianes las latitudes y longitudes
		double ltRad1 = Math.toRadians(lat1);
		double lgRad1 = Math.toRadians(lon1);
		double ltRad2 = Math.toRadians(lat2);
		double lgRad2 = Math.toRadians(lon2);
		// Se utiliza la fórmula de Havershine para aproximar la distancia
		double distancia = RADIO_TIERRA * Math.acos(
								Math.cos(ltRad1)*Math.cos(ltRad2)*Math.cos(lgRad2-lgRad1) + 
								Math.sin(ltRad1)*Math.sin(ltRad2)
							  );
		return Math.ceil(distancia*1000) / 1000; // Devuelve la distancia con tres decimales
	}
}
