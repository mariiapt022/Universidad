package june2021.psc.uma.es;

import java.util.Random;

public class Client extends Thread {
	private Random rnd = new Random();
	private Cafe cafe;
	private int id;
	public Client(int i, Cafe caf) {
		id = i;
		cafe = caf;
	}

    @Override
	public void run() {
		while(!isInterrupted()) try {
			Thread.sleep(100);
			cafe.enterCafe(id);
			cafe.waitCoffee(id);
			Thread.sleep(rnd.nextInt(100)); // Looking for money to pay...
			cafe.payAndExitCafe(id);
		}catch(InterruptedException e) { e.printStackTrace(); }
	}
}
