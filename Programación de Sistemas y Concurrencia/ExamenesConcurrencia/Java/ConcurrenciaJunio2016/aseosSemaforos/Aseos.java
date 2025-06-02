package aseosSemaforos;

import java.util.concurrent.Semaphore;

public class Aseos {
	
// 	private int nClientes = 0;
// 	private Semaphore mutex = new Semaphore(1, true);
// 	private Semaphore limpiando = new Semaphore(1, true);
	
// 	/**
// 	 * Utilizado por el cliente id cuando quiere entrar en los aseos
// 	 * CS Version injusta: El cliente espera si el equipo de limpieza est� trabajando
// 	 * CS Version justa: El cliente espera si el equipo de limpieza est� trabajando o
// 	 * est� esperando para poder limpiar los aseos
// 	 * @throws InterruptedException
// 	 * 
// 	 */
// 	public void entroAseo(int id) throws InterruptedException{

// 		mutex.acquire();

// 		nClientes ++;
// 		if (nClientes == 1) {
// 			limpiando.acquire();
// 		}
// 		System.out.println("El cliente " + id + " ha entrado en el baño." + " Clientes en el aseo: " + nClientes);

// 		mutex.release();

// 	}

// 	/**
// 	 * Utilizado por el cliente id cuando sale de los aseos
// 	 * @throws InterruptedException
// 	 * 
// 	 */
// 	public void salgoAseo(int id) throws InterruptedException{

// 		mutex.acquire();

// 		nClientes --;
// 		System.out.println("El cliente " + id + " ha salido del baño." + " Clientes en el aseo: " + nClientes);
// 		if (nClientes == 0) {
// 			limpiando.release();
// 		}

// 		mutex.release();

// 	}
	
// 	/**
// 	 * Utilizado por el Equipo de Limpieza cuando quiere entrar en los aseos 
// 	 * CS: El equipo de trabajo est� solo en los aseos, es decir, espera hasta que no
// 	 * haya ning�n cliente.
// 	 * @throws InterruptedException
// 	 * 
// 	 */
//     public void entraEquipoLimpieza() throws InterruptedException{

// 		limpiando.acquire();

// 		System.out.println("El equipo de limpieza está trabajando.");

// 	}
    
//     /**
// 	 * Utilizado por el Equipo de Limpieza cuando  sale de los aseos 
// 	 * 
// 	 * 
// 	 */
//     public void saleEquipoLimpieza(){

// 		System.out.println("El equipo de limpieza ha terminado.");

// 		limpiando.release();
    	
// 	}
// }

	private int nClientes = 0;
	private int nEquipos = 0;
	private Semaphore mutex1 = new Semaphore(1, true);
	private Semaphore mutex2 = new Semaphore(1, true);
	private Semaphore limpiando = new Semaphore(1, true);
	private Semaphore aseando = new Semaphore(1, true);
	
	/**
	 * Utilizado por el cliente id cuando quiere entrar en los aseos
	 * CS Version injusta: El cliente espera si el equipo de limpieza est� trabajando
	 * CS Version justa: El cliente espera si el equipo de limpieza est� trabajando o
	 * est� esperando para poder limpiar los aseos
	 * @throws InterruptedException
	 * 
	 */
	public void entroAseo(int id) throws InterruptedException{

		aseando.acquire();
		mutex1.acquire();

		nClientes ++;
		if (nClientes == 1) {
			limpiando.acquire();
		}
		System.out.println("El cliente " + id + " ha entrado en el baño." + " Clientes en el aseo: " + nClientes);

		mutex1.release();
		aseando.release();

	}

	/**
	 * Utilizado por el cliente id cuando sale de los aseos
	 * @throws InterruptedException
	 * 
	 */
	public void salgoAseo(int id) throws InterruptedException{

		mutex1.acquire();

		nClientes --;
		System.out.println("El cliente " + id + " ha salido del baño." + " Clientes en el aseo: " + nClientes);
		if (nClientes == 0) {
			limpiando.release();
		}

		mutex1.release();

	}
	
	/**
	 * Utilizado por el Equipo de Limpieza cuando quiere entrar en los aseos 
	 * CS: El equipo de trabajo est� solo en los aseos, es decir, espera hasta que no
	 * haya ning�n cliente.
	 * @throws InterruptedException
	 * 
	 */
    public void entraEquipoLimpieza() throws InterruptedException{

		mutex2.acquire();

		nEquipos ++;
		if (nEquipos == 1) {
			aseando.acquire();
		}
		System.out.println("El equipo de limpieza quiere entrar.");

		mutex2.release();
		limpiando.acquire();
		System.out.println("El equipo de limpieza está trabajando.");

	}
    
    /**
	 * Utilizado por el Equipo de Limpieza cuando  sale de los aseos 
     * @throws InterruptedException
	 * 
	 * 
	 */
    public void saleEquipoLimpieza() throws InterruptedException{


		mutex2.acquire();

		System.out.println("El equipo de limpieza ha terminado.");
		nEquipos --;
		if (nEquipos == 0) {
			aseando.release();
		}

		mutex2.release();
		limpiando.release();
    	
	}
}


