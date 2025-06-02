package june2021.psc.uma.es;

public class Driver {
	private static final int NUM_CLIENTS = 10;
	public static void main(String[] args) {
		// Create objects and threads
		Cafe cafe = new Cafe();
		Barista bar = new Barista(cafe);
		Client clients[] = new Client[NUM_CLIENTS];
		for(int i = 0; i < clients.length; i++)
			clients[i] = new Client(i, cafe);
		// Start threads
		bar.start();
		for(int i = 0; i < clients.length; i++)
			clients[i].start();
	}
}
