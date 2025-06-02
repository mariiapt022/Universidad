package midterm2020.galvez.uma.es;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Bus {
	private Random r = new Random();
	private int numCritical = Driver.NUM_CRITICAL;
	private int numMinor = Driver.NUM_MINOR;
	// Semaphores
	private Semaphore criticalSem = new Semaphore(0, true);
	private Semaphore minorSem = new Semaphore(0, true);
	private Semaphore restSem = new Semaphore(0, true);
	private Semaphore ambulanceSem = new Semaphore(0, true);

	public void waitDisinfection() {
		try {
			sleep(r.nextInt(2000));
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public void onBoardAmbulance(PassengerType type, int id) throws InterruptedException {
		if (type == PassengerType.CRITICAL)
			criticalSem.acquire();
		else if (type == PassengerType.MINOR)
			minorSem.acquire();
		else 
			restSem.acquire();
		System.out.println("Passenger "+id+"("+type.name()+") boards on");
		ambulanceSem.release();
	}

	public void performTrip(int cap) throws InterruptedException {
		System.out.println("Ambulance arrives");
		for(; cap>0; cap--) {
			if (numCritical > 0) {
				criticalSem.release();
				ambulanceSem.acquire();
				numCritical--;
			} else if (numMinor > 0) {
				minorSem.release();
				ambulanceSem.acquire();
				numMinor--;
			} else {
				restSem.release();
				ambulanceSem.acquire();
			}
		}
		System.out.println("Ambulance exits");
	}
}
