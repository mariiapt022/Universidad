package prLibreria;
//Práctica 2.3
//María Peinado Toledo 
public class LibroOferta extends Libro {
	private double descuento;
	
	public LibroOferta(String a, String t, double p, double d) {
		super(a,t,p);
		descuento=d;
	}
	
	public double getDescuento() {
		return descuento;
	}
	
	public double getPrecioFinal() {
		double PX, PF;
		PX= getPrecioBase()-(getPrecioBase()*getDescuento())/100;
		PF=PX+(PX*getIVA())/100;
		return PF;
	}
	
	@Override
	public String toString() {
		return "(" + getAutor() + "; " + getTitulo() + "; " + getPrecioBase() + "; " + getDescuento() + "%; " + (getPrecioBase() - (getPrecioBase()*getDescuento()/100)) + "; " + getIVA() + "%; " + getPrecioFinal()+")";
	}
	
}
