package prSept20;

@SuppressWarnings("serial")
public class AppException extends RuntimeException{
	public AppException() {
		super();
	}
	public AppException(String msg) {
		super(msg);
	}
}
