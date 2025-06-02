package prGasolinera;

@SuppressWarnings("serial")
public class GasolineraException extends RuntimeException{

	public GasolineraException() {
		super();
	}
	
	public GasolineraException(String mensaje) {
		super(mensaje);
	}
}
