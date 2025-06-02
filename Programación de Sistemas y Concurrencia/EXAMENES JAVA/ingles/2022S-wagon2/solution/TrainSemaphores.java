package es.uma.psc;

import java.util.concurrent.*;

public class TrainSemaphores implements Train{
	private int wagon1=0, wagon2=0;
	private final Semaphore waitWagon1 = new Semaphore(0);
	private final Semaphore waitWagon2 = new Semaphore(0);
	
	private final Semaphore thereIsSpace = new Semaphore(1);
	private final Semaphore mutex = new Semaphore(1);
	private final Semaphore trainFull = new Semaphore(0);

	@Override
	public void trip(int id) throws InterruptedException {
		thereIsSpace.acquire();
		mutex.acquire();
		if (wagon1 < SIZE_LIMIT) {
			wagon1++;
			System.out.println("Passenger "+id+" has board on wagon 1");
			mutex.release();
			thereIsSpace.release();
			waitWagon1.acquire();
			mutex.acquire();
			wagon1--;
			System.out.println("Passenger "+id+" has got off wagon 1");
			
		} else {
			wagon2++;
			System.out.println("Passenger "+id+" has board on wagon 2");
			
			if (wagon2 < SIZE_LIMIT) thereIsSpace.release();
			else trainFull.release();
			
			mutex.release();
			waitWagon2.acquire();
			mutex.acquire();
			wagon2--;
			System.out.println("Passenger "+id+" has got off wagon 2");
			
		}
		if (wagon1 > 0) waitWagon1.release();
		else if (wagon2 > 0) waitWagon2.release();
		else { // (wagon1+wagon2 == 0)
			System.out.println("**********************************");
			thereIsSpace.release();
		}
		mutex.release();
	}

	@Override
	public void beginTrip() throws InterruptedException {
		trainFull.acquire();
		System.out.println("\tEngine Driver: the trip Starts");
	}

	@Override
	public void endTrip() throws InterruptedException {
		waitWagon1.release();
		System.out.println("\tEngine Driver: the trip Ends");
	}
}
