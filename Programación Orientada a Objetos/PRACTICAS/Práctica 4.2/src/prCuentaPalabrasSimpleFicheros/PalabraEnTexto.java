package prCuentaPalabrasSimpleFicheros;

public class PalabraEnTexto {
	protected String palabra;
	private int veces;
	
	public PalabraEnTexto(String p) {
		palabra=p.toUpperCase();
		veces=1;
	}
	
	public void incrementa() {
		veces+=1;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res=o instanceof PalabraEnTexto;
		PalabraEnTexto p=res? (PalabraEnTexto)o:null;
		return res&&palabra.equals(p.palabra);
	}
	@Override
	public int hashCode() {
		return palabra.hashCode();
	}
	
	public String toString() {
		return palabra+": "+veces;
	}
	
}
