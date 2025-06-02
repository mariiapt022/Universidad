package uma.es;

public class Bricklayer extends Thread {
	private ContestMonitor c;
	private int id;
	public Bricklayer(int i, ContestMonitor c) {
		this.id = i;
		this.c = c;
	}

	@Override
	public void run() {
		try {
			// Fill here
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

}
