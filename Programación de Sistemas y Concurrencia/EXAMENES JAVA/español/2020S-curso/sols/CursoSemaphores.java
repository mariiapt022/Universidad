package esqueletosemaforo;

import java.util.concurrent.Semaphore;

import javax.print.attribute.standard.MediaSize.NA;

public class Curso {

	//Numero maximo de alumnos cursando simultaneamente la parte de iniciacion
	private final int MAX_ALUMNOS_INI = 10;
	
	//Numero de alumnos por grupo en la parte avanzada
	
	private final int ALUMNOS_AV = 3;
	private Semaphore mutexIni = new Semaphore(1, true);
	private Semaphore mutexAv = new Semaphore(1, true);
	private Semaphore entraIni = new Semaphore(1, true);
	private Semaphore entraAv = new Semaphore(1, true);
	private Semaphore esperaGrupo = new Semaphore(0, true);

	private int alumnosIni = 0;
	private int alumnosAv = 0;
	private int alumnosAcaba = 0;
	
	//El alumno tendra que esperar si ya hay 10 alumnos cursando la parte de iniciacion
	public void esperaPlazaIniciacion(int id) throws InterruptedException{
		//Espera si ya hay 10 alumnos cursando esta parte
		mutexIni.acquire();
		entraIni.acquire();
		alumnosIni++;
		//Mensaje a mostrar cuando el alumno pueda conectarse y cursar la parte de iniciacion
		System.out.println("PARTE INICIACION: Alumno " + id + " cursa parte iniciacion. Hay: " + alumnosIni);
		if (alumnosIni < MAX_ALUMNOS_INI) {
			entraIni.release();
		}
		mutexIni.release();
	}

	//El alumno informa que ya ha terminado de cursar la parte de iniciacion
	public void finIniciacion(int id) throws InterruptedException{
		mutexIni.acquire();
		alumnosIni--;
		//Mensaje a mostrar para indicar que el alumno ha terminado la parte de principiantes
		System.out.println("PARTE INICIACION: Alumno " + id + " termina parte iniciacion");
		//Libera la conexion para que otro alumno pueda usarla
		if (alumnosIni == MAX_ALUMNOS_INI-1) {
			entraIni.release();
		}
		mutexIni.release();
	}
	
	/* El alumno tendra que esperar:
	 *   - si ya hay un grupo realizando la parte avanzada
	 *   - si todavia no estan los tres miembros del grupo conectados
	 */
	public void esperaPlazaAvanzado(int id) throws InterruptedException{
		//Espera a que no haya otro grupo realizando esta parte
		entraAv.acquire();
		//Espera a que haya tres alumnos conectados
		mutexAv.acquire();
		alumnosAv++;
		if (alumnosAv < 3) {
			//Mensaje a mostrar si el alumno tiene que esperar al resto de miembros en el grupo
			System.out.println("\t PARTE AVANZADA: Alumno " + id + " espera a que haya " + ALUMNOS_AV + " alumnos");
			mutexAv.release();
			entraAv.release();
			esperaGrupo.acquire();
			mutexAv.acquire();
		} else {
			esperaGrupo.release();
			esperaGrupo.release();
		}
		//Mensaje a mostrar cuando el alumno pueda empezar a cursar la parte avanzada
		System.out.println("\t PARTE AVANZADA: Hay " + ALUMNOS_AV + " alumnos. Alumno " + id + " empieza el proyecto");
		mutexAv.release();
	}
	
	/* El alumno:
	 *   - informa que ya ha terminado de cursar la parte avanzada 
	 *   - espera hasta que los tres miembros del grupo hayan terminado su parte 
	 */ 
	public void finAvanzado(int id) throws InterruptedException{
		//Espera a que los 3 alumnos terminen su parte avanzada
		mutexAv.acquire();
		alumnosAcaba++;
		if (alumnosAcaba < 3) {
			//Mensaje a mostrar si el alumno tiene que esperar a que los otros miembros del grupo terminen
			System.out.println("\t PARTE AVANZADA: Alumno " +  id + " termina su parte del proyecto. Espera al resto");
			mutexAv.release();
			esperaGrupo.acquire();
			mutexAv.acquire();
		} else {
			esperaGrupo.release();
			esperaGrupo.release();
		}
		alumnosAcaba--;
		if (alumnosAcaba == 0) {
			//Mensaje a mostrar cuando los tres alumnos del grupo han terminado su parte
			System.out.println("\t PARTE AVANZADA: LOS " + ALUMNOS_AV + " ALUMNOS HAN TERMINADO EL CURSO");
			alumnosAv = 0;
			entraAv.release();
		}
		mutexAv.release();
	}
}
