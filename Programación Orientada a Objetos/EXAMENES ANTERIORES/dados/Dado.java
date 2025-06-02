package dados;

import java.util.Random;

public class Dado {
	private static Random aleat = new Random();
	
	private int cara;
	
	public Dado() {
		agita();
	}
	
	public void agita() {
		cara = aleat.nextInt(6)+1;
	}
	
	public int getCara() {
		return cara;
	}

	public String toString() {
		return "[" + cara + "]";
	}
}
