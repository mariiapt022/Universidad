package es.uma.psc;

public class TrainSyncOrLocks implements Train {

	@Override
	public synchronized void trip(int id) throws InterruptedException {
		
	}

	@Override
	public synchronized void beginTrip() throws InterruptedException {
		
		System.out.println("\tEngine Driver: the trip Starts");
		
	}

	@Override
	public synchronized void endTrip() throws InterruptedException {
		
		System.out.println("\tEngine Driver: the trip Ends");
	}
}
