package es.uma.galvez;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ShopKeeper extends Thread {
	private static Random rnd = new Random();
	private static AtomicBoolean anyCreated = new AtomicBoolean(false);
	private static AtomicInteger numShopKeepers = new AtomicInteger(0);
	private static AtomicInteger currentId = new AtomicInteger(0);
	private boolean iAmPermanent;
	private Supermarket mkt;
	public final int id;

	public ShopKeeper(Supermarket mkt, boolean permanent) throws InterruptedException {
		if (anyCreated.get() && permanent)
			throw new RuntimeException("Only the first ShopKeeper must be permanent");
		if (!anyCreated.get() && !permanent)
			throw new RuntimeException("The first ShopKeeper must be permanent");
		anyCreated.set(true);
		iAmPermanent = permanent;
		this.mkt = mkt;
		this.id = currentId.getAndAdd(1);
		numShopKeepers.addAndGet(1);
	}

    @Override
	public void run() {
		try {
			while (mkt.takeAnother(iAmPermanent, id)) {
				sleep(500+rnd.nextInt(400));
			}
		} catch (InterruptedException e) { e.printStackTrace(); }
		System.out.println("Shopkeeper "+id+" gets out.");
		numShopKeepers.addAndGet(-1);
    }

	public static synchronized int getNumShopKeepers() {
		return numShopKeepers.get();
	}

}
