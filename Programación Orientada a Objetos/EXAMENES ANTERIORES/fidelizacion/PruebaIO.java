<pre><div class="text_to_html">import java.io.FileNotFoundException;

import fidelizacion.Cliente;
import fidelizacion.Fecha;
import fidelizacion.IdServicio;
import fidelizacion.Programa;
import fidelizacion.ServicioGasolinera;
import fidelizacion.ServicioSupermercado;

public class PruebaIO {
	public static void main(String[] args) {
		Programa p = new Programa();
		try {
			p.leeTransacciones("transacciones.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Clientes que gastaron más de 300€: " + p.buenosClientesCantidad());
		System.out.println("Clientes con transacciones de más de 100€: " + p.buenosClientesPuntos());

		try {
			p.muestraTransacciones("transacciones2.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
/**
 * Utilizando el fichero transacciones.txt generado por el programa Prueba.java
 * la salida esperada
 * 
 * Clientes que gastaron más de 300€: [Cliente [puntos=32, cantidad=550.0,
 * numero=1], Cliente [puntos=20, cantidad=560.0, numero=0]]
 * 
 * Clientes con transacciones de más de 100€: [Cliente [puntos=20,
 * cantidad=560.0, numero=0]]
 */</div></pre>