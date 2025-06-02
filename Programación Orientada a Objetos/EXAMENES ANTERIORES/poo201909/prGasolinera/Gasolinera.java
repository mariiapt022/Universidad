package prGasolinera;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/* Se quiere desarrollar una aplicación para que los clientes de una estación de servicio pueden repostar 
 * gasolina sin necesidad de hacer el pago de forma inmediata. La aplicación generará un ticket cada
 * vez que un cliente reposta gasolina y cuando el cliente lo solicite generará una factura con aquellos
 * tickets pendientes de facturar. 
 */
public class Gasolinera {
	public static final String GASOLINA95 = "gasolina95";
	public static final String GASOLINA98 = "gasolina98";
	public static final String DIESEL = "diesel";
	public static final String DIESELPLUS = "dieselPlus";
	private static final int NUM_SURT = 4; //Numero de surtidores de cada tipo

	private final Map<String,Double> precios;
	protected String nombre; //Nombre de la estacion de servicio
	protected int sigTicket; //Contador con el número del siguiente ticket a emitir
	private Map<String,List<Double>> surtidores; //Para cada tipo de combustible, lista con el contenido de cada uno de los cuatro surtidores 
	private Map<String,SortedSet<Ticket>> repostajes;  //Para cada matricula (String), conjunto de tickets
	private TicketOrdenAlternativo orden; //Orden alternativo para ordenar los tickets
	
	//No se indica orden para ordenar los tickets, se usará el orden natural
	public Gasolinera(String nombre, Map<String,Double> precios, String nombreFichero) throws GasolineraException {
		this(nombre,precios,nombreFichero,null);
	}
	
	//Orden alternativo para ordenar los tickets
	public Gasolinera(String nombre, Map<String,Double> precios, String nombreFichero, TicketOrdenAlternativo orden) throws GasolineraException {
		this.nombre = nombre;
		this.sigTicket = 1;
		this.precios = precios;
		repostajes = new HashMap<>();
		this.orden = orden;
		crearSurtidores();
		leerFichero(nombreFichero);
	}
	
	//Crea los surtidores. Para cada tipo de combustible se crea la lista. Inicialmente todos vacíos
	private void crearSurtidores() {
		surtidores = new HashMap<>();
		for(String s: new String[]{ GASOLINA95, GASOLINA98, DIESEL, DIESELPLUS } ) {
			List<Double> sts = new ArrayList<>();
			for(int i = 0; i < NUM_SURT; i++) {
				sts.add(0.0);
			}
			surtidores.put(s, sts);
		}
	}
	
	/* Formato del fichero
	 * 
	 *  1 gasolina95 56.0
	 *  1 dieselPlus 34.0
	 *  2 gasolina95 123.0
	 *  2 dieselPlus 34.0
	 *  2 dieselPlus 45.0
	 *  3 gasolina95 76.0
	 * 
	 */
	private void leerFichero(String nombreFichero) throws GasolineraException {
		try (Scanner sc = new Scanner(new File(nombreFichero))){
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				anyadirDatosSurtidor(linea);
			}
		} catch (Exception e) {
			throw new GasolineraException(e.getMessage());
		}
	}
	
	private void anyadirDatosSurtidor(String linea) {
		try (Scanner sc = new Scanner(linea)){
			sc.useLocale(Locale.ENGLISH);
			int num_surtidor= sc.nextInt();
			String tipo = sc.next();
			double contenido = sc.nextDouble();
			anyadirDatosSurtidor(tipo, num_surtidor, contenido);
		}catch(Exception e) {
			/* descartar la entrada y continuar */
		}
	}

	/* Puede haber varias líneas para un mismo surtidor. Se acumulan las cantidades
	 * La cantidad no puede superar la CAPACIDAD de los surtidores
	 */
	private void anyadirDatosSurtidor(String tipo, int num_surtidor, double contenido) {
		if ((0 <= num_surtidor && num_surtidor < NUM_SURT)
			&&(contenido >= 0)) {
			List<Double> sts = surtidores.get(tipo);
			if (sts != null) {
				double nuevo_contenido = sts.get(num_surtidor) + contenido;
				sts.set(num_surtidor,nuevo_contenido);
			}
		}
	}
	
	public void repostar(String matricula, String tipo, int surtidor, double cantidad) {
		List<Double> lista = surtidores.get(tipo);
		if (lista == null || surtidor < 0 || surtidor >= NUM_SURT
			|| cantidad <= 0.0) {
			throw new GasolineraException("Datos incorrectos");
		}
		double capacidad_surtidor = lista.get(surtidor);
		if (cantidad > capacidad_surtidor) {
			cantidad = capacidad_surtidor;
		}
		if (cantidad > 0.0) {
			lista.set(surtidor, capacidad_surtidor - cantidad);
			asociarTicketVehiculo(matricula, cantidad, precios.get(tipo));
		}
	}
	
	protected Ticket crearTicket(String matricula, double cantidad, double precio) {
		Ticket t = new Ticket(sigTicket, nombre, matricula, cantidad, precio);
		sigTicket++;
		return t;
	}
	
	private void asociarTicketVehiculo(String matricula, double cantidad, double precio) {
		SortedSet<Ticket> tickets = repostajes.get(matricula);
		if (tickets == null) {
			tickets = new TreeSet<>(orden);
			repostajes.put(matricula, tickets);
		}
		Ticket t = crearTicket(matricula, cantidad, precio);
		if (tickets.contains(t)) {
			throw new GasolineraException("Ticket duplicado");
		}
		tickets.add(t);
	}
	
	public void facturar(String matricula) throws GasolineraException {
		try(PrintWriter pw = new PrintWriter(nombre+"_"+matricula+".txt")){
			SortedSet<Ticket> tickets = repostajes.get(matricula);
			double total = 0.0;
			if (tickets != null) {
				for (Ticket ticket: tickets) {
					if ( ! ticket.getFacturado() ) {
						pw.println(ticket);
						total = total + ticket.precioTotal();
						ticket.setFacturado(true);
					}
				}
			}
			pw.println("TOTAL = " + total);
		} catch (Exception e) {
			throw new GasolineraException(e.getMessage());
		}
	}
	
	public double obtenerConsumoFacturado(String matricula) {
		double consumo = 0.0;
		SortedSet<Ticket> tickets = repostajes.get(matricula);
		if (tickets != null) {
			for (Ticket t: tickets) {
				if (t.getFacturado()) {
					consumo = consumo + t.getNumLitros();
				}
			}
		}
		return consumo;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(nombre+" = \n");
		sb.append("    Gasolina95: ");
		sb.append(surtidores.get(GASOLINA95)+"\n");
		sb.append("    Gasolina98: ");
		sb.append(surtidores.get(GASOLINA98)+"\n");
		sb.append("    Diesel: ");
		sb.append( surtidores.get(DIESEL)+"\n");
		sb.append("    DieselPlus: ");
		sb.append( surtidores.get(DIESELPLUS)+"\n");
		sb.append("    Repostajes: ");
		sb.append(repostajes.values().toString());
		return sb.toString();
	}
}
