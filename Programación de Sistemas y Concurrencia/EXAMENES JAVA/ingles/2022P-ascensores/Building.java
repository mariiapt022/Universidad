package es.uma.psc.midterm2022;

public interface Building {

	int boardOnLift(int id) throws InterruptedException;

	void boardOffLift(int id, int liftId) throws InterruptedException;

	void showUsage();

}
