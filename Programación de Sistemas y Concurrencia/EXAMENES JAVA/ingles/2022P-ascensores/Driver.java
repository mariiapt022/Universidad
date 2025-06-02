package es.uma.psc.midterm2022;

public class Driver {
	public static final int NUM_LIFTS = 3;
	public static final int NUM_PERSONS = 20;
	public static void main(String[] args) throws InterruptedException {
		Building b = new BuildingSynchronized(NUM_LIFTS);
		Person[] p = new Person[NUM_PERSONS];
		for (int i=0; i<NUM_PERSONS; i++) {
			p[i] = new Person(i, b);
			p[i].start();
		}
		
		// Write here the code to show lifts usage
		
	}
}
