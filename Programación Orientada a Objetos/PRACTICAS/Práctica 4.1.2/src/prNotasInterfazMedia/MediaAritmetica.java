package prNotasInterfazMedia;

public class MediaAritmetica implements CalculoMedia{
	public MediaAritmetica() {	
		
    }
	@Override
    public double calcular(Alumno[] a) throws AlumnoException {
   	 double suma = 0;
  	  if(a.length == 0) {
  		  throw new AlumnoException("No hay alumnos registrados");
  	  } else {
  		  try {
  			for (int i=0;i<a.length;i++) {
        		  suma += a[i].getCalificacion();
        	  }
        	  return suma/a.length;
  		  } catch (ArithmeticException e) {
  			  throw new AlumnoException("No hay alumnos registrados");
  		  }
  	  }
  }
}
