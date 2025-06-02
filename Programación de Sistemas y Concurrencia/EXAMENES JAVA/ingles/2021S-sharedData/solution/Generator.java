package es.uma.psc;

import java.util.Random;

public class Generator extends Thread {
	private final static int MAX_VALUE = 100;
	private int numData;
	private SharedData sharedData;
	private int d;
	private Random rnd = new Random();
	
	public Generator(int numData, SharedData sharedData) {
		this.sharedData = sharedData;
		this.numData = numData;
	}
	
	public void run() {
		for (int i=0; i<numData; i++) try {
			d = sharedData.generateData(rnd.nextInt(MAX_VALUE));
			System.out.println("Result of processing = " + d);
			System.out.println("-------------------------------");
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
}
