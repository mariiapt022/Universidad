package prNotasInterfazMedia;

public class MediaSinExtremos implements CalculoMedia{
	private double min;
	private double max;
	public MediaSinExtremos(double mi, double ma) {
		min = mi;
		max = ma;
	}
	@Override
	public double calcular(Alumno[] a) throws AlumnoException {
		double suma = 0;
        int k=0;
     	if(a.length == 0) {
     		throw new AlumnoException("No hay alumnos registrados");
     	} else {
     		try {
     			for (int i=0;i<a.length;i++) {
     				  if ((a[i].getCalificacion() > min)&&(a[i].getCalificacion() < max)) {
     					 suma += a[i].getCalificacion();
     					 k++;
     				  }
     			 }
     			return suma/k;
     		  } catch (ArithmeticException e) {
     			  throw new AlumnoException("No hay alumnos registrados");
     		  } catch (NullPointerException ee) {
     			  throw new AlumnoException("No hay alumnos registrados");
     		  }
     	}
   }
	public double getMin() {
		return min;
	}
	public double getMax() {
		return max;
	}
}
