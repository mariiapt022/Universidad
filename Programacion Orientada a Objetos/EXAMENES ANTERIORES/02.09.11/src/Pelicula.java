
import java.util.*;

public class Pelicula implements Comparable<Pelicula> {

	// Atributos ..........................................
	
	String titulo;
	String codigo;
	Set<String> actores;
	int a�o;
	
	// Constructor ........................................
	
	public Pelicula(String tit, Set<String> act, String cod, int a) {
		if ((tit == null || tit.length() == 0) ||
				(cod == null || cod.length() == 0) || 
				(a < 1900)) {
			throw new IllegalArgumentException("Argumento err�neo");
		}
		titulo = tit;
		codigo = cod;
		actores = act;
		a�o = a;
	}
	
	// M�todos de consulta ................................
	
	public String titulo() {
		return titulo;
	}
	
	public String codigo() {
		return codigo;
	}
	
	public Set<String> actores() {
		return actores;
	}
	
	public int a�o() {
		return a�o;
	}
	
	// M�todos redefinidos ................................
	
	public boolean equals(Object p) {
		boolean res = false;
		if (p != null && p instanceof Pelicula) {
			res = ((Pelicula)p).titulo.equalsIgnoreCase(titulo)
					&& ((Pelicula)p).a�o == a�o;
		}
		return res;
	}
	
	public int hashCode() {
		return titulo.toUpperCase().hashCode() + a�o;
	}
	
	public int compareTo(Pelicula p){
		int res = titulo.compareToIgnoreCase(p.titulo);
		if (res == 0){
			res = a�o - p.a�o;
		}
		return res;
	}
	
	public String toString(){
		String str = "[" + titulo + ", " + actores.toString()  
					 + ", " + this.codigo + "," + a�o + "]";
		return str;
	}
}
