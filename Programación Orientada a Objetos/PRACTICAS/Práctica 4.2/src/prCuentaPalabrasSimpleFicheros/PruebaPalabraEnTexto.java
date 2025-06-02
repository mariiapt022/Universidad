package prCuentaPalabrasSimpleFicheros;

public class PruebaPalabraEnTexto {

	public static void main(String[] args) {
		PalabraEnTexto a=new PalabraEnTexto("gorra");
		PalabraEnTexto b=new PalabraEnTexto("Gorra");
		
		a.incrementa();
		
		System.out.println(a);
		System.out.println(b);
		
		boolean res=a.equals(b);
		String sol=res? " ":" no ";
		System.out.println("Las palabras"+sol+"son iguales");

	}

}
