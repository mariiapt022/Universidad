package guarderiaSemaforos;

import java.util.concurrent.Semaphore;


public class Guarderia {
	
	private int nBebes = 0;
	private int nAdultos = 0;
	private Semaphore mutex = new Semaphore(1, true);
	private Semaphore entrarBebes = new Semaphore(0,true);
	private Semaphore salirAdultos = new Semaphore(0,true);

	/**
	 * Un bebe que quiere entrar en la guarderia llama a este metodo.
	 * Debe esperar hasta que sea seguro entrar, es decir, hasta que 
	 * cuado entre haya, al menos, 1 adulto por cada 3 bebes
	 * 
	 */
	public void entraBebe(int id) throws InterruptedException{

		mutex.acquire();

		if (nBebes + 1 <= 3 * nAdultos) {
			entrarBebes.release();
		}

		mutex.release();
		
		entrarBebes.acquire();

		mutex.acquire();
		
		nBebes ++;
		System.out.println("El bebe " + id + " entra en la guardería. Hay " + nBebes + " bebes en la guardería.");

		mutex.release();

	}
	/**
	 * Un bebe que quiere irse de la guarderia llama a este metodo * 
	 */
	public void saleBebe(int id) throws InterruptedException{
		
		mutex.acquire();

		nBebes --;
		System.out.println("El bebe " + id + " sale de la guardería. Hay " + nBebes + " bebes en la guardería.");

		mutex.release();

	}
	/**
	 * Un adulto que quiere entrar en la guarderia llama a este metodo * 
	 */
	public void entraAdulto(int id) throws InterruptedException{
		
		mutex.acquire();

		nAdultos ++;
		System.out.println("			El adulto " + id + " entra en la guardería. Hay " + nAdultos + " adultos en la guardería.");

		mutex.release();
		
	}
	
	/**
	 * Un adulto que quiere irse  de la guarderia llama a este metodo.
	 * Debe esperar hasta que sea seguro salir, es decir, hasta que
	 * cuando se vaya haya, al menos, 1 adulto por cada 3 bebes
	 * 
	 */
	public void saleAdulto(int id) throws InterruptedException{
		
		mutex.acquire();

		if (nBebes <= 3 * (nAdultos - 1)) {
			salirAdultos.release();
		}

		mutex.release();

		salirAdultos.acquire();
		
		mutex.acquire();
		
		nAdultos --;
		System.out.println("			El adulto " + id + " sale de la guardería. Hay " + nAdultos + " adultos en la guardería.");
		
		mutex.release();
		
	}

}
