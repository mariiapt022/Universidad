package videoclub;

import java.util.*;

public class Pelicula {
	
	private String titulo, codigo;
	
	private Set<String> actores;
	
	private int año;
	
	
	public Pelicula ( String titulo, Set<String> actores, String codigo, int año) {
		
		this.titulo = titulo;
		this.actores = actores;
		this.codigo = codigo;
		this.año = año;
		
		
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
	
	public int compareTo(Pelicula p2) {
		
		int res = this.titulo.compareToIgnoreCase(p2.titulo);
		
		if (res == 0)
			res = Integer.compare(año, p2.año);
		
		return res;
	}

	@Override
	public int hashCode() {
		return getTitulo().toLowerCase().hashCode() + getAño();
	}



	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		if(obj instanceof Pelicula) {
			Pelicula other = (Pelicula) obj;
			ok = getTitulo().equalsIgnoreCase(other.getTitulo()) && getAño() == other.getAño();
		}
		return ok;
	}



	public String toString() {
		
		
		return "[" +titulo+ "," +actores+ "," +codigo+ "," +año+"]" ;
		
		
	}

}
