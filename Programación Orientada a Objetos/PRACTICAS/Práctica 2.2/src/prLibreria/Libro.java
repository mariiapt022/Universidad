package prLibreria;
//Práctica 2.2 
//María Peinado Toledo 
public class Libro {
	private static double porcIVA = 10;
	private String autor;
	private String titulo;
	private double precioBase;
	
	public Libro(String a, String t, double p) {
		autor=a;
		titulo=t;
		precioBase=p;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public double getPrecioBase() {
		return precioBase;
	}
	
	public double getPrecioFinal() {
		return getPrecioBase() + (getPrecioBase()*porcIVA/100);
	}
	
	@Override
    public String toString() {
   	 return "(" + getAutor() + "; " + getTitulo() + "; " + getPrecioBase() + "; " + getIVA() + "%; " + getPrecioFinal() + ")";
    }
	
    public static double getIVA() {
   	 return porcIVA;
    }
	
    public static void setIVA(double IVA2) {
    	porcIVA=IVA2;
    }
    
    
}
