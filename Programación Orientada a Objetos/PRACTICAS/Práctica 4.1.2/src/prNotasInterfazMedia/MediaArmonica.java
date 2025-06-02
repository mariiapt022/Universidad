package prNotasInterfazMedia;

public class MediaArmonica implements CalculoMedia{
	public MediaArmonica() {
		
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
     				if (a[i].getCalificacion()>0) {
     					k++;
     					suma += 1/(a[i].getCalificacion());
     				} 
     			}
     			return k/suma;
     		}catch (ArithmeticException e) {
     			throw new AlumnoException("No hay alumnos registrados");
     		}
     	}
	}
}
