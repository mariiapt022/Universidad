package prGasolinera;

public class Ticket implements Comparable<Ticket>{
	private int numTicket;
	private String nombreGas,matricula;
	private double numLitros,precio;
	private boolean facturado;
	
	public Ticket(int nt,String ng,String m,double nl,double pl) {
		
		if(pl<=0||nl<=0||m==null||ng==null) {
			throw new GasolineraException("No se ha podido crear el ticket");
		}else {
			numTicket=nt;
			nombreGas=ng;
			matricula=m;
			numLitros=nl;
			precio=pl;
			facturado=false;
		}
				
	}

	public int getNumTicket() {
		return numTicket;
	}

	
	public String getGasolinera() {
		return nombreGas;
	}

		
	public double getNumLitros() {
		return numLitros;
	}

	public boolean getFacturado() {
		return facturado;
	}

	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}
	
	public double precioTotal() {
		return precio*numLitros;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Ticket;
		Ticket t= res? (Ticket)o: null;
		return res&&this.getGasolinera().equalsIgnoreCase(t.getGasolinera())&&this.getNumTicket()==t.getNumTicket();
	}
	
	public int hashCode() {
		return nombreGas.hashCode()+Integer.hashCode(numTicket);
	}
	
	@Override
	public int compareTo(Ticket t) {
		int res=nombreGas.compareToIgnoreCase(t.getGasolinera());
		if(res==0) {
			res=Integer.compare(numTicket, t.getNumTicket());
		}
		return res;
	}
	
	public String toString() {
		return "Ticket: "+numTicket+" ("+nombreGas+", "+matricula+", "+numLitros+", "+this.precioTotal()+")";
	}
	
	
}
