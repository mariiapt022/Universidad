package es.uma.psc;

public class Passenger extends Thread {

	private int id;
	private Train train;
	
	public Passenger(Train train, int id) {
		this.train = train;
		this.id = id;
	}
	
	@Override
	public void run() {
		while (true) try {
			Thread.sleep(2000);
			train.trip(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
