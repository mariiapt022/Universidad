package guarderiaLocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Guarderia {

	private int nBebes = 0;
	private int nAdultos = 0;
	private ReentrantLock l = new ReentrantLock();
	private Condition okBebe = l.newCondition();
	private Condition okAdulto = l.newCondition();
	
	/**
	 * Un bebe que quiere entrar en la guarderia llama a este metodo.
	 * Debe esperar hasta que sea seguro entrar, es decir, hasta que 
	 * cuado entre haya, al menos, 1 adulto por cada 3 bebes
	 * 
	 */
	public void entraBebe(int id) throws InterruptedException{
		
		l.lock();

		try{
			while(nBebes + 1 > 3 * nAdultos){
				okBebe.await();
			}
			nBebes ++;
			System.out.println("El bebe " + id + " entra en la guardería. Hay " + nBebes + " bebes en la guardería.");
		}finally{
			l.unlock();
		}

	}
	/**
	 * Un bebe que quiere irse de la guarderia llama a este metodo * 
	 */
	public void saleBebe(int id) throws InterruptedException{
		
		l.lock();

		try{
			nBebes --;
			System.out.println("El bebe " + id + " sale de la guardería. Hay " + nBebes + " bebes en la guardería.");
			if (nBebes <= 3 * (nAdultos - 1)) {
				okAdulto.signal();
			}
		}finally{
			l.unlock();
		}

	}
	/**
	 * Un adulto que quiere entrar en la guarderia llama a este metodo * 
	 */
	public void entraAdulto(int id) throws InterruptedException{
		
		l.lock();

		try{
			nAdultos ++;
			System.out.println("			El adulto " + id + " entra en la guardería. Hay " + nAdultos + " adultos en la guardería.");
			if (nBebes + 1 <= 3 * nAdultos) {
				okBebe.signal();
			}
		}finally{
			l.unlock();
		}

	}
	
	/**
	 * Un adulto que quiere irse  de la guarderia llama a este metodo.
	 * Debe esperar hasta que sea seguro salir, es decir, hasta que
	 * cuando se vaya haya, al menos, 1 adulto por cada 3 bebes
	 * 
	 */
	public void saleAdulto(int id) throws InterruptedException{
		
		l.lock();

		try{
			while(nBebes > 3 * (nAdultos - 1)){
				okAdulto.await();
			}
			nAdultos --;
			System.out.println("			El adulto " + id + " sale de la guardería. Hay " + nAdultos + " adultos en la guardería.");
		}finally{
			l.unlock();
		}

	}

}
