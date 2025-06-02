package videoclub;

public class Pelicula {
	private String titulo,codigo;
	private String[] actores;
	private int año;
	
	public Pelicula(String t,String[] act,int a,String c) {
		titulo=t;
		actores=act;
		año=a;
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
	
	public int getAño() {
		return año;
	}
	
	public String toString() {
		return "[" +titulo+" , "+actores.toString()+" , "+codigo+" , "+año+"]";
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Pelicula;
		Pelicula p= res? (Pelicula)o:null;
		return res&&titulo.equalsIgnoreCase(p.getTitulo())&&año==p.getAño();
	}
	
	public int hashCode() {
		return titulo.toUpperCase().hashCode()+Integer.hashCode(año);
	}
	
	public int compareTo(Pelicula p){
		int res = titulo.compareToIgnoreCase(p.titulo);
		if (res == 0){
			res = año - p.año;
		}
		return res;
	}
	
}
