package prGasolinera;

import java.io.FileNotFoundException;
import java.util.Map;

public class GasolineraPromocion extends Gasolinera {
	private final static double CONSUMO_MINIMO1 = 100;
	private final static double CONSUMO_MINIMO2 = 300;
	private final static double DESCUENTO1 = 0.10;
	private final static double DESCUENTO2 = 0.30;
	
	public GasolineraPromocion(String nombre, Map<String,Double> precios,
							   String nombreFichero)
		throws GasolineraException {
		
		this(nombre,precios,nombreFichero,null);
	}
	
	public GasolineraPromocion(String nombre, Map<String,Double> precios,
							   String nombreFichero, 
							   TicketOrdenAlternativo orden)
		throws GasolineraException {
		super(nombre,precios,nombreFichero,orden);
	}
	
	protected Ticket crearTicket(String matricula, double cantidad, double precio) {
		double consumo = obtenerConsumoFacturado(matricula);
		double descuento;
		if (consumo >= CONSUMO_MINIMO2) {
			descuento = DESCUENTO2;
		} else if (consumo >= CONSUMO_MINIMO1) {
			descuento = DESCUENTO1;
		} else {
			descuento = 0.0;
		}
		Ticket t;
		if (descuento > 0.0) {
			t = new TicketPromocion(sigTicket,nombre,matricula,cantidad,precio,descuento);
		}else {
			t = new Ticket(sigTicket,nombre,matricula,cantidad,precio);
		}
		sigTicket++;
		return t;
	}
}
