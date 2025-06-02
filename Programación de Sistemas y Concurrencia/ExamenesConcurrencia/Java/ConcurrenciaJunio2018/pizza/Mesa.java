package pizza;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
	
	private int nRaciones = 8;
	private boolean pagando = false;
	private boolean esperando = false;
	private boolean prepPizza = false;
	private boolean estaPizzero = false;
	private boolean llamaPizzero = false;
	private ReentrantLock l = new ReentrantLock();
	private Condition okPizza = l.newCondition();
	private Condition okPagar = l.newCondition();
	private Condition irsePizzero = l.newCondition();
	private Condition hacerPizza = l.newCondition();

	
	/**
	 * 
	 * @param id
	 * El estudiante id quiere una ración de pizza. 
	 * Si hay una ración la coge y sigue estudiante.
	 * Si no hay y es el primero que se da cuenta de que la mesa está vacía
	 * llama al pizzero y
	 * espera hasta que traiga una nueva pizza. Cuando el pizzero trae la pizza
	 * espera hasta que el estudiante que le ha llamado le pague.
	 * Si no hay pizza y no es el primer que se da cuenta de que la mesa está vacía
	 * espera hasta que haya un trozo para él.
	 * @throws InterruptedException 
	 * 
	 */
	public void nuevaRacion(int id) throws InterruptedException{

		l.lock();

		try{
			
			System.out.println("El estudiante " + id + " quiere un trozo de pizza. Hay " + nRaciones + " raciones.");

			while(esperando){
				okPizza.await();
			}

			if (nRaciones == 0) {
				System.out.println("No queda pizza. El estudiante " + id + " llama al pizzero.");

				prepPizza = true;
				llamaPizzero = true;
				hacerPizza.signal();
				
				while(prepPizza){
					esperando = true;
					okPagar.await();
				}

				esperando = false;
				pagando = true;
				nRaciones = 8;
				System.out.println("El estudiante " + id + " paga al pizzero. Hay " + nRaciones + " raciones.");

				irsePizzero.signal();

				while(pagando){
					okPagar.await();
				}

			}
	
			nRaciones --;
			System.out.println("El estudiante " + id + " coge una ración de pizza. Hay " + nRaciones + " raciones.");

			esperando = false;
			okPizza.signalAll();
			
		}finally{
			l.unlock();
		}

	
	}


	/**
	 * El pizzero entrega la pizza y espera hasta que le paguen para irse
	 * @throws InterruptedException 
	 */
	public void nuevoCliente() throws InterruptedException{

		l.lock();

		try{
			System.out.println("El pizzero espera a que alguien le llame");

			while(!llamaPizzero){
				hacerPizza.await();
			}

			llamaPizzero = false;

			System.out.println("Alguien ha llamado al pizzero. El pizzero hace una pizza.");
		}finally{
			l.unlock();
		}


	}
	

/**
	 * El pizzero espera hasta que algún cliente le llama para hacer una pizza y
	 * llevársela a domicilio
	 * @throws InterruptedException 
	 */
	public void nuevaPizza() throws InterruptedException{

		l.lock();

		try{
			System.out.println("El pizzero ha llegado y está esperando a que le paguen.");

			prepPizza = false;
			okPagar.signal();

			while (!pagando) {
				irsePizzero.await();
			}
			
			System.out.println("El pizzero se va.");

			pagando = false;
			okPagar.signal();
		}finally{
			l.unlock();
		}

	}

}
