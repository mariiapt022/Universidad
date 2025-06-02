import java.util.concurrent.Semaphore;

public class Barca {

	private int orilla = 1;
	private Semaphore mutex = new Semaphore(1, true);
	private int nPasajeros = 0;
	private Semaphore haySitio = new Semaphore(1, true);
	private Semaphore lleno = new Semaphore(0, true);
	private Semaphore finViaje = new Semaphore(0, true);

	/*
	 * El Pasajero id quiere darse una vuelta en la barca desde la orilla pos
	 */
	public  void subir(int id,int pos) throws InterruptedException{

		haySitio.acquire();
		mutex.acquire();

		nPasajeros ++;
		System.out.println("Viajero " + id + " se sube al barco en la orilla " + orilla + ".");
		if (nPasajeros < 3) {
			haySitio.release();
		}else{
			lleno.release();
		}

		mutex.release();

	}
	
	/*
	 * Cuando el viaje ha terminado, el Pasajero que esta en la barca se baja
	 */
	public  int bajar(int id) throws InterruptedException{

		finViaje.acquire();
		mutex.acquire();

		nPasajeros --;
		System.out.println("Viajero " + id + " se baja del barco.");
		if (nPasajeros > 0) {
			finViaje.release();
		}else{
			System.out.println("Barca vacía...pueden subir nuevos pasajeros.");
			haySitio.release();
		}

		mutex.release();

		return orilla;
	}
	/*
	 * El Capitan espera hasta que se suben 3 pasajeros para comenzar el viaje
	 */
	public  void esperoSuban() throws InterruptedException{

		lleno.acquire();

		System.out.println("Empieza el viaje!!!!");
	}
	/*
	 * El Capitan indica a los pasajeros que el viaje ha terminado y tienen que bajarse
	 */
	public  void finViaje() throws InterruptedException{

		System.out.println("Fin del viaje!!!!");

		finViaje.release();
	}

}
