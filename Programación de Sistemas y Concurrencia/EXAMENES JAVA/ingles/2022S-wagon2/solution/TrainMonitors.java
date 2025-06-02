package es.uma.psc;

public class TrainMonitors implements Train {
	private int wagon1 = 0, wagon2 = 0;
	private boolean waitWagon1 = true;
	private boolean waitWagon2 = true;

	private boolean thereIsSpace = true;
	private boolean trainFull = false;

	@Override
	public synchronized void trip(int id) throws InterruptedException {
		while (!thereIsSpace)
			wait();

		if (wagon1 < 5) {
			wagon1++;
			System.out.println("Passenger "+id+" has board on wagon 1");
			while (waitWagon1)
				wait();
			wagon1--;
			System.out.println("Passenger "+id+" has got off wagon 1");
			if (wagon1 == 0) {
				waitWagon1 = true;
				notifyAll();
			}

		} else {
			wagon2++;
			System.out.println("Passenger "+id+" has board on wagon 2");

			if (wagon2 == 5) {
				trainFull = true;
				thereIsSpace = false;
				notifyAll();
			}
			while (waitWagon2)
				wait();
			wagon2--;
			System.out.println("Passenger "+id+" has got off wagon 2");
			if (wagon2 == 0)
				waitWagon2 = true;
		}
		if (wagon1 + wagon2 == 0) {
			System.out.println("**********************************");
			thereIsSpace = true;
			notifyAll();
		}
	}

	@Override
	public synchronized void beginTrip() throws InterruptedException {
		while (!trainFull)
			wait();
		System.out.println("\tEngine Driver: the trip Starts");
		trainFull = false;
	}

	@Override
	public synchronized void endTrip() throws InterruptedException {
		System.out.println("\tEngine Driver: the trip Ends");
		waitWagon1 = false;
		notifyAll();
		while (! waitWagon1)
			wait();
		waitWagon2 = false;
		notifyAll();

	}
}
