package es.uma.galvez;

public interface Supermarket {

	void close() throws InterruptedException;

	void arrivesCustomer(int id) throws InterruptedException;
		
	boolean takeAnother(boolean permanent, int id) throws InterruptedException;

}
