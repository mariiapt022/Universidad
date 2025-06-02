import java.io.FileNotFoundException;
import java.io.PrintWriter;

import regata.Regata;

public class Main3 {
	public static void main(String [] args) {
		Regata regata = new Regata();
		try {
			regata.leeFichero("barcos.txt");
			PrintWriter out = new PrintWriter(System.out,true);
			regata.escribe(out);
			regata.avanza(10);
			regata.escribeFichero("salida.txt");
			regata.escribe(out);		
		} catch (FileNotFoundException e) {
			System.err.println("error de E/S " + e.getMessage());
		}
	}
}
