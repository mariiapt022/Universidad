package Septiembre2018Semaforo;

import java.util.concurrent.Semaphore;

public class Aseo {

	
	private int nmujeres = 0,nhombres = 0;
	private Semaphore mutex = new Semaphore(1,true);
	private Semaphore mujer = new Semaphore(1,true);
	private Semaphore hombre = new Semaphore(1,true);
	private Semaphore espera = new Semaphore(0,true);
	
	public void llegaHombre(int id) throws InterruptedException{
		hombre.acquire();
		mutex.acquire();
		
		while(nmujeres > 0) {
			mutex.release();
			espera.acquire();
			System.out.println("esta ocupado");
			mutex.acquire();
		}
		
		nhombres++;
		System.out.println("Entra el hombre " + id + " hay dentro " + nhombres);
		mutex.release();
	}
	
	
	public void llegaMujer(int id) throws InterruptedException{
		mujer.acquire();
		mutex.acquire();
		
		while(nhombres > 0) {
			mutex.release();
			espera.acquire();
			System.out.println("esta ocupado");
			mutex.acquire();
		}
		
		nmujeres++;
		System.out.println("Entra la mujer " + id + " hay dentro " + nmujeres);
		mutex.release();
	}
	
	public void saleHombre(int id)throws InterruptedException{
		mutex.acquire();
		nhombres--;
		System.out.println("Sale el hombre " + id + " hay dentro " + nmujeres);
		
		if(nhombres == 0) {
			mujer.release();
		}
		hombre.release();
		espera.release();
		mutex.release();
	}
	
	public void saleMujer(int id)throws InterruptedException{
		mutex.acquire();
		nmujeres--;
		System.out.println("Sale la mujer " + id + " hay dentro " + nmujeres);
		
		if(nmujeres == 0) {
			hombre.release();
		}
		mujer.release();
		espera.release();
		mutex.release();
	}
}
