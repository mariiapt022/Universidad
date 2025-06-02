package relacion2;

public class Ejercicio1 {

	public static void main(String[] args) {
		NumeroRacional resultado;
		NumeroRacional f1=new NumeroRacional(1,2);
		System.out.println(f1);
		NumeroRacional f2=new NumeroRacional(4,-7);
		System.out.println(f2);
		resultado=f1.suma(f2);
		System.out.println(resultado);
	}

}
