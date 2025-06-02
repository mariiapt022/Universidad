package prNotas;

public class PruebaAlumno {

	public static void main(String[] args) {
		try {
			Alumno a= new Alumno("22456784F","Gonzalez Perez, Juan",5.5);
			Alumno b= new Alumno("33456777S","Gonzalez Perez, Juan",3.4);
			
			System.out.println(a + "; Nota:  " + a.getCalificacion());
			System.out.println(b + "; Nota:  " + b.getCalificacion());
			
			if (a.equals(b)) {
				  System.out.println("Ambos alumnos son iguales");
			  } else {
				  System.out.println("Ambos alumnos no son iguales");
			  }
			
			//b= new Alumno("33456777S","Gonzalez Perez, Juan",-3.4);
			
			}catch(AlumnoException e) {
				e.printStackTrace();
			}
	}

}
