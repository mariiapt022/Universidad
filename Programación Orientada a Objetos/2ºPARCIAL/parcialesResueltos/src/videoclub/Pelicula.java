package videoclub;

public class Pelicula {
	private String titulo,codigo;
	private String[] actores;
	private int a�o;
	
	public Pelicula(String t,String[] act,int a,String c) {
		titulo=t;
		actores=act;
		a�o=a;
		codigo=c;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String[] getActores(){
		return actores;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public int getA�o() {
		return a�o;
	}
	
	public String toString() {
		return "[" +titulo+" , "+actores.toString()+" , "+codigo+" , "+a�o+"]";
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Pelicula;
		Pelicula p= res? (Pelicula)o:null;
		return res&&titulo.equalsIgnoreCase(p.getTitulo())&&a�o==p.getA�o();
	}
	
	public int hashCode() {
		return titulo.toUpperCase().hashCode()+Integer.hashCode(a�o);
	}
	
	public int compareTo(Pelicula p){
		int res = titulo.compareToIgnoreCase(p.titulo);
		if (res == 0){
			res = a�o - p.a�o;
		}
		return res;
	}
	
}
