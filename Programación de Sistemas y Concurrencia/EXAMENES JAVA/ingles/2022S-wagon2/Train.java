package es.uma.psc;

public interface Train {
	public static final int SIZE_LIMIT = 5;
	
	public void trip(int id) throws InterruptedException;
	public void beginTrip() throws InterruptedException;
	public void endTrip() throws InterruptedException;

}
