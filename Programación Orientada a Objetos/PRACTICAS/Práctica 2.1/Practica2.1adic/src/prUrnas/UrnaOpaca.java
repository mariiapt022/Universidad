package prUrnas;

public class UrnaOpaca extends Urna {
	private static final boolean abierto=true;
	private static final boolean cerrado=false;
	private boolean votacion;
	
	public UrnaOpaca() {
		super();
		votacion=abierto;
	}
	
	public boolean estaAbierta() {
		return votacion;
	}
	
	public void cerrarVotacion() {
		votacion=cerrado;
	}
	
	@Override
	
	public void votar(boolean voto) {
		if(votacion==abierto) {
			super.votar(voto);
		}
	}
	
	public boolean resultado() {
		votacion=cerrado;
		return super.resultado();
	}
}
