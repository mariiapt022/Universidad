import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Tiovivo {

	private int N;
	private int nPasajeros = 0;
	private boolean bajando = false;
	private boolean subiendo = false;
	private boolean finPaseo = true;
	private boolean enMarcha = false;
	private ReentrantLock l = new ReentrantLock();
	private Condition okSubir = l.newCondition();
	private Condition esperaLleno = l.newCondition();
	private Condition okBajar = l.newCondition();
	

	public Tiovivo(int n){
		N = n;
	}
		
	
	public void subir(int id) throws InterruptedException 
	{
		l.lock();

		try{

			System.out.println("El pasajero " + id + " quiere subir al tiovivo.");

			while(nPasajeros == N || !finPaseo){
				okSubir.await();
			}

			if (!subiendo) {
				subiendo = true;
			}
			nPasajeros ++;
			System.out.println("El pasajero " + id + " se sube al tiovivo. Hay " + nPasajeros + " pasajeros.");
			
			if (nPasajeros == N) {
				esperaLleno.signal();
			}
		
		}finally{
			l.unlock();
		}

	}
	
	public void bajar(int id) throws InterruptedException 
	{

		l.lock();

		try{

			while(nPasajeros == 0 || enMarcha || subiendo){
				okBajar.await();
			}

			nPasajeros --;
			System.out.println("El pasajero " + id + " baja del tiovivo. Hay " + nPasajeros + " pasajeros.");
			if (nPasajeros == 0) {
				bajando = false;
				finPaseo = true;
				okSubir.signalAll();
			}

		}finally{
			l.unlock();
		}

	}
	
	public void esperaLleno () throws InterruptedException 
	{

		l.lock();

		try{

			while(nPasajeros < N || bajando){
				esperaLleno.await();
			}
			
			System.out.println("El tiovivo ya está lleno. Se pone en marcha.");
			subiendo = false;
			enMarcha = true;
			finPaseo = false;
			

		}finally{
			l.unlock();
		}

	}
	
	public void finViaje () 
	{
		l.lock();

		try{

			System.out.println("El tiovivo ha parado. Ya se pueden bajar los pasajeros.");
			bajando = true;
			enMarcha = false;
			okBajar.signalAll();

		}finally{
			l.unlock();
		}
	}
}
