package agua;


import java.util.concurrent.*;

public class GestorAgua {

	private int nHid = 0;
	private int nOxi = 0;
	private Semaphore mutex = new Semaphore(1, true);
	private Semaphore entraHid = new Semaphore(1, true);
	private Semaphore entraOxi = new Semaphore(1, true);
	private Semaphore formarAgua = new Semaphore(0, true);
	// private Semaphore formarAguaO = new Semaphore(0, true);
	
	
	public void hListo(int id) throws InterruptedException{

		entraHid.acquire();
		mutex.acquire();

		nHid ++;
		System.out.println("El átomo " + id + " de hidrógeno está esperando para formar una molécula de agua. Hay " + nHid + 
		" átomos de hidrógeno y " + nOxi + " átomos de oxígeno.");
		if (nHid < 2) {
			entraHid.release();
		}else if (nOxi == 1) {
			System.out.println("Ya hay " + nHid + " átomos de hidrógeno y " + nOxi + " de oxígeno. Se crea la molécula de agua.");
			formarAgua.release();
		}

		mutex.release();

		formarAgua.acquire();
		mutex.acquire();

		nHid --;

		if (nHid + nOxi == 0) {
			entraHid.release();
			entraOxi.release();
		}else{
			formarAgua.release();
		}

		mutex.release();
	}
	
	public void oListo(int id) throws InterruptedException{

		entraOxi.acquire();
		mutex.acquire();

		nOxi ++;
		System.out.println("El átomo " + id + " de oxígeno está esperando para formar una molécula de agua. Hay " + nHid + 
		" átomos de hidrógeno y " + nOxi + " átomos de oxígeno.");
		if (nHid == 2) {
			System.out.println("Ya hay " + nHid + " átomos de hidrógeno y " + nOxi + " de oxígeno. Se crea la molécula de agua.");
			formarAgua.release();
		}

		mutex.release();

		formarAgua.acquire();
		mutex.acquire();

		nOxi --;

		if (nHid + nOxi == 0) {
			entraHid.release();
			entraOxi.release();
		}else{
			formarAgua.release();
		}

		mutex.release();

	}
}