package barcos;

public class PruebaRegata1 {

	public static void main(String[] args) {
		Barco[] barcos = {
				new Barco("Espeto", new Posicion(36.68,-4.4), 350, 20),
				new Barco("Boquerón", new Posicion(36.69,-4.39), 320, 14),
				new Barco("Chanquete", new Posicion(36.71,-4.37), 270, 33),
				new Barco("Concha-Fina", new Posicion(36.7,-4.35), 259, 24),			
		};
		// Se crea un objeto regata para añadir como participantes los barcos anteriores
		Regata regata = new Regata(); 	// Apdo. 6.a
		for(Barco barco : barcos) {
			regata.agrega(barco);		// Apdo. 6.b
		}
		// Simulamos la navegación de todos los barcos de la regata durante 10 minutos
		regata.avanzaTodos(10);			// Apdo. 6.c
		
		// Se obtiene información en pantalla sobre:
		// - si hay barcos sin arrancada. Apdo. 6.d
		System.out.println(regata.hayBarcoSinArrancada());
		// - el primero y el último barco en la regata. Apdo. 6.e
		System.out.println(regata.primero());
		System.out.println(regata.ultimo());	

	}

}
