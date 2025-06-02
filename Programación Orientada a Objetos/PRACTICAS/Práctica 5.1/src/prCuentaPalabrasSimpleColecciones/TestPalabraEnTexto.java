package prCuentaPalabrasSimpleColecciones;

public class TestPalabraEnTexto {

	public static void main(String[] args) {
		PalabraEnTexto p1=new PalabraEnTexto("HOLA");
		PalabraEnTexto p2=new PalabraEnTexto("Adios");
		
		p1.incrementa();
		p1.incrementa();
		p1.incrementa();
		p2.incrementa();
		p2.incrementa();
		
		System.out.println(p1.compareTo(p2));
		
		PalabraEnTexto p3=new PalabraEnTexto("hola");
		
		System.out.println(p1.compareTo(p3));
		

	}

}
