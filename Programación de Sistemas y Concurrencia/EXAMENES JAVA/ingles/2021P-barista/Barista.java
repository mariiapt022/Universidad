package june2021.psc.uma.es;

public class Barista extends Thread {
	private Cafe cafe;
	public Barista(Cafe caf) {
		cafe = caf;
	}

    @Override
	public void run() {
		while(!isInterrupted()) try {
			cafe.prepareCoffee();
		}catch(InterruptedException e) { e.printStackTrace(); }
	}
}
