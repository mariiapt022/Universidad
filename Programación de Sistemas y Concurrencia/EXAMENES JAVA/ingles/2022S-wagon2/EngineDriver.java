package es.uma.psc;

import java.util.*;

public class EngineDriver extends Thread {
	private final Train train;
	private final Random r = new Random();

	public EngineDriver(Train train) {
		this.train = train;
	}

	@Override
	public void run() {
		while (true) try {
			train.beginTrip();
			Thread.sleep(r.nextInt(1000));
			train.endTrip();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
