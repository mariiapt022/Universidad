package uma.es;

public class Driver {

	public static void main(String[] args) {
		ContestMonitor c = new ContestMonitor();
		Bricklayer b0 = new Bricklayer(0, c);
		Bricklayer b1 = new Bricklayer(1, c);
		b0.start();
		b1.start();
	}

}
