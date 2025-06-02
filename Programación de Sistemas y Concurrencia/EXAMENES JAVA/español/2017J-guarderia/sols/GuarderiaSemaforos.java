package Junio2017Semaforos;

import java.util.concurrent.Semaphore;

public class Guarderia {
	
	private int nBebes, nAdultos;
	
	private int entrabebe = 0;
	private int salebebe = 0;
	private int saleadulto = 0;
	
	private Semaphore mutex = new Semaphore(1,true);
	private Semaphore bebe = new Semaphore(1,true);
	private Semaphore adulto = new Semaphore(1,true);
	
	private Semaphore esperabebe = new Semaphore(0,true);
	private Semaphore esperaadulto = new Semaphore(0,true);
	
	 
	public void entraBebe(int id) throws InterruptedException{
		System.out.println("El bebe " + id +" espera para entrar");
		
		bebe.acquire();
		mutex.acquire();
		
		if((nBebes + 1) < 3*nAdultos ) {
			entrabebe++;
			bebe.release();
			mutex.release();
			esperabebe.acquire();
			
			bebe.acquire();
			mutex.acquire();
		}
		
		nBebes++;
		System.out.println("El bebe " + id +" ha entrado. Hay en total "+ nBebes +" bebes y "+nAdultos+" adultos");
		mutex.release();
		bebe.release();
	}
	
	public void saleBebe(int id) throws InterruptedException{
			bebe.acquire();
			mutex.acquire();
			
			if((nBebes - 1) < 3*nAdultos ) {
				salebebe++;
				mutex.release();
				esperabebe.acquire();
				mutex.acquire();
			}
			nBebes--;
			System.out.println("El bebe " + id +" ha salido. Hay en total "+ nBebes +" bebes y "+nAdultos+" adultos");
			mutex.release();
			bebe.release();
	}
	
	public void entraAdulto(int id) throws InterruptedException{
		System.out.println("El adulto " + id +" espera para entrar");
		adulto.acquire();
		mutex.acquire();
		
		nAdultos++;
		System.out.println("El adulto " + id +" ha entrado. Hay en total "+ nBebes +" bebes y "+nAdultos+" adultos");
		
		if(entrabebe == 1 && (nBebes<= (3*nAdultos))) {
			esperabebe.release();
			entrabebe = 0;
		}else if(salebebe == 1) {
			esperabebe.release();
			salebebe = 0;
		}else if (saleadulto == 1){
			esperaadulto.release();
			saleadulto=0;
		}
		mutex.release();
		adulto.release();
		
	
	}
	
	public void saleAdulto(int id) throws InterruptedException{
		System.out.println("El adulto " + id +" espera para salir");
		adulto.acquire();
		mutex.acquire();
		
		if(nBebes <= 3*(nAdultos-1)) {
			saleadulto = 1;
			adulto.release();
			mutex.release();
			esperaadulto.acquire();
			adulto.release();
			mutex.acquire();
		}
		nAdultos--;
		System.out.println("El adulto " + id +" ha salido. Hay en total "+ nBebes +" bebes y "+nAdultos+" adultos");
		mutex.release();
		adulto.release();
		
	}

}
