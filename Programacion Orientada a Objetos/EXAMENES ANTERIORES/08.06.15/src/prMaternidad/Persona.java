package prMaternidad;

public class Persona implements Comparable<Persona>{
		
	private String nombre;
	private int codigo; //Será único para cada persona.
	private int numHabitacion;
	
	public Persona(String n, int codigo, int hab){
		if (n == null || codigo <= 0 || hab < 0)
			throw new MaternidadException("Parámetros incorrectos");
		
		nombre = n;
		numHabitacion = hab;
		this.codigo = codigo;
	
	}
	
	public String getNombre() { return nombre;}
	public int getCodigo() { return codigo;}
	public int getHabitacion() { return numHabitacion;}
	
	
	
	public String toString(){
		return nombre + ":" + codigo + ":" + numHabitacion;
	}
	
	public boolean equals(Object o){
		return o instanceof Persona &&
			   this.getCodigo() == ((Persona) o).getCodigo();
	}
	
	public int hashCode(){
		return new Long(this.getCodigo()).hashCode();
	}

	@Override
	//El orden natural ordena a las personas por código 
	public int compareTo(Persona p) {
			return  new Integer(getCodigo()).compareTo(p.getCodigo());
	}
}
