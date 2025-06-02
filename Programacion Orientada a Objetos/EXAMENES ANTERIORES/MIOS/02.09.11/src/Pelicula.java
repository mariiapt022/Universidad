import java.util.Set;

public class Pelicula implements Comparable<Pelicula>{
	private String titulo,codigo;
	private Set<String> actores;
	private int año;
	
	public Pelicula(String t,Set<String> a,String c,int an) {
		titulo=t;
		codigo=c;
		actores=a;
		año=an;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public Set<String> getActores() {
		return actores;
	}
	
	public int getAño() {
		return año;
	}
	
	public String toString() {
		return "["+titulo+", "+actores.toString()+", "+codigo+", "+año+"]";
	}
	
	@Override
	public boolean equals(Object O) {
		boolean res= O instanceof Pelicula;
		Pelicula p= res? (Pelicula)O:null;
		return res&&titulo.equalsIgnoreCase(p.getTitulo())&&año==p.getAño();
	}
	
	public int HashCode() {
		return titulo.toUpperCase().hashCode()+Integer.hashCode(año);
	}
	
	
	public int compareTo(Pelicula p) {
		int res=titulo.compareToIgnoreCase(p.getTitulo());
		if(res==0) {
			res=año-p.getAño();
		}
		return res;
	}
	
}
