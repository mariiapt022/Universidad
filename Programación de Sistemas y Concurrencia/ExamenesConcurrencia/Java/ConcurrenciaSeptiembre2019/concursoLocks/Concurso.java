package esqueleto;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Concurso {

	private int tiros0 = 0;
	private int tiros1 = 0;
	private int gana0 = 0;
	private int gana1 = 0;
	private int juego = 0;
	private int caras[] = new int[2];
	private int ganadas[] = new int[2];
	private ReentrantLock l = new ReentrantLock();
	private Condition ok0 = l.newCondition();
	private Condition ok1 = l.newCondition();
	private Condition terminar = l.newCondition();
	private boolean finPartida = false;


	public void tirarMoneda(int id,boolean cara) throws InterruptedException {
		
		l.lock();

		try{

			if (id == 0) {
				while(tiros0 == 10){
					ok0.await();
				}
				tiros0 = 0;
			}else{
				while(tiros1 == 10){
					ok1.await();
				}
				tiros1 = 0;
			}

			if (id == 0) {
				tiros0 ++;
			}else{
				tiros1 ++;
			}

			if (cara) {
				System.out.println("El jugador " + id + " saca cara.");
				caras[id] ++;
			}else{
				System.out.println("El jugador " + id + " saca cruz.");	
			}
			
			if (tiros0 == 10 && tiros1 == 10) {
				juego ++;
				if (caras[id] > caras[1-id]) {
					System.out.println("Juego " + juego + ": Ha ganado la partida el jugador " + id + " con " + caras[id] + " caras.");
					ganadas[id] ++;
				}else if (caras[id] < caras[1-id]) {
					System.out.println("Juego " + juego + ": Ha ganado la partida el jugador " + (1-id) + " con " + caras[1-id] + " caras.");
					ganadas[1-id] ++;
				}else{
					System.out.println("Juego " + juego + ": El juego ha empatado");
				}

				if (ganadas[0] == 3 || ganadas[1] == 3) {
					finPartida = true;
					terminar.signal();
				}
				tiros0 = 0;
				tiros1 = 0;
				ok0.signalAll();
				ok1.signalAll();
			}

		}finally{
			l.unlock();
		}
	}	
	
	public boolean concursoTerminado() throws InterruptedException {

		l.lock();

		try{
			while (!finPartida) {
				terminar.await();
			}
			
			if (ganadas[0] == 3) {
				System.out.println("Final del concurso. Ha ganado el jugador 0");
			}else{
				System.out.println("Final del concurso. Ha ganado el jugador 1");
			}
			finPartida = false;
		}finally{
			l.unlock();
		}

		return false; //borrar
	}
}