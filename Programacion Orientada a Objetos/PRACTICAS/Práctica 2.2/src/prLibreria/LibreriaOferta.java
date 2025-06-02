package prLibreria;
import java.util.Arrays;
//Práctica 2.3
//María Peinado Toledo 
public class LibreriaOferta extends Libreria{
	private double descuento;
    private String[] autoresOferta;
    
    
    public LibreriaOferta(double d, String[] a) {
		descuento=d;
		a=autoresOferta;
	}
    
    
	public LibreriaOferta(int c, double d, String[] a) {
  	  super(c);
  	  descuento = d;
  	  autoresOferta = a;
    }
	
	public void setOferta(double d, String[] a) {
		descuento=d;
		autoresOferta=a;
	}
	
	public String[] getOferta() {
  	  return autoresOferta;
    }
	
	public double getDescuento() {
		return descuento;
	}
	
	@Override
	public void addLibro(String a, String t, double p) {
		if(buscarAutorOferta(a)>=0) {
			anyadirLibro(new LibroOferta(a,t,p,descuento));
		}else {
			anyadirLibro(new Libro(a,t,p));
		}
	}
	
	private int buscarAutorOferta(String a) {
		int id=-1;
		for(int i=0;i<autoresOferta.length;i++) {
			if(autoresOferta[i].equalsIgnoreCase(a)) {
				id=i;
			}
		}
		return id;
	}
	
	public String toString() {
		String result = getDescuento() + "%" + Arrays.toString(autoresOferta);
  	  	return result + "/n" + super.toString();
	}
	
}
