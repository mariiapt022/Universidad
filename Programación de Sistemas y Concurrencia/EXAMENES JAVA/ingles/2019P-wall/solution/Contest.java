package es.uma.galvez.midterm2019;

import java.util.Random;

public abstract class Contest {

	protected Random rnd =  new Random();
	protected static final int WALL_LENGTH = 10;
	protected static final int THRESHOLD_WINNER = 3;
	
	public abstract void putBrick(int id) throws InterruptedException;

	public abstract void readySteadyGo(int id) throws InterruptedException;
	
	protected static int opposite(int id) { return (id + 1) % 2; }

	public abstract boolean isSetFinished() throws InterruptedException;
	
	public abstract boolean isContestFinished() throws InterruptedException;
}
