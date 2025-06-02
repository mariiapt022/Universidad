package barcos;

public class Posicion {
	/** 
	 * Variable privada que representa la longitud de una posición en grados decimales.
	 */
	private double longitud;
	
	/**
	 * Variable privada que representa la latidud de una posicion en grados decimales.
	 */
	private double latitud;
	
	/**
	 * Constante que representa la media del radio de la Tierra.
	 * Utilizada para calcular la distancia entre dos puntos geográficos.
	 */
	private final static double RADIO_TIERRA = 6378.137;
	
	/**
	 * Crea una posicion a partir de una latitud y longitud proporcionada 
	 * como argumentos. Tanto una como otra se normalizan para mantener la
	 * latitud entre -90 y 90 y la longitud entre -180 y 179.
	 * @param lat  	latitud
	 * @param lon	longitud
	 */
	public Posicion(double lat, double lon) {
		latitud = normalizaLatitud(lat);
		longitud = normalizaLongitud(lon);
	}
	
	/**
	 * Devuelve la latitud
	 * @return la latitud
	 */
	public double getLatitud() {
		return latitud;
	}
	
	/**
	 * Devuelve la longitud
	 * @return la longitud
	 */
	public double getLongitud() {
		return longitud;
	}
		
	/**
	 * Método auxiliar para normalizar una latitud y que el resultado se encuenter entre -90 y 90
	 * @param lat 	latitud no normalizada
	 * @return 		latitud normalizada
	 */
	private double normalizaLatitud(double lat) {
		double res = lat % 360;
		if (res<0) res += 360;
		// res es un numero entre 0 y 360
		if (res > 90 && res <= 270) 
			res = 180 - res;
		else if (res > 270) 
			res = res - 360;
		return res;
	}
	
	/**
	 * Método auxiliar para ormalizar la longitud y que el resultado se mantenga entre -180 y 179.
	 * @param lon 	longitud no normalizada
	 * @return 		longitud normalizada
	 */
	private double normalizaLongitud(double lon) {
		double res = lon % 360;
		if (res<0) res += 360;
		// res es un numero entre 0 y 360
		if (res >= 180) 
			res = res - 360;
		return res;
	}

	/**
	 * Calcula una aproximación de la distancia geográfica entre el receptor y la posición dada en el argumento. 
	 * Se utiliza la fórmula de Haversine para realizar el cálculo.
	 * @param p posicion
	 * @return la distancia en km
	 */
	public double distancia(Posicion p) {
		// Pasamos longitudes y latitudes a radianes
		double ltRad = Math.toRadians(latitud);
		double lgRad = Math.toRadians(longitud);
		double pltRad = Math.toRadians(p.latitud);
		double plgRad = Math.toRadians(p.longitud);
		// Aplicamos la fórmula de Haversine utilizando una media del radio de la Tierra
		double distancia = RADIO_TIERRA * Math.acos(
								Math.cos(ltRad)*Math.cos(pltRad)*Math.cos(plgRad-lgRad) + 
								Math.sin(ltRad)*Math.sin(pltRad)
							  );
		return Math.ceil(distancia*1000) / 1000; // Devuelve la distancia con tres decimales
	}
	
	/**
	 * Devuelve una estimación de la posicion final que se alcanza si se parte de la posicion receptora y 
	 * se avanza durante los minutos dados como primer argumento en el rumbo y velocidad dados como 
	 * segundo y tercer argumentos, respectivamente.
	 * @param minutos	Tiempo en minutos durante los que se avanza
	 * @param rumbo		Rumbo en el que se avanza (entre 0 y 359 grados decimales)
	 * @param velocidad	Velocidad a la que se avanza (km/h)
	 * @return 			Posicion a la que se llega
	 */
	public Posicion posicionTrasRecorrer(int minutos, int rumbo, int velocidad) {
		double distanciaKm = velocidad*minutos/60;
		double rumboRad = Math.toRadians(rumbo);
		// Se calcula la distancia en km en la dirección E-O y en la dirección N-S
		double distanciaKmLong = distanciaKm*Math.sin(rumboRad);
		double distanciaKmLat = distanciaKm*Math.cos(rumboRad);
		// Se calcula una aproximación en grados decimales de la longitud y la latitd, usando la media del radio de la Tierra
		double dlong = Math.toDegrees(Math.asin(distanciaKmLong/RADIO_TIERRA));
		double dlat = Math.toDegrees(Math.asin(distanciaKmLat/RADIO_TIERRA));
		// Se devuelve la posición tras incrementar la latitud y la longitud
		return new Posicion(latitud+dlat, longitud+dlong);
	}
	
	@Override
	/**
	 * Representación textual de una posición como:
	 * 		l= latitud L= longtud
	 */
	public String toString() {
		return String.format("l= %4.2f L= %4.2f", latitud, longitud);
	}
	
}
