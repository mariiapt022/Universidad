package prLibreria;
import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {
	private double descuento;
	private String[] autoresOferta;
	
	public OfertaAutor(double des, String[] a) {
		descuento=des;
		autoresOferta=a;
	}
	
	@Override
	public double getDescuento(Libro libro) {
		if(buscarAutorOferta(libro.getAutor())>=0) {
			return descuento;
		}else {
			return 0;
		}
	}
	
	private int buscarAutorOferta(String a) {
 	   int id = -1;
 	   for (int i=0; i<autoresOferta.length; i++) {
 		   if (autoresOferta[i].equalsIgnoreCase(a)) {
 			   id = i;
 		   }
 	   }
 	   return id;
    }
	
	public String toString() {
		return descuento+"%"+Arrays.toString(autoresOferta);
	}
	
	
}
