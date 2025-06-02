package es.uma.galvez;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		Supermarket mkt = new SupermarketSynchronized();
		int id = 1;
		// We simulate a non-uniform distribution of customers
		for (int usr: new int[] {1, 2, 4, 5, 5, 4, 3, 2, 2, 1, 1, 5, 5, 4}) {
			for (int i=0; i<usr; i++) try {
					Thread.sleep(1000/usr);
					new Customer(mkt, id++).start();
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
		mkt.close();
	}

}
