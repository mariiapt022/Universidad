package becas;

@SuppressWarnings("serial")
public class BecasException extends RuntimeException{
	public BecasException() {
		super();
	}
	public BecasException(String msg) {
		super(msg);
	}
}
