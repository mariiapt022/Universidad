package es.uma.galvez.midterm2019;

public class Bricklayer extends Thread {
	private Contest c;
	private int id;
	public Bricklayer(int i, Contest c) {
		this.id = i;
		this.c = c;
	}

	@Override
	public void run() {
		try {
			do {
				c.readySteadyGo(id);
				while (! c.isSetFinished()) {
					Thread.sleep(c.rnd.nextInt(90)+10);
					c.putBrick(id);
				}
			} while (! c.isContestFinished());
		} catch (InterruptedException e) { e.printStackTrace(); }
	}

}
