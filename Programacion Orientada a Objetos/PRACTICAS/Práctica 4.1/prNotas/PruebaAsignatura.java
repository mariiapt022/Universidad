package prNotas;

public class PruebaAsignatura {

	public static void main(String[] args) {
		String[] asig = {"12455666F;Lopez Perez, Pedro;6.7","33678999D;Merlo Gomez, Isabel;5.8","23555875G;Martinez Herrera, Lucia;9.1"};
		Asignatura POO = new Asignatura("POO", asig);
		
		
		try {
			System.out.println("Media: " + POO.getMedia());
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
		String dnis = "DNI's: ";
		for (Alumno al : POO.getAlumnos()) {
			dnis += al.getDni() + ", ";
		}
		System.out.println(dnis);
		
		try {
			Alumno a = new Alumno ("12455666F", "Lopez Perez, Pedro");
			System.out.println("Calificación del alumno " + a.getNombre() + ": " + POO.getCalificacion(a));
 
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
