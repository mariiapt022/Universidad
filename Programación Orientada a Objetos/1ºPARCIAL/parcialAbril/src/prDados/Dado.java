package prDados;

import java.util.Random;

public class Dado {
	private int top;
	private static Random alea;
	
	public Dado() {
		top= alea.nextInt(6)+1;
		alea = new Random();
	}
	
	public void agita() {
		top = alea.nextInt(6)+1;
	}
	
	public int getCara() {
		return top;
	}
	
	public String toString() {
		return top+"";
	}

}
