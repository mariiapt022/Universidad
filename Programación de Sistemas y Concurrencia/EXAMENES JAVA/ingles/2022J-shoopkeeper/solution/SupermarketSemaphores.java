package es.uma.galvez;

import java.util.concurrent.Semaphore;

public class SupermarketSemaphores implements Supermarket {

	private Semaphore mutex = new Semaphore(1, true);
	private GenSem permanentSemaphore = new GenSem(0);
	private GenSem clientWaitsSemaphore = new GenSem(0);
	private boolean waiting = false;
	private boolean aClientForPermanent = false;
	
	protected int numClients = 0;
	protected int totalClients = 0;
	protected int totalServed = 0;

	protected ShopKeeper permanentShopKeeper;
	public SupermarketSemaphores() throws InterruptedException {
		permanentShopKeeper = new ShopKeeper(this, true);
		System.out.println("Created Permanent shopkeeper with id: "+permanentShopKeeper.id);
		permanentShopKeeper.start();
	}

	@Override
	public void close() throws InterruptedException {
		mutex.acquire();
		System.out.println("Closing the supermarket. Only serving already created customers.");
		permanentSemaphore.release();
		mutex.release();
	}

	@Override
	public void arrivesCustomer(int id) throws InterruptedException {
		mutex.acquire();
		totalClients++;
		System.out.println("New client with id "+id+" arrives. Total customers: "+totalClients+". Current waiting: "+(numClients+1)+".");
		if (waiting) {
			waiting = false;
			aClientForPermanent = true;
			permanentSemaphore.release();
			// numClients is not incremented to guarantee that the customer will be served by the Permanent
		} else if (numClients >= ShopKeeper.getNumShopKeepers()*3) {
			ShopKeeper sk = new ShopKeeper(this, false);
			System.out.println("Creating new shopkeeper with id: "+sk.id);
			sk.start();
			numClients++;
		} else {
			numClients++;
		}
		mutex.release();
		clientWaitsSemaphore.acquire();
	}

	@Override
	public boolean takeAnother(boolean permanent, int id) throws InterruptedException {
		boolean somebodyIsServed;
		mutex.acquire();
		if (permanent) {
			somebodyIsServed = takeAnotherPermanent(id);
		} else {
			somebodyIsServed = takeAnotherOccasional(id);
		}
		if (somebodyIsServed) {
			numClients--;
			clientWaitsSemaphore.release();
		}
		mutex.release();
		return somebodyIsServed;
	}
	
	private boolean takeAnotherPermanent(int id) throws InterruptedException {
		if (numClients == 0) {
			waiting = true;
			System.out.println("Permanent waits");
			mutex.release();
			permanentSemaphore.acquire();
			mutex.acquire();
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
	
	
	private static class GenSem {
		private final Semaphore mutex = new Semaphore(1, true);
		private final Semaphore intSem;
		private int numPermissions;
		public GenSem(int permissions) {
			numPermissions = permissions;
			intSem = new Semaphore((numPermissions==0)?0:1, true);
		}
		public void acquire() throws InterruptedException {
			intSem.acquire();
			mutex.acquire();
			numPermissions--;
			if (numPermissions > 0) intSem.release();
			mutex.release();
		}
		public void release() throws InterruptedException {
			mutex.acquire();
			numPermissions++;
			if (numPermissions == 1) intSem.release();
			mutex.release();
		}
	}

}
