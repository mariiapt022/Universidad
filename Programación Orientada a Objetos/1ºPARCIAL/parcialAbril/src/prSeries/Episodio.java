package prSeries;

public class Episodio {
	protected String titulo;
	protected int duracion,capitulo;
	
	public Episodio(int c,String t,int d) throws SerieException{
		if(c<0||d<0) {
			throw new SerieException("Capítulo o duración negativa");
		}else {
			duracion=d;
			titulo=t;
			capitulo=c;
		}
	}
	
	public int getCapitulo() {
		return capitulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public boolean equals(Episodio e) {
		return this.getTitulo().equalsIgnoreCase(e.getTitulo())&&this.getDuracion()==e.getDuracion();
	}
	
	public String toString() {
		return "Episodio "+this.getCapitulo()+": "+this.getTitulo()+" ("+this.getDuracion()+" min)";
	}
	
	
}
