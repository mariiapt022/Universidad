package prGasolinera;

public class TicketPromocion extends Ticket{
	private double descuento;
	
	public TicketPromocion(int numTicket, String estacion, String matricula, double num_litros, double precio_litro, 
		 double descuento) {
		super(numTicket, estacion, matricula, num_litros, precio_litro);
		this.descuento = descuento;
	}

	public double precioTotal() {
		return super.precioTotal()*(1-descuento);
	}
	
	public String toString() {
		return "PROMOCION "+ descuento*100 + "%: " + super.toString();
	}
}
