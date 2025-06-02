package prNotasInterfazMedia;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class Asignatura {
	private String nombre;
	private String[] errores;
	private Alumno[] alumnos;
	
	public Asignatura(String nom, String[] asig) {
  	  nombre = nom;
  	  this.procesarDatos(asig);
    }
	
	protected void procesarDatos(String[] datos) {
		int numAlum=0,numErr=0;
		String nombre,dni;
		double nota;
  	  	alumnos = new Alumno[datos.length];
		errores = new String[datos.length];
  	  	
		for(String a:datos) {
  	  		try (Scanner sc = new Scanner(a)){
  	  			sc.useDelimiter("[;]");
  	  			sc.useLocale(Locale.ENGLISH);
  	  			dni = sc.next();
  	  			nombre = sc.next();
  	  			nota = sc.nextDouble();
  	  			Alumno al = new Alumno(dni, nombre, nota);
  	  			alumnos[numAlum] = al;
  	  			numAlum++;
  	  		}catch (AlumnoException e) {
  	  			errores[numErr] = "ERROR." + e.getMessage() + ": " + a;
  	  			numErr++;
  	  		} catch (InputMismatchException ee) {
  	  			errores[numErr] = "ERROR. Calificación no numérica" + ": " + a;
  	  			numErr++;
  	  		} catch (NoSuchElementException eee) {
  	  			errores[numErr] = "ERROR. Faltan datos" + ": " + a;
  	  			numErr++;
  	  		}
		}
		alumnos=Arrays.copyOf(alumnos, numAlum);
		errores=Arrays.copyOf(errores,numErr);
	}
	
	public double getCalificacion(Alumno al) throws AlumnoException{
		double nota = 0;
  	  	boolean encontrado = false;
  	  	for (int i=0;i<alumnos.length;i++) {
  	  		if (alumnos[i].equals(al)) {
  	  		encontrado = true;
  			  nota = alumnos[i].getCalificacion();
  	  		}
  	  	}
  	  	if (!encontrado) {
  		  throw new AlumnoException("El alumno " + al.toString() + " no se encuentra");
  	  	}else {
  	  		return nota;
  	  	}
	}
	
	public Alumno[] getAlumnos(){
		return alumnos;
	}
	
	public String[] getErrores() {
		return errores;
	}
	
	public double getMedia(CalculoMedia calc) throws AlumnoException {
  	  	return calc.calcular(alumnos);
    }
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(nombre + ": {" + Arrays.toString(alumnos) + ",\n" + Arrays.deepToString(errores) + " }");
  	  	if (alumnos.length == 0 && errores.length == 0) {
  		  return "Asignatura vacía";
  	  	} else {
  		  return str.toString();
  	  	}
	}
}
