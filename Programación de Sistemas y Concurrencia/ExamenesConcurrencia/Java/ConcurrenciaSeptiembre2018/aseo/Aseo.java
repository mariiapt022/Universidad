package aseo;

import java.util.concurrent.Semaphore;

public class Aseo {

	private int nHombres = 0;
	private int nMujeres = 0;
	private Semaphore mutex1 = new Semaphore(1, true);
	private Semaphore mutex2 = new Semaphore(1, true);
	private Semaphore turno = new Semaphore(1, true);

	
	/**
	 * El hombre id quiere entrar en el aseo. 
	 * Espera si no es posible, es decir, si hay alguna mujer en ese
	 * momento en el aseo
	 */
	public void llegaHombre(int id) throws InterruptedException{

		System.out.println("El hombre " + id + " quiere entrar al aseo.");

		mutex1.acquire();

		nHombres ++;
		if (nHombres == 1) {
			turno.acquire();
		}
		System.out.println("El hombre " + id + " entra al aseo. Hay " + nHombres + " hombres.");

		mutex1.release();

	}
	/**
	 * La mujer id quiere entrar en el aseo. 
	 * Espera si no es posible, es decir, si hay algun hombre en ese
	 * momento en el aseo
	 */
	public void llegaMujer(int id) throws InterruptedException{

		System.out.println("La mujer " + id + " quiere entrar al aseo.");

		mutex2.acquire();

		nMujeres ++;
		if (nMujeres == 1) {
			turno.acquire();
		}
		System.out.println("La mujer " + id + " entra al aseo. Hay " + nMujeres + " mujeres.");
		
		mutex2.release();

	}
	/**
	 * El hombre id, que estaba en el aseo, sale
	 */
	public void saleHombre(int id)throws InterruptedException{

		mutex1.acquire();

		nHombres --;
		System.out.println("El hombre " + id + " sale del aseo. Hay " + nHombres + " hombres.");
		if (nHombres == 0) {
			turno.release();
		}

		mutex1.release();
		
	}
	
	public void saleMujer(int id)throws InterruptedException{

		mutex2.acquire();
		
		nMujeres --;
		System.out.println("La mujer " + id + " sale del aseo. Hay " + nMujeres + " mujeres.");
		if (nMujeres == 0) {
			turno.release();
		}

		mutex2.release();

	}
}
