package Septiembre2016;

import java.util.concurrent.*;
public class Mesa {
	
	private int N,numeroJugadores,nCara,nCruz,ganador;
	private boolean[] jugadas ;
	
	private Semaphore mutex = new Semaphore(1,true);
	private Semaphore jugador = new Semaphore(0,true);
	private Semaphore nuevapartida = new Semaphore(1,true);
	
	public Mesa(int N){
		this.N = N;
		this.numeroJugadores = 0;
		jugadas = new boolean[N];
	}
	
	public int nuevaJugada(int id,boolean cara) throws InterruptedException{
		nuevapartida.acquire();
		mutex.acquire();
		
		if(cara) {
			nCara++;
			System.out.println("El resultado del jugador "+id+ " es cara");
		}else {
			nCruz++;
			System.out.println("El resultado del jugador "+id+ " es cruz");
		}
		
		jugadas[id] = cara;
		numeroJugadores++;
		
		if(numeroJugadores < N ) {
			mutex.release();
			nuevapartida.release();
			jugador.acquire();
			mutex.acquire();
		}else{
			if(nCara == 1 ) {
			ganador = buscarGanador(true);
			System.out.println("Ha ganado el jugador "+id+ " con cara");
		}else if (nCruz == 1){
			ganador = buscarGanador(false);
			System.out.println("Ha ganado el jugador "+id+ " con cruz");
		}else {
			ganador = N;
			System.out.println("No ha ganado nadie");
		}
		
		nCara = 0;
		nCruz = 0;
		}
		numeroJugadores--;
		if(numeroJugadores > 0) {
			jugador.release();
			mutex.release();
			
		}else {
			nuevapartida.release();
			mutex.release();
		}
		
		return ganador;

	}

	private int buscarGanador(boolean cara) {
		int ganador = N;
		int i = 0;
		while(i<N && jugadas[i] != cara) {
			i++;
		}
		
		if(i<N) {
			ganador = i;
		}
		return ganador;
	}
}
