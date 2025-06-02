package es.uma.galvez;

public class SupermarketSynchronized implements Supermarket {
	private boolean waiting = false;
	private boolean stop = false;
	private boolean aClientForPermanent = false;
	private int numServicing = 0;
	
	protected int numClients = 0;
	protected int totalClients = 0;
	protected int totalServed = 0;

	protected ShopKeeper permanentShopKeeper;
	public SupermarketSynchronized() throws InterruptedException {
		permanentShopKeeper = new ShopKeeper(this, true);
		System.out.println("Created Permanent shopkeeper with id: "+permanentShopKeeper.id);
		permanentShopKeeper.start();
	}

	@Override
	public synchronized void close() throws InterruptedException {
		System.out.println("Closing the supermarket. Only serving already created customers.");
		stop = true;
		notifyAll();
	}

	@Override
	public synchronized void arrivesCustomer(int id) throws InterruptedException {
		totalClients++;
		System.out.println("New client with id "+id+" arrives. Total customers: "+totalClients+". Current waiting: "+(numClients+1)+".");
		if (waiting) {
			waiting = false;
			aClientForPermanent = true;
			notifyAll();
			// numClients is not incremented to guarantee that the customer will be served by the Permanent
		} else if (numClients >= ShopKeeper.getNumShopKeepers()*3) {
			ShopKeeper sk = new ShopKeeper(this, false);
			System.out.println("Creating new shopkeeper with id: "+sk.id);
			sk.start();
			numClients++;
		} else {
			numClients++;
		}
		while (numServicing <= 0)
			wait();
		numServicing--;
	}

	@Override
	public synchronized boolean takeAnother(boolean permanent, int id) throws InterruptedException {
		boolean somebodyIsServed;
		if (permanent) {
			somebodyIsServed = takeAnotherPermanent(id);
		} else {
			somebodyIsServed = takeAnotherOccasional(id);
		}
		if (somebodyIsServed) {
			numClients--;
			numServicing++;
			notifyAll();
		}
		return somebodyIsServed;
	}
	
	private boolean takeAnotherPermanent(int id) throws InterruptedException {
		if (numClients == 0) {
			waiting = true;
			System.out.println("Permanent waits");
			while (waiting && !stop) 
				wait();
			if (! aClientForPermanent) {
				return false;
			} else {
				numClients++;
				aClientForPermanent = false;
				System.out.println("Permanent starts serving a customer. Total customers served: "+(++totalServed));
				return true;
			}
		} else {
			System.out.println("Permanent starts serving a customer. Total customers served: "+(++totalServed));
			return true;
		}
	}

	private boolean takeAnotherOccasional(int id) throws InterruptedException {
		if (numClients == 0) {
			return false;
		} else {
			System.out.println("Shopkeeper "+id+" starts serving a customer. Total customers served: "+(++totalServed));
			return true;
		}
	}
	
}
