package uma.es;

import java.util.Random;

public class Contest {

	public Random rnd =  new Random();
	private static final int WALL_LENGTH = 10;
	private static final int THRESHOLD_WINNER = 3;
	
			// Fill here

	public void putBrick(int id) throws InterruptedException {
			// Fill here
	}


	public void readySteadyGo(int id) throws InterruptedException {
		// Handshake
			// Fill here
		
		//
			// Fill here
	}
	
	private static int opposite(int id) { return (id + 1) % 2; }

	public boolean isSetFinished() throws InterruptedException {
			// Fill here
	}
	
	public boolean isContestFinished() throws InterruptedException {
			// Fill here
	}
}
