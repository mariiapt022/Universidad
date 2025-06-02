package es.uma.psc;

import java.util.concurrent.*;

public class TrainSemaphores implements Train {

	@Override
	public void trip(int id) throws InterruptedException {
		
	}

	@Override
	public void beginTrip() throws InterruptedException {
		
		System.out.println("\tEngine Driver: the trip Starts");
	}

	@Override
	public void endTrip() throws InterruptedException {
		
		System.out.println("\tEngine Driver: the trip Ends");
	}
}
