package prVotacion;

public class UrnaExc{
	private int afirmativos, negativos;
	private boolean votacion;
	private static final boolean abierto=true;
	private static final boolean cerrado=false;
	
	public UrnaExc() {
		afirmativos=0;
		negativos=0;
		votacion=abierto;
	}
	
	public boolean estaAbierta() {
		return votacion;
	}
	
	public void cerrarVotacion() {
		votacion=cerrado;
	}
	
	public void votar(boolean voto) {
		if(!votacion) {
			throw new RuntimeException("La votacion esta cerrada");
		}else {
			if(voto) {
				afirmativos++;
			}else {
				negativos++;
			}
		}
	}
	
	public boolean resultado() {
		boolean res=false;
		
		if(votacion) {
			throw new RuntimeException("La votacion esta abierta");
		}else {
			if(afirmativos>=negativos) {
				res=true;
			}
		}
		
		return res;
	}
	
	public String toString() {
		String res;
		if(votacion) {
			res="(Urna-Abierta)";
		}else {
			res="("+afirmativos+", "+negativos+", "+resultado()+")";
		}
		return res;
	}
	
}
