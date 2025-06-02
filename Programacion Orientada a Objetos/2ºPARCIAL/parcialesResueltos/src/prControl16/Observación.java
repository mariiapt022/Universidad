package prControl16;

public class Observaci�n {
	private String observatorio,estrella;
	private double magnitud;
	
	public Observaci�n(String o,String e,double m) {
		observatorio=o;
		estrella=e;
		magnitud=m;
	}
	
	public String getObs() {
		return observatorio;
	}
	
	public String getEst() {
		return estrella;
	}
	
	public double getMag() {
		return magnitud;
	}
	
	public String toString() {
		return "("+ observatorio+"; "+estrella+"; "+magnitud+")";
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res=o instanceof Observaci�n;
		Observaci�n ob=res? (Observaci�n)o: null;
		return res&&(observatorio.equalsIgnoreCase(ob.observatorio))&&(estrella.equalsIgnoreCase(ob.estrella));
	}
	public int hashCode() {
		return observatorio.toUpperCase().hashCode()+estrella.toUpperCase().hashCode();
	}
	
}
