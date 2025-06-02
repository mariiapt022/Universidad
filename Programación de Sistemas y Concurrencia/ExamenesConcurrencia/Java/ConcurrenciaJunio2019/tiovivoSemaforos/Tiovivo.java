import java.util.concurrent.Semaphore;

public class Tiovivo {
		
	private int N;
	private int nPasajeros = 0;
	private Semaphore mutex = new Semaphore(1,true);
	private Semaphore finViaje = new Semaphore(1,true);
	private Semaphore lleno = new Semaphore(0, true);
	private Semaphore puedoBajar = new Semaphore(0, true);

	public Tiovivo(int n){
		N = n;
	}
	
	public void subir(int id) throws InterruptedException 
	{	
		
		System.out.println("El pasajero " + id + " quiere subir al tiovivo.");

		finViaje.acquire();
		mutex.acquire();

		nPasajeros ++;
		System.out.println("El pasajero " + id + " se sube al tiovivo. Hay " + nPasajeros + " pasajeros.");
		if (nPasajeros < N) {
			finViaje.release();
		}else{
			lleno.release();
		}

		mutex.release();

	}
	
	public void bajar(int id) throws InterruptedException 
	{
		puedoBajar.acquire();
		mutex.acquire();

		nPasajeros --;
		System.out.println("El pasajero " + id + " baja del tiovivo. Hay " + nPasajeros + " pasajeros.");
		if (nPasajeros > 0) {
			puedoBajar.release();
		}else{
			finViaje.release();
		}

		mutex.release();
	}
	
	public void esperaLleno () throws InterruptedException 
	{
		lleno.acquire();
		System.out.println("El tiovivo ya está lleno. Se pone en marcha.");

	}
	
	public void finViaje () 
	{

		System.out.println("El tiovivo ha parado. Ya se pueden bajar los pasajeros.");
		puedoBajar.release();

	}
}
