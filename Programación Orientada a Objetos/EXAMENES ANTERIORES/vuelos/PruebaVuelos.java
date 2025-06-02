import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

import vuelos.*;

public class PruebaVuelos {

	public static void main(String[] args) throws FileNotFoundException {
		// Creaci�n de un vuelo
		Vuelo v = new Vuelo("Ryanair", "FR1234", new Hora(17,30), 90, "M�laga", "Bolonia");
		// Representaci�n textual del vuelo y comprobaci�n del m�todo getHoraLlegada
		System.out.println("El vuelo " + v + " llega a las " + v.getHoraLlegada());
		
		// Creaci�n de un vuelo con retraso
		VueloConRetraso vr = new VueloConRetraso("Ryanair", "FR1234", new Hora(17,30), 90, "M�laga", "Bolonia");
		System.out.println("El vuelo " + vr + " sale con retraso a las " + vr.getHoraSalida() + " y llega a las " + vr.getHoraLlegada());
		
		// Creaci�n de una instancia de la clase Aeropuertos
		Aeropuertos aeros = new Aeropuertos();
		// Lectura del fichero vuelos.txt
		aeros.leeVuelos("vuelos.txt");
		
		// Array con el recorrido a realizar
		String[] recorrido = {"M�laga", "Madrid", "Roma", "Barcelona", "Palma"};
		// Imprime en la consola los vuelos que conectan las ciudades anteriores 
		System.out.println(Arrays.toString(aeros.conexion(recorrido)));
		
		// Imprime en la consola los vuelos que salen de M�laga despu�s de las 11:30 y llegan a su destino antes de las 16:00
		System.out.println(aeros.vuelos("M�laga", "Barcelona", new Hora(11,30)));
	
		// Presenta en la consola y guarda en el fichero salida.txt todos los vuelos existentes
		aeros.muestraVuelos(new PrintWriter(System.out,true));
		aeros.muestraVuelos("salida.txt");
	}

}
