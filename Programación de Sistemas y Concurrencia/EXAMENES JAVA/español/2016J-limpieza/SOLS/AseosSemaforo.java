package Junio2016Semaforo;

import java.util.concurrent.Semaphore;

public class Aseos {
	
	private int Naseos = 0;
	private Semaphore mutex = new Semaphore(1,true);//naseos
	private Semaphore mutex1 = new Semaphore(1,true);//clientes
	private Semaphore dentro = new Semaphore(1,true);//limpieza
	private Semaphore limpieza = new Semaphore(1,true);//alterno

	public void entroAseo(int id) throws InterruptedException {
		mutex1.acquire();
		limpieza.release();//si el equipo esta esperando se bloquean los clientes
		mutex.acquire();
		Naseos ++;
		if(Naseos == 1) dentro.acquire();
		System.out.println("Entra cliente " + id + " aseos ocupados " + Naseos);
		mutex.release();
		limpieza.release();
		mutex1.release();
	}

	public void salgoAseo(int id) throws InterruptedException {
		mutex.acquire();
		Naseos --;
		if(Naseos == 0) dentro.release();
		System.out.println("Sale cliente " + id + " aseos ocupados " + Naseos);
		mutex.release();
	}

	public void entraEquipoLimpieza() throws InterruptedException {
		System.out.println("Entra el equipo de limpieza");
		limpieza.acquire();
		dentro.acquire();
		System.out.println("Entra equipo de limpieza. Total clientes:" +Naseos);
	}

	public void saleEquipoLimpieza() {
		System.out.println("Sale equipo de limpieza. Total clientes:" +Naseos);
		limpieza.release();
		dentro.release();
	}

	public int getNaseos() {
		return Naseos;
	}

}
