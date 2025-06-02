package Junio2019Semaforo;

import java.util.concurrent.Semaphore;

public class Tiovivo {
	
	private int plazas;
	private int pasajeros = 0;
	
	private Semaphore mutex = new Semaphore(1,true);
	private Semaphore subir = new Semaphore(1,true);
	private Semaphore bajar = new Semaphore(0,true);
	private Semaphore arrancar = new Semaphore(0,true);
	
	public Tiovivo(int n){
		this.plazas = n;
	}
		
	
	public void subir(int id) throws InterruptedException {	
		subir.acquire();
		mutex.acquire();
		
		pasajeros++;
		
		System.out.println("El pasajero " + id+" ha subido al tiovivo");
		
		if(pasajeros<plazas) {
			subir.release();
		}else {
			arrancar.release();
		}
		mutex.release();
	}
	
	public void bajar(int id) throws InterruptedException {
		bajar.acquire();
		mutex.acquire();
		
		pasajeros--;
		System.out.println("El pasajero " + id+" ha bajado del tiovivo");
		
		if(pasajeros == 0) {
			subir.release();
			System.out.println("Ya podeis subir");
		}else {
			bajar.release();
		}
		
		mutex.release();
		
	}
	
	public void esperaLleno () throws InterruptedException {
			arrancar.acquire();
			System.out.println("esperando");
	}
	
	public void finViaje () {
		bajar.release();
		System.out.println("El viaje ha terminado");
	}
}
