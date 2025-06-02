package prCuentaPalabrasSimpleFicheros;

public class PruebaContadorPalabras {

	public static void main(String[] args) {
		String[] datos= {"Esta es la primera frase del ejemplo","y esta es la segunda frase"};
		ContadorPalabras a=new ContadorPalabras(5);
		a.incluyeTodas(datos,"[ ]");
		
		System.out.println(a);
		
	}

}
