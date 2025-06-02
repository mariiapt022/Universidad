package alturas;

public class Pais implements Comparable<Pais>{
	private String nombre,continente;
	private double altura;
	
	public Pais(String n,String c,double a) {
		nombre=n;
		continente=c;
		altura=a;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getContinente() {
		return continente;
	}
	
	public double getAltura() {
		return altura;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Pais;
		Pais p=res? (Pais)o:null;
		return res&&p.getNombre().equals(nombre);
	}
	
	public int hashCode() {
		return nombre.hashCode();
	}
	
	public String toString() {
		return "Pais("+nombre+", "+continente+", "+altura+")";
	}
	
	@Override
	public int compareTo(Pais p) {
		return nombre.compareTo(p.getNombre());
	}
	
}
