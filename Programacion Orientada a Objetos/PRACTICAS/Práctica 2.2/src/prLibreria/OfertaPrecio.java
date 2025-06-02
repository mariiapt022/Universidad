package prLibreria;

public class OfertaPrecio implements OfertaFlex {
	private double descuento;
	private double umbral;
	
	public OfertaPrecio(double des, double umb) {
		descuento=des;
		umbral=umb;
	}
	
	@Override
	public double getDescuento(Libro libro) {
		if(libro.getPrecioBase()>=umbral) {
			return descuento;
		}else {
			return 0;
		}
	}
	
	
	public String toString() {
		 return descuento + "%(" + umbral + ")";
	}

}
