package barcos;

import java.util.Random;

/**
 * La clase BarcoSinGobierno representa barcos donde el rumbo va variando aleatoriamente conforme avanza.
 * Hereda de la clase Barco, y redefine el método avanza.
 * 
 * @author POO
 *
 */
public class BarcoSinGobierno extends Barco {
	/**
	 * Variable estática para generar rumbos aleatorios.
	 */
	private static Random rnd = new Random();
	
	/**
	 * Constructor que crea objetos de la clase BarcoSinGobierno. Invoca el constructor de la clase Barco
	 * @param nom	Nombre del barco
	 * @param pos	Posición inicial del barco
	 * @param rum	Rumbo original
	 * @param vel	Velocidad del barco
	 */
	public BarcoSinGobierno(String nom, Posicion pos, int rum, int vel) {
		super(nom,pos,rum,vel);
	}
	
	/**
	 * Redefinición del método avanza que modifica el rumbo de forma aleatoria cada minuto.
	 */
	public void avanza(int min) {
		for(int i=0; i<min; i++) {
			rumbo = rnd.nextInt(360);
			super.avanza(1);
		}
	}
}
