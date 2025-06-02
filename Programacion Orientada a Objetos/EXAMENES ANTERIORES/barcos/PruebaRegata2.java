import java.io.FileNotFoundException;
import java.io.PrintWriter;

import barcos.Posicion;
import barcos.Regata;

public class PruebaRegata2 {
	public static void main(String [] args) throws FileNotFoundException {
		// Se crea un objeto regata con los barcos del fichero barcos.txt
		Regata regata = new Regata(); 	// Apdo. 6.a
		regata.leeBarcos("barcos.txt");	// Apdo. 6.f
		
		// Simulamos la navegación de todos los barcos de la regata durante 15 minutos
		regata.avanzaTodos(15);			// Apdo. 6.c
		
		// Se guarda la información en un fichero y se presenta en el terminal de salida. Apdo. 6.g
		regata.guardaBarcos("barcosTras15min.txt");				
		regata.guardaBarcos(new PrintWriter(System.out,true));
		
		// - los que están fuera de 1 km de alcance desde Málaga. Apdo. 6.h
		Posicion puertoMalaga = new Posicion(36.71,-4.41);
		System.out.println(regata.fueraDeAlcance(puertoMalaga, 1));	
		// - una clasificación de los barcos según el cuadrante en el que se desplazan. Apdo. 6.i
		System.out.println(regata.barcosPorCuadrante());		
	}
}
