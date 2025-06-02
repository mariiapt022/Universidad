package barcos;

/**
 * La clase Barco debe mantener información sobre un barco. En concreto, tendrá una variable 
 * de instancia de tipo String para el nombre, otra de tipo Posicion para la posicion y 
 * dos de tipo int para el rumbo y la velocidad. El rumbo es un ángulo (0 para rumbo norte, 
 * 90 para rumbo este, etc.; así hasta 359) y la velocidad se mide en km/h. Todas las variables 
 * han de ser protected.
 * 
 * @author POO
 *
 */
public class Barco implements Comparable<Barco> {
	protected String nombre;
	protected Posicion posicion;
	protected int rumbo;
	protected int velocidad;
	
	/**
	 * Constructor para crear un barco a partir de un nombre, una posición, un rumbo y una velocidad. 
	 * En caso de que el rumbo no sea el correcto, se lanza excepción RegataException.
	 * @param n	Nombre del barco
	 * @param p	Posición inicial del barco
	 * @param r	Rumbo en grados (0 a 329)
	 * @param v Velocidad en km/h
	 */
	public Barco(String nom, Posicion pos, int rum, int vel) {
		if (rum>=359 || rum < 0) {
			throw new RegataException("Rumbo incorrecto "+ rum);
		}
		nombre = nom;
		posicion = pos;
		rumbo = rum;
		velocidad = vel;
	}

	/**
	 * Devuelve el nombre del barco
	 * @return Nombre del barco
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve la posición del barco
	 * @return Posición del barco
	 */
	public Posicion getPosicion() {
		return posicion;
	}

	/**
	 * Devuelve el rumbo del barco
	 * @return Rumbo del barco
	 */
	public int getRumbo() {
		return rumbo;
	}
	
	/**
	 * Devuelve la velocidad del barco
	 * @return Velocidad del barco
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Simula la navegación del barco, posicionándolo donde corresponda según su rumbo y velocidad, tras
	 * el tiempo proporcionado como argumento (en minutos)
	 * @param mnt	Tiempo de navegación en minutos
	 */
	public void avanza(int mnt) {
		posicion = posicion.posicionTrasRecorrer(mnt, rumbo, velocidad);	
	}
	
	@Override
	/**
	 * Dos barcos son iguales cuando sus nombres coinciden independientemente de mayúsculas y minúsculas.
	 */
	public boolean equals(Object object) {
		boolean res = object instanceof Barco;
		Barco barco = res?(Barco)object: null;
		return res && nombre.equalsIgnoreCase(barco.nombre);
	}
	
	@Override
	/**
	 * Redefinición de hashCode consistente con equals
	 */
	public int hashCode() {
		return nombre.toUpperCase().hashCode();
	}
	
	@Override 
	/**
	 * Un barco es menor que otro cuando su nombre lo es lexicográficamente, independientemente de mayúsculas y minúsculas.
	 */
	public int compareTo(Barco barco) {
		return nombre.compareToIgnoreCase(barco.nombre);
	}
	
	@Override 
	/**
	 * Devuelve una representación textual del barco dado por:
	 * 		Nombre: l= latitud L= longitud R= rumbo V= velocidad
	 */
	public String toString() {
		return nombre + ": " + posicion + " R= "+ rumbo + " V= " + velocidad;
	}
}
