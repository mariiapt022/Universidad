package es.uma.psc;

public class Driver {
	public static void main(String[] args) {
		Train train = // new TrainSyncOrLocks(); or new TrainSemaphores();
		EngineDriver ed = new EngineDriver(train);
		Passenger[] pas = new Passenger[20];
		for (int i=0; i<pas.length; i++)
			pas[i] = new Passenger(train,i);
		ed.start();
		for (int i=0; i<pas.length; i++)
			pas[i].start();
	}
}
