package prCuentaPalabrasSimpleColecciones;

public class PalabraEnTexto implements Comparable<PalabraEnTexto>{
	private String palabra;
	private int veces;
	
	public PalabraEnTexto (String a) {
		veces = 1;
		palabra = a.toUpperCase();
	}
	
	public void incrementa() {
		veces++;
	}
	
	public boolean equals(Object o) {
		boolean res= o instanceof PalabraEnTexto;
		PalabraEnTexto p=res? (PalabraEnTexto)o:null;
		return res&&p.palabra.equals(palabra);
	}
	
	public int hashCode() {
		return palabra.toUpperCase().hashCode();
	}
	
	public String toString() {
		return palabra+": "+veces;
	}
	
	protected int getVeces() {
		return veces;
	}
	
	protected String palabras() {
		return palabra;
	}

	@Override
	public int compareTo(PalabraEnTexto o) {
		return palabra.compareToIgnoreCase(o.palabra);
	}
}
