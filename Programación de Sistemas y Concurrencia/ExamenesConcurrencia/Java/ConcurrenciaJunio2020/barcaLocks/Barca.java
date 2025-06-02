import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Barca {

	private ReentrantLock l = new ReentrantLock();
	private Condition esperaBarca = l.newCondition();
	private Condition okSubir = l.newCondition();
	private Condition okBajar = l.newCondition();
	private Condition okBarca = l.newCondition();
	private int orilla = 1;
	private int nPasajeros = 0;
	private boolean finViaje = false;
	private boolean bajando = false;

	

	/*
	 * El Pasajero id quiere darse una vuelta en la barca desde la orilla pos
	 */
	public  void subir(int id,int pos) throws InterruptedException{
		
		l.lock();

		try{

			while(orilla != pos){
				esperaBarca.await();
			}

			while(nPasajeros == 3 || bajando){
				okSubir.await();
			}

			nPasajeros ++;
			System.out.println("Viajero " + id + " se sube al barco en la orilla " + orilla + ".");
			if (nPasajeros == 3) {
				okBarca.signal();
				finViaje = false;
			}

		}finally{
			l.unlock();
		}

	}
	
	/*
	 * Cuando el viaje ha terminado, el Pasajero que esta en la barca se baja
	 */
	public  int bajar(int id) throws InterruptedException{
		
		l.lock();

		try{

			while(nPasajeros == 0 || !finViaje){
				okBajar.await();
			}

			nPasajeros --;
			System.out.println("Viajero " + id + " se baja del barco.");

			if (nPasajeros == 0) {
				System.out.println("Barca vacía...pueden subir nuevos pasajeros.");
				bajando = false;
				okSubir.signalAll();
			}

		}finally{
			l.unlock();
		}

		return orilla;

	}
	/*
	 * El Capitan espera hasta que se suben 3 pasajeros para comenzar el viaje
	 */
	public  void esperoSuban() throws InterruptedException{
		
		l.lock();

		try{

			while(nPasajeros < 3 || bajando){
				okBarca.await();
			}

			System.out.println("Empieza el viaje!!!!");

		}finally{
			l.unlock();
		}

	}
	/*
	 * El Capitan indica a los pasajeros que el viaje ha terminado y tienen que bajarse
	 */
	public  void finViaje() throws InterruptedException{
		
		l.lock();

		try{

			System.out.println("Fin del viaje!!!!");
			orilla = (orilla+1)%2; 
			finViaje = true;
			bajando = true;
			okBajar.signalAll();
			esperaBarca.signalAll();
		}finally{
			l.unlock();
		}

	}

}
