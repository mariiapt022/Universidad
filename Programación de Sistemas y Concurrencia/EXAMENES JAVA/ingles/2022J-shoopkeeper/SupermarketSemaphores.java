package es.uma.galvez.skeleton;

import java.util.concurrent.Semaphore;

public class SupermarketSemaphores implements Supermarket {

	/*
	 * Declare here the variables that you need
	 */

	protected ShopKeeper permanentShopKeeper;
	public SupermarketSemaphores() throws InterruptedException {
		permanentShopKeeper = new ShopKeeper(this, true);
		System.out.println("Created Permanent shopkeeper with id: "+permanentShopKeeper.id);
		permanentShopKeeper.start();
	}

	@Override
	public void close() throws InterruptedException {
		// Write your code here
		
	}

	@Override
	public void arrivesCustomer(int id) throws InterruptedException {
		// Write your code here
		
	}

	@Override
	public boolean takeAnother(boolean permanent, int id) throws InterruptedException {
		/*
		 * You may modify this function at your convenience
		 */
		boolean somebodyIsServed;
		if (permanent) {
			somebodyIsServed = takeAnotherPermanent(id);
		} else {
			somebodyIsServed = takeAnotherOccasional(id);
		}
		return somebodyIsServed;
	}
	
	private boolean takeAnotherPermanent(int id) throws InterruptedException {
		// Write your code here
		return false;
	}

	private boolean takeAnotherOccasional(int id) throws InterruptedException {
		// Write your code here
		return false;
	}

}
