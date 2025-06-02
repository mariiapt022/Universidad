package semaphores;

import static java.lang.Thread.sleep;
import java.util.Random;

public class Bus {
	private Random r = new Random();
	private int capacity;
	private int numCritical = Driver.NUM_CRITICAL;
	private int numMinor = Driver.NUM_MINOR;

	public void waitDisinfection() {
		try {
			sleep(r.nextInt(2000));
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public void onBoardAmbulance(PassengerType type) {
		
	}

	public void performTrip(int cap) {
		
	}
}
