package covid;
//María Peinado Toledo. Doble Grado Ingeniería Informática y Matemáticas. Grupo A
@SuppressWarnings("serial")
public class COVIDException extends RuntimeException{
	public COVIDException() {
		super();
	}
	public COVIDException(String msg) {
		super(msg);
	}
}
