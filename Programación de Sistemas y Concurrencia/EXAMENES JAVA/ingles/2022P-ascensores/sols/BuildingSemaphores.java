package es.uma.psc.midterm2022;

import java.util.concurrent.Semaphore;

public class BuildingSemaphores implements Building {
	private final int numLifts;
	private boolean liftAvail[];
	private int liftUsage[];
	private int numLiftsAvail;
	private final Semaphore waitForLift = new Semaphore(1, true);
	private final Semaphore mutex = new Semaphore(1, true);

	public BuildingSemaphores(int numLifts) {
		this.numLifts = numLifts;
		this.numLiftsAvail = numLifts;
		this.liftAvail = new boolean[numLifts]; // Initialized to false by default
		for(int i=0; i<numLifts; i++)
			this.liftAvail[i] = true;
		this.liftUsage = new int[numLifts]; // Initialized to 0 by default
	}

	@Override
	public int boardOnLift(int id) throws InterruptedException {
		waitForLift.acquire();
		mutex.acquire();
		
		numLiftsAvail--;
		int liftId = getFirstAvailLift();
		liftAvail[liftId] = false;
		liftUsage[liftId]++;
		System.out.println("Person "+id+" takes the lift "+liftId);
		
		if (numLiftsAvail != 0)
			waitForLift.release();
		mutex.release();
		return liftId;
	}

	@Override
	public void boardOffLift(int id, int liftId) throws InterruptedException {
		mutex.acquire();

		System.out.println("Person "+id+" releases the lift "+liftId);
		numLiftsAvail++;
		liftAvail[liftId] = true;
		if (numLiftsAvail == 1)
			waitForLift.release();
		
		mutex.release();
	}

	private int getFirstAvailLift() {
		for(int i=0; i<numLifts; i++)
			if (liftAvail[i])
				return i;
		throw new IllegalStateException("No lift available");
	}

	@Override
	public void showUsage() {
		for(int i=0; i<numLifts; i++)
			System.out.println("Lift "+i+" used "+liftUsage[i]);
	}

}
