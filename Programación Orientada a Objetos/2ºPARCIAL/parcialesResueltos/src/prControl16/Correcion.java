package prControl16;

public class Correcion {
	private String observatorio;
	private double correccion;
	
	public Correcion(String o,double c) {
		observatorio=o;
		correccion=c;
	}
	
	public String getObs() {
		return observatorio;
	}
	
	public double getCo() {
		return correccion;
	}
	
	public String toString() {
		return "("+observatorio+"; "+correccion+")";
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Correcion;
		Correcion c=res? (Correcion)o: null;
		return res&&observatorio.equalsIgnoreCase(c.getObs());
	}
	public int hashCode() {
		return observatorio.hashCode();
	}
	
}
