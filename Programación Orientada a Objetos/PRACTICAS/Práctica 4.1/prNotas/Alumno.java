package prNotas;

public class Alumno {
	private String nombre,dni;
	private double nota;
	
	public Alumno(String d,String n,double c) throws AlumnoException{
		nombre=n;
		dni=d;
		if(c<0) {
			throw new AlumnoException("Calificación negativa");
		}else {
			nota=c;
		}
	}
	
	public Alumno(String d,String n) {
		dni=d;
		nombre=n;
		nota=0;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public double getCalificacion() {
		return nota;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Alumno;
		Alumno a=res? (Alumno)o: null;
		return res&&nombre.equals(a.nombre)&&dni.equalsIgnoreCase(a.dni);
	}
	
	@Override
	public int hashCode() {
		return nombre.hashCode()+dni.hashCode();
	}
	
	public String toString() {
		return nombre+" "+dni;
	}
}
