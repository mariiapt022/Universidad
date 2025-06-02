package videoclub;

import java.util.*;

public class Pelicula {
	
	private String titulo, codigo;
	
	private Set<String> actores;
	
	private int a�o;
	
	
	public Pelicula ( String titulo, Set<String> actores, String codigo, int a�o) {
		
		this.titulo = titulo;
		this.actores = actores;
		this.codigo = codigo;
		this.a�o = a�o;
		
		
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
	
	public int compareTo(Pelicula p2) {
		
		int res = this.titulo.compareToIgnoreCase(p2.titulo);
		
		if (res == 0)
			res = Integer.compare(a�o, p2.a�o);
		
		return res;
	}

	@Override
	public int hashCode() {
		return getTitulo().toLowerCase().hashCode() + getA�o();
	}



	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		if(obj instanceof Pelicula) {
			Pelicula other = (Pelicula) obj;
			ok = getTitulo().equalsIgnoreCase(other.getTitulo()) && getA�o() == other.getA�o();
		}
		return ok;
	}



	public String toString() {
		
		
		return "[" +titulo+ "," +actores+ "," +codigo+ "," +a�o+"]" ;
		
		
	}

}
