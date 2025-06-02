package alturas;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Mundo ps = Mundo.createFromFile("alturas.txt");
		System.out.println("\nPaises por altura");
		Mundo.presentaEnConsola(ps.paisesPorAltura());
		System.out.println("\nN�mero de Paises por continente");
		Mundo.presentaEnConsola(ps.numeroDePaisesPorContinente());
		System.out.println("\nPaises por continente");
		Mundo.presentaEnConsola(ps.paisesPorContinente());
		System.out.println("\nPaises por inciales");
		Mundo.presentaEnConsola(ps.paisesPorInicial());
		System.out.println("\nMedias de alturas por continente");
		Mundo.presentaEnConsola(ps.mediaPorContinente());
		System.out.println("\nContinentes con mas paises");
		System.out.println(ps.continentesConMasPaises());
	}

}
