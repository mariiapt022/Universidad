package prGasolinera;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Gasolinera {
	protected String nombre;
	protected int contador;
	private Map<String,List<Double>> surtidores;
	private Map<String,SortedSet<Ticket>> repostajes;
	private TicketOrdenAlternativo orden;
	public static final String GASOLINA95="gasolina95";
	public static final String GASOLINA98="gasolina98";
	public static final String DIESEL="diesel";
	public static final String DIESELPLUS="dieselplus";
	private Map<String, Double> precios = null;
	private static final int NUM_SURT=4;
	
	public Gasolinera(String nombre, Map<String,Double> precios, String nombreFichero, TicketOrdenAlternativo orden) {
		this.nombre=nombre;
		contador=1;
		repostajes=new HashMap<>();
		this.precios=precios;
		this.orden=orden;
		crearSurtidores();
		leerFichero(nombreFichero);
	}
	
	public Gasolinera(String nombre, Map<String,Double> precios, String nombreFichero) {
		this(nombre,precios,nombreFichero,null);
	}
	
	private void crearSurtidores() {
		surtidores=new HashMap<>();
		for(String s:new String[]{ GASOLINA95, GASOLINA98, DIESEL, DIESELPLUS }) {
			List<Double> sts = new ArrayList<>();
			for(int i = 0; i < NUM_SURT; i++) {
				sts.add(0.0);
			}
			surtidores.put(s, sts);
		}
	}
	
	private void leerFichero(String nomFich) {
		try(Scanner sc=new Scanner(new File(nomFich))){
			while(sc.hasNextLine()) {
				String linea=sc.nextLine();
				añadirDatosSurtidor(linea);
			}
		}catch(Exception e) {
			throw new GasolineraException(e.getMessage());
		}
	}
	
	private void añadirDatosSurtidor(String linea) {
		try(Scanner sc=new Scanner(linea)){
			sc.useLocale(Locale.ENGLISH);
			sc.useDelimiter(" ");
			int numSurtidor=sc.nextInt();
			String tipo=sc.next();
			double contenido=sc.nextDouble();
			añadirDatosSurtidor(numSurtidor,tipo,contenido);
		}catch(Exception e) {
			
		}
	}
	
	private void añadirDatosSurtidor(int num,String tipo,double contenido) {
		if(num>0&&tipo!=null&&contenido>=0.0&&num<NUM_SURT) {
			List<Double> surt=surtidores.get(tipo);
			if(surt!=null) {
				double nuevo=surt.get(num)+contenido;
				surt.set(num, nuevo);
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
	
	protected Ticket crearTicket(String matricula,double cantidad,double precio) {
		Ticket t = new Ticket(contador, nombre, matricula, cantidad, precio);
		contador++;
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
