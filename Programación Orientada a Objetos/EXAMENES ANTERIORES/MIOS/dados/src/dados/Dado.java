package dados;

import java.util.Random;

public class Dado {
	private int cara;
	private Random alea=new Random();
	
	public Dado() {
		agita();
	}
	
	public void agita() {
		cara=alea.nextInt(6)+1;
	}
	
	public int getCara() {
		return cara;
	}
	
	public String toString() {
		return "["+cara+"]";
	}
	
}
