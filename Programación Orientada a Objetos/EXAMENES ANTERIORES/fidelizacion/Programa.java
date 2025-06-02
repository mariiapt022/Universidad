package fidelizacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Programa {
	// Servicios asociados al programa. Para facilitar el acceso a través de sus
	// ids, tenemos un map que asocia a cada id su servicio correspondiente.
	private Map<IdServicio, Servicio> servicios;
	// Conjunto de clientes del programa.
	private Set<Cliente> clientes;
	// Conjunto de transacciones realidas en el programa.
	private Set<Transaccion> transacciones;

	public Programa() {
		servicios = new HashMap<>();
		servicios.put(IdServicio.GASOLINERA, new ServicioGasolinera());
		servicios.put(IdServicio.SUPERMERCADO, new ServicioSupermercado());
		clientes = new HashSet<>();
		transacciones = new HashSet<>();
	}

	// devuelve el servicio con el id dado, o null si no existe
	public Servicio servicio(IdServicio id) {
		return servicios.get(id);
	}

	// devuelve el cliente con el id dado, o null si no existe
	public Cliente cliente(int id) {
		Iterator<Cliente> it = clientes.iterator();
		boolean encontrado = false;
		Cliente cl = null;
		while (it.hasNext() && !encontrado) {
			cl = it.next();
			if (cl.getNumero() == id)
				encontrado = true;
		}
		return encontrado ? cl : null;
	}

	public void agregaCliente(Cliente c) {
		clientes.add(c);
	}

	public void realizaTransaccion(IdServicio id, int ca, Fecha fe, int nC) {
		Servicio servicio = servicio(id);
		if (servicio == null)
			throw new FidelizacionException("Servicio no válido");
		Transaccion tr = servicio.hazTransaccion(ca, fe, nC);
		Cliente cliente = cliente(nC);
		if (cliente == null)
			throw new FidelizacionException("Cliente no válido");
		cliente.actualiza(tr);
		transacciones.add(tr);
	}

	// conjunto de clientes que han realizado transacciones por más de 300€
	// ordenados por cantidad.
	public SortedSet<Cliente> buenosClientesCantidad() {
		SortedSet<Cliente> cls = new TreeSet<>(new ClienteCantidad());
		for (Transaccion tr : transacciones) {
			Cliente cl = cliente(tr.getCliente());
			if (cl.getCantidad() > 300)
				cls.add(cl);
		}
		return cls;
	}

	// conjunto de clientes que han realizado alguna transacción por más de 100€
	// ordenados por puntos acumulados.
	public SortedSet<Cliente> buenosClientesPuntos() {
		SortedSet<Cliente> cls = new TreeSet<>(new ClientePuntos());
		for (Transaccion tr : transacciones) {
			if (tr.getCantidad() > 100)
				cls.add(cliente(tr.getCliente()));
		}
		return cls;
	}

	/**
	 * Método para guardar en un fichero las transacciones del programa
	 *
	 * @param fichero Nombre del fichero con los datos
	 * @throws FileNotFoundException
	 */
	public void muestraTransacciones(String fichero) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fichero);
		muestraTransacciones(pw);
		pw.close();
	}

	/**
	 * Método para imprimir las trasacciones del programa
	 *
	 * @param pw PrintWriter sobre el que se imprime la información
	 */
	public void muestraTransacciones(PrintWriter pw) {
		for (Transaccion tr : transacciones)
			pw.println(tr.getCliente() + ":" + tr.getFecha() + ":" + tr.getCantidad() + ":" + tr.getPuntos());
	}

	/**
	 * Método para leer las trasacciones almacenados en un fichero, con el siguiente
	 * formato en cada lí­nea:
	 * 
	 * 1: 8/8/2018: 40.0: 2
	 * 
	 * donde 1 es el número del cliente, seguido de la fecha de la transacción, el
	 * importe en euros de la operación y los puntos obtenidos
	 * 
	 * @param fichero Nombre del fichero con los datos
	 * @throws FileNotFoundException
	 */
	public void leeTransacciones(String fichero) throws FileNotFoundException {
		Scanner scFichero = new Scanner(new File(fichero));
		leeTransacciones(scFichero);
		scFichero.close();
	}

	/**
	 * Método para leer la información de transacciones que llega a través de un
	 * scanner, organizados en líneas con un formato como el siguiente:
	 * 
	 * 1: 8/8/2018: 40.0: 2
	 * 
	 * donde 1 es el número del cliente, seguido de la fecha de la transacción, el
	 * importe en euros de la operación y los puntos obtenidos
	 * 
	 * @param sc Scanner por el que se accede a la información de las trasacciones.
	 */
	public void leeTransacciones(Scanner sc) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			try (Scanner scLinea = new Scanner(linea)) {
				scLinea.useDelimiter(":");
				int numCliente = scLinea.nextInt();
				Fecha fecha = Fecha.parseFecha(scLinea.next());
				double importe = scLinea.nextDouble();
				int puntos = scLinea.nextInt();
				Cliente cl = cliente(numCliente);
				if (cl == null) {
					cl = new Cliente(numCliente);
					clientes.add(cl);
				}
				Transaccion tr = new Transaccion(importe, puntos, fecha, numCliente);
				cl.actualiza(tr);
				transacciones.add(tr);
			} catch (InputMismatchException ime) {
				throw new FidelizacionException("Dato numérico incorrecto");
			} catch (NoSuchElementException nsee) {
				throw new FidelizacionException("Formato incorrecto");
			}
		}
	}

}