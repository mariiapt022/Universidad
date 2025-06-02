package vuelos;


/**
 * Clase que representa instantes de tiempo, indicando hora y minuto
 * 
 * @author POO
 */
public class Hora implements Comparable<Hora> {
	/**
	 * Atributo para representar la hora (debe ser un valor entero entre 0 y 23)
	 */
	private int hh;

	/**
	 * Atributo para representar los minutos (debe ser un valor entero entre 0 y 59)
	 */
	private int mm;

	/**
	 * Constructor para crear objetos de la clase, a partir de dos enteros. En caso
	 * de no estar en el rango adecuado se lanzará una excepción
	 * IllegalArgumentException.
	 * 
	 * @param h
	 *            Hora (int entre 0 y 23)
	 * @param m
	 *            Minuto (int entre 0 y 59)
	 */
	public Hora(int h, int m) {
		if (h < 0 || h > 23 || m < 0 || m > 59)
			throw new IllegalArgumentException("La hora o los minutos no estÃ¡n en el rango adecuado: " + h + ":" + m);
		hh = h;
		mm = m;
	}

	/**
	 * Devuelve la hora.
	 * 
	 * @return Hora
	 */
	public int getHora() {
		return hh;
	}

	/**
	 * Devuelve los minutos.
	 * 
	 * @return Minutos
	 */
	public int getMinuto() {
		return mm;
	}

	/**
	 * Dos instantes temporales se consideran iguales cuando coinciden hora y minutos.
	 */
	public boolean equals(Object o) {
		boolean res = o instanceof Hora;
		Hora hora = res ? (Hora) o : null;
		return res && hh == hora.hh && mm == hora.mm;
	}

	/**
	 * Redefinición del método hashCode
	 */
	public int hashCode() {
		return Integer.hashCode(hh * 60 + mm);
	}

	/**
	 * Orden natural por el que una hora es menor que otra cuando es anterior
	 * cronológicamente.
	 */
	public int compareTo(Hora hora) {
		int res = Integer.compare(hh, hora.hh);
		if (res == 0)
			res = Integer.compare(mm, hora.mm);
		return res;
	}

	/**
	 * Devuelve la diferencia en minutos entre el objeto receptor y la hora que se
	 * pasa como argumento.
	 * 
	 * @param hora
	 *            Hora
	 * @return Diferencia en mintos
	 */
	public int diferenciaMinutos(Hora hora) {
		int minutos = hh * 60 + mm;
		int minutosHora = hora.hh * 60 + hora.mm;
		return Math.abs(minutos - minutosHora);
	}

	/**
	 * Devuelve la hora una vez transcurridos los minutos que se indican en el
	 * argumento. Si se superan las 24 horas, se pasará al día siguiente.
	 * 
	 * @param minutos
	 *            Minutos transcurridos
	 * @return La hora transcurridos los minutos
	 */
	public Hora horaTrasMinutos(int minutos) {
		int minTotales = mm + minutos;
		return new Hora((hh + minTotales / 60) % 24, minTotales % 60);
	}

	/**
	 * Representación textual del objeto con el formato: hh:mm
	 */
	public String toString() {
		return cero(hh) + ":" + cero(mm);
	}

	/**
	 * Método auxiliar estático para añadir un cero a la hora o los minutos, si
	 * estos solo ocupan un dígito
	 * 
	 * @param i
	 *            hora o minutos
	 * @return Un entero de dos dígitos representando la hora o los minutos
	 */
	private static String cero(int i) {
		return (i < 10 ? "0" : "") + i;
	}
}
