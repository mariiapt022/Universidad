package es.uma.galvez.midterm2019;

import es.uma.galvez.midterm2019.solution.ContestMonitors;
import es.uma.galvez.midterm2019.solution.ContestSemaphores;

public class Driver {

	public static void main(String[] args) {
		Contest c = new ContestSemaphores();
		Bricklayer b0 = new Bricklayer(0, c);
		Bricklayer b1 = new Bricklayer(1, c);
		b0.start();
		b1.start();
	}

}
