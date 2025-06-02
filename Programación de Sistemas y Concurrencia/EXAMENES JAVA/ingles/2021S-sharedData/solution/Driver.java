package es.uma.psc;

public class Driver {
	private static final int NUM_PROCESSORS=10;
	private static final int NUM_DATA = 5;

	public static void main(String[] args) {
		
		SharedData sharedData = new SharedDataSemaphores(NUM_PROCESSORS);
		Generator e = new Generator(NUM_DATA, sharedData);
		e.start();
		
		for (int i=0; i<NUM_PROCESSORS; i++) 
			new Processor(i, NUM_DATA, sharedData).start();
		
	}

}
