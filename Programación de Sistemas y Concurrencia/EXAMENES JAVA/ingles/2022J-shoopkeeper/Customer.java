package es.uma.galvez.skeleton;

public class Customer extends Thread {
	private Supermarket mkt;
	private int id;
	public Customer(Supermarket mkt, int id) {
		this.mkt = mkt;
		this.id = id;
	}

    @Override
	public void run() {
		try {
			mkt.arrivesCustomer(id);
			System.out.println("A client with id "+id+" exits");
		} catch (InterruptedException e) { e.printStackTrace(); }
    }
}
