package barcos;

import java.util.Random;

public class BarcoSinGobierno extends Barco{
	
	private static Random rnd = new Random();
	
	public BarcoSinGobierno(String n, Posicion p, int r, int v) {
		super(n, p, r, v);
	}
	
	public void avanza(int min) {
		for(int i=0; i<min; i++) {
			rumbo = rnd.nextInt(360);
			super.avanza(1);
		}
	}
}
