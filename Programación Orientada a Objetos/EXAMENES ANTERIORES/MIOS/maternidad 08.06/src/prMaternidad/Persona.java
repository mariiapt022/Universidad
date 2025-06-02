package prMaternidad;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private int codigo,habitacion;
	
	public Persona(String n,int c,int h) {
		if(n==null||c<=0||h<0) {
			throw new MaternidadException("Datos para persona erroneos");
		}else {
			nombre=n;
			codigo=c;
			habitacion=h;
		}
	}

	public String getNombre() {
		return nombre;
	}

	
	public int getCodigo() {
		return codigo;
	}

	
	public int getHabitacion() {
		return habitacion;
	}

	public String toString() {
		return nombre+":"+codigo+":"+habitacion;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Persona;
		Persona p= res? (Persona)o:null;
		return res&&codigo==p.getCodigo();
	}
	
	public int hashCode() {
		return Integer.hashCode(codigo);
	}
	
	public int compareTo(Persona p) {
		return Integer.compare(codigo, p.getCodigo());
	}
	
	
}
