package prRegata;

public class Posicion {
	private double longitud;
	private double latitud;
	private static final double  mToKm= 1.60934;
	/**
	 * Crea una posicion
	 * @param lat  	latitud
	 * @param lon	longitud
	 */
	public Posicion(double lat, double lon) {
		latitud = normalizaLat(lat);
		longitud = normalizaLon(lon);
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
	 * Normaliza una latitud
	 * @param lat latitud no normalizada
	 * @return latitud normalizada
	 */
	private double normalizaLat(double lat) {
		double res = lat % 360;
		if (res < 0) {
			res = res + 360;
		}
		// Ya es un numero entre 0 y 360
		if (res > 90 && res <= 270) {
			res = 180 - res;
		} else if (res > 270 && res < 360) {
			res = res - 360;
		}
		return res;
	}
	
	/**
	 * Normaliza la longitud
	 * @param lon longitud no normalizada
	 * @return longitud normalizada
	 */
	private double normalizaLon(double lon) {
		double res = lon % 360;
		if (res < 0) {
			res += 360;
		}
		return res;
	}
	
	@Override
	public String toString() {
		return String.format("l= %4.2f L= %4.2f", latitud, longitud);
	}
	
	/**
	 * Calcula la distancia entre el receptor y una posicion
	 * @param p posicion
	 * @return la distancia en km
	 */
	public double distancia(Posicion p) {
		return (Math.sqrt(Math.pow(Math.cos(latitud)*(longitud-p.longitud), 2) + Math.pow(latitud-p.latitud, 2)))*mToKm;
	}
	
	/**
	 * Posicion final si se parte de la posicion receptora y se avanza 
	 * los minutos dados en el rumbo y velocidad dados
	 * @param minutos	Minutos que se van a avanzar
	 * @param rumbo		Rumbo en el que se avanza
	 * @param velocidad	Velocidad a la que se avanza (km/h)
	 * @return Posicion a la que se llega
	 */
	public Posicion posicionTrasRecorrer(int minutos, int rumbo, int velocidad) {
		double angulo = (360+90-rumbo)%360*(2*Math.PI)/360;
		double lon = longitud + velocidad/mToKm * Math.cos(angulo)*Math.cos(latitud*Math.PI/180)*minutos/60;
		double lat = latitud + velocidad/mToKm * Math.sin(angulo)*minutos/60;
		return new Posicion(lat, lon);
	}
}
