package parada;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Parada {
	
	private boolean hayBus = false;
	private boolean bajando = false;
	private int nPasajeros = 0;
	private int grupo = 0;
	private ReentrantLock l = new ReentrantLock();
	private Condition esperarSigBus = l.newCondition();
	private Condition okSubir = l.newCondition();
	private Condition irBus = l.newCondition();
	private Condition okBajar = l.newCondition();
	private Condition okBus = l.newCondition();
	private List<Integer> grupoPrin = new LinkedList<>();
	private List<Integer> grupoSec = new LinkedList<>();


	
	
	public Parada(){
		
	}
	/**
	 * El pasajero id llama a este metodo cuando llega a la parada.
	 * Siempre tiene que esperar el siguiente autobus en uno de los
	 * dos grupos de personas que hay en la parada
	 * El metodo devuelve el grupo en el que esta esperando el pasajero
	 * 
	 */
	public int esperoBus(int id) throws InterruptedException{

		l.lock();

		try{
			if (!hayBus) {
				grupo = 1;
				grupoPrin.add(id);
			}else{
				grupo = 2;
				grupoSec.add(id);
			}
	
			System.out.println("El pasajero " + id + " espera el siguiente autobús.");
		}finally{
			l.unlock();
		}
		
		return grupo; //comentar esta línea
	}
	/**
	 * Una vez que ha llegado el autobús, el pasajero id que estaba
	 * esperando en el grupo i se sube al autobus
	 * @throws InterruptedException
	 *
	 */
	public void subeAutobus(int id,int i) throws InterruptedException{

		l.lock();

		try{

			while(!grupoPrin.contains(id)) {
				esperarSigBus.await();
			}

			while(!hayBus){
				okSubir.await();
			}

			nPasajeros ++;
			grupoPrin.remove(grupoPrin.indexOf(id));
			System.out.println("El pasajero " + id + " se sube al autobús. Hay " + nPasajeros + " pasajeros.");
			if (grupoPrin.size() == 0) {
				irBus.signal();
			}
			
			while(hayBus){
				okBajar.await();
			}

			bajando = true;
			nPasajeros --;

			if (nPasajeros == 0) {
				bajando = false;
				okBus.signal();
			}

		}finally{
			l.unlock();
		}
	}
	/**
	 * El autobus llama a este metodo cuando llega a la parada
	 * Espera a que se suban todos los viajeros que han llegado antes
	 * que el, y se va
	 * 
	 */
	public void llegoParada() throws InterruptedException{

		l.lock();

		try{

			while(bajando){
				okBus.await();
			}

			System.out.println("Llega el autobús.");
			hayBus = true;
			okSubir.signalAll();

			while(grupoPrin.size() > 0){
				irBus.await();
			}

			System.out.println("Ya se han montado todos. El autobús se va. Hay " + nPasajeros + " pasajeros.");
			hayBus = false;
			grupoPrin = grupoSec;
			grupoSec.clear();
			esperarSigBus.signalAll();
			okBajar.signalAll();

		}finally{
			l.unlock();
		}
	}
}
