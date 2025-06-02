<pre><div class="text_to_html">import java.io.FileNotFoundException;

import fidelizacion.Cliente;
import fidelizacion.Fecha;
import fidelizacion.IdServicio;
import fidelizacion.Programa;

public class Prueba {
	public static void main(String[] args) {
		Programa p = new Programa();
		Cliente cl0 = new Cliente(0);
		p.agregaCliente(cl0);
		Cliente cl1 = new Cliente(1);
		p.agregaCliente(cl1);
		Cliente cl2 = new Cliente(2);
		p.agregaCliente(cl2);
		p.realizaTransaccion(IdServicio.GASOLINERA, 50, new Fecha(1, 8, 2018), 0);
		p.realizaTransaccion(IdServicio.GASOLINERA, 50, new Fecha(8, 8, 2018), 0);
		p.realizaTransaccion(IdServicio.GASOLINERA, 50, new Fecha(15, 8, 2018), 0);
		p.realizaTransaccion(IdServicio.GASOLINERA, 50, new Fecha(22, 8, 2018), 0);
		p.realizaTransaccion(IdServicio.GASOLINERA, 50, new Fecha(29, 8, 2018), 0);
		p.realizaTransaccion(IdServicio.GASOLINERA, 40, new Fecha(2, 8, 2018), 1);
		p.realizaTransaccion(IdServicio.GASOLINERA, 40, new Fecha(8, 8, 2018), 1);
		p.realizaTransaccion(IdServicio.GASOLINERA, 40, new Fecha(14, 8, 2018), 1);
		p.realizaTransaccion(IdServicio.GASOLINERA, 40, new Fecha(20, 8, 2018), 1);
		p.realizaTransaccion(IdServicio.GASOLINERA, 40, new Fecha(24, 8, 2018), 1);
		p.realizaTransaccion(IdServicio.GASOLINERA, 40, new Fecha(30, 8, 2018), 1);
		p.realizaTransaccion(IdServicio.GASOLINERA, 30, new Fecha(3, 8, 2018), 2);
		p.realizaTransaccion(IdServicio.GASOLINERA, 30, new Fecha(8, 8, 2018), 2);
		p.realizaTransaccion(IdServicio.GASOLINERA, 30, new Fecha(13, 8, 2018), 2);
		p.realizaTransaccion(IdServicio.GASOLINERA, 30, new Fecha(18, 8, 2018), 2);
		p.realizaTransaccion(IdServicio.GASOLINERA, 30, new Fecha(23, 8, 2018), 2);
		p.realizaTransaccion(IdServicio.GASOLINERA, 30, new Fecha(28, 8, 2018), 2);
		p.realizaTransaccion(IdServicio.SUPERMERCADO, 150, new Fecha(1, 8, 2018), 0);
		p.realizaTransaccion(IdServicio.SUPERMERCADO, 160, new Fecha(15, 8, 2018), 0);
		p.realizaTransaccion(IdServicio.SUPERMERCADO, 75, new Fecha(1, 8, 2018), 1);
		p.realizaTransaccion(IdServicio.SUPERMERCADO, 80, new Fecha(8, 8, 2018), 1);
		p.realizaTransaccion(IdServicio.SUPERMERCADO, 78, new Fecha(15, 8, 2018), 2);
		p.realizaTransaccion(IdServicio.SUPERMERCADO, 77, new Fecha(23, 8, 2018), 2);
		System.out.println("Clientes que gastaron más de 300€: " + p.buenosClientesCantidad());
		System.out.println("Clientes con transacciones de más de 100€: " + p.buenosClientesPuntos());

		try {
			p.muestraTransacciones("transacciones.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
/**
 * Salida esperada:
 * 
 * Clientes que gastaron más de 300€: [Cliente [puntos=32, cantidad=550.0,
 * numero=1], Cliente [puntos=20, cantidad=560.0, numero=0]]
 * 
 * Clientes con transacciones de más de 100€: [Cliente [puntos=20,
 * cantidad=560.0, numero=0]]
 */</div></pre>