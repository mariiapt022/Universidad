import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class PruebaBecas {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		SolicitudesBeca sol = new SolicitudesBeca("becas.txt");
		// Becas para solicitar
		Beca beca1Mov = Beca.nuevaBeca("ER2013-1, 1000, MOVILIDAD");
		Beca beca2Mov = Beca.nuevaBeca("ER2013-3, 1500, MOVILIDAD");
		Beca beca1Emp = Beca.nuevaBeca("EMPC2013-1, 0, EMPRESA");
		Beca beca2Emp = Beca.nuevaBeca("EMPNC2013-1, 2500, EMPRESA");
		Beca beca3Emp = Beca.nuevaBeca("EMPNC2013-3, 5000, EMPRESA");
		Beca beca1Ord = Beca.nuevaBeca("DE2013-1, 500, ORDINARIA");
		Beca beca2Ord = Beca.nuevaBeca("CO2013-1, 700, ORDINARIA");
		
		// Estudiantes
		Estudiante paco = new Estudiante("Paco",7,15000);
		Estudiante curro = new Estudiante("Curro",8,17000);
		Estudiante francisco = new Estudiante("Francisco",6,10000);
		Estudiante francis = new Estudiante("Francis",7,17000);
		
		// Solicitudes
		sol.agregarSolicitud(paco,beca1Mov);
		sol.agregarSolicitud(curro,beca1Mov);
		sol.agregarSolicitud(paco,beca2Mov);
		sol.agregarSolicitud(francisco,beca2Mov);
		sol.agregarSolicitud(paco,beca2Emp);
		sol.agregarSolicitud(francisco,beca2Emp);
		sol.agregarSolicitud(francis,beca2Emp);
		sol.agregarSolicitud(paco,beca3Emp);
		sol.agregarSolicitud(francis,beca3Emp);
		sol.agregarSolicitud(curro,beca2Ord);
		
		// Asignación de becas y presentación en consola
		// Según notas
		sol.asignarBecas(new CriterioNota());
		sol.guardarBecasAsignadas(new PrintWriter(System.out,true));
		
		// Según renta
		//sol.asignarBecas(new CriterioRenta());
		//sol.guardarBecasAsignadas(new PrintWriter(System.out,true));
				
		// Becas solicitadas por
		System.out.println(sol.becasSolicitadas(paco));
	}

}
