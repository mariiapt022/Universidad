package prUrnas;

public class SalaVotacion {
	private Urna Urna1;
	private Urna Urna2;
	
	public SalaVotacion() {
		Urna1= new Urna();
		Urna2= new Urna();
	}
	
	public SalaVotacion(Urna Urna1, Urna Urna2) {
		this.Urna1=Urna1;
		this.Urna2=Urna2;
	}
	
	public void votar(int ind,boolean voto) {
		if(ind==1) {
			Urna1.votar(voto);
		}else if(ind==2) {
			Urna2.votar(voto);
		}else {
			throw new RuntimeException("Identificador no válido");
		}
	}
	
	public boolean resultado(int ind) {
		boolean res;
		if(ind==1) {
			res= Urna1.resultado();
		}else if(ind==2) {
			res= Urna2.resultado();
		}else {
			throw new RuntimeException("Identificador no válido");
		}
		return res;
	}
	
}
