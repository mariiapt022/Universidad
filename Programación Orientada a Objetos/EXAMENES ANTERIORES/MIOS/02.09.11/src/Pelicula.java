import java.util.Set;

public class Pelicula implements Comparable<Pelicula>{
	private String titulo,codigo;
	private Set<String> actores;
	private int a�o;
	
	public Pelicula(String t,Set<String> a,String c,int an) {
		titulo=t;
		codigo=c;
		actores=a;
		a�o=an;
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
	
	public int getA�o() {
		return a�o;
	}
	
	public String toString() {
		return "["+titulo+", "+actores.toString()+", "+codigo+", "+a�o+"]";
	}
	
	@Override
	public boolean equals(Object O) {
		boolean res= O instanceof Pelicula;
		Pelicula p= res? (Pelicula)O:null;
		return res&&titulo.equalsIgnoreCase(p.getTitulo())&&a�o==p.getA�o();
	}
	
	public int HashCode() {
		return titulo.toUpperCase().hashCode()+Integer.hashCode(a�o);
	}
	
	
	public int compareTo(Pelicula p) {
		int res=titulo.compareToIgnoreCase(p.getTitulo());
		if(res==0) {
			res=a�o-p.getA�o();
		}
		return res;
	}
	
}
