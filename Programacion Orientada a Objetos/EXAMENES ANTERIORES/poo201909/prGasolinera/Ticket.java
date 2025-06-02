package prGasolinera;

public class Ticket implements Comparable<Ticket>{
	private int numTicket;
	private String gasolinera;
	private String matricula;
	private double numLitros;
	private double precioLitro;
	private boolean facturado;
	
	public Ticket(int numTicket, String gasolinera, String matricula, double num_litros, double precio_litro) {
		if (gasolinera == null || gasolinera.length() == 0 ||
			matricula == null || matricula.length() == 0 ||
			num_litros <= 0.0 || precio_litro <= 0.0) {
			throw new GasolineraException("Valores incorrectos para crear un ticket");
		}
		this.numTicket = numTicket;
		this.gasolinera = gasolinera;
		this.matricula = matricula;
		this.numLitros = num_litros;
		this.precioLitro = precio_litro;
		this.facturado = false;
	}
	
	public int getNumTicket() {
		return numTicket;
	}
	
	public boolean getFacturado() {
		return facturado;
	}
	
	public double getNumLitros() {
		return numLitros;
	}
	
	public String getGasolinera() {
		return gasolinera;
	}
	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}
	
	public double precioTotal() {
		return numLitros * precioLitro;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Ticket) {
			Ticket otro = (Ticket)o;
			res = this.gasolinera.equalsIgnoreCase(otro.gasolinera)
				&& this.numTicket == otro.numTicket;
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return gasolinera.toUpperCase().hashCode()
			+ Integer.hashCode(numTicket);
	}
	
	@Override
	public int compareTo(Ticket o) {
		int res = this.gasolinera.compareToIgnoreCase(o.gasolinera);
		if (res == 0) {
			res = Integer.compare(this.numTicket, o.numTicket);
		}
		return res;
	}
	
	public String toString() {
		return "Ticket: " + numTicket + " (gasolinera: " + gasolinera + 
			   ", matricula: " + matricula + ", litros: " + numLitros +
			   ", PRECIO = " + precioTotal()+")";
	}
}
