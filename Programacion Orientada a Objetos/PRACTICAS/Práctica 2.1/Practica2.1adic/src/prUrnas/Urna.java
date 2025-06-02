package prUrnas;

public class Urna {
	private int afirmativos, negativos;
	
	public Urna() {
		afirmativos=0;
		negativos=0;
	}
	
		
	public void votar(boolean voto) {
		if(voto) {
			afirmativos++;
		}else {
			negativos++;
		}
	}
	
	public boolean resultado() {
		return afirmativos>=negativos;
	}
	
	
}
