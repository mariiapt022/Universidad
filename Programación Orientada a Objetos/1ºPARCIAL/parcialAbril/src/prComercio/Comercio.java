package prComercio;
import java.util.Arrays;

public class Comercio {
	public int numDatos;
	public Herramienta[]comerc;
		
	public Comercio(int tam) throws ComercioException {
		if(tam<=0) {
			throw new ComercioException("Tamaño no válido");
		}
		
		numDatos=0;
		comerc= new Herramienta [tam];
		
	}
	
	
	
	public void anyadir(Herramienta h) throws ComercioException{
		boolean encontrado=false;
		int i=0;
		while(i<numDatos) {
			try {
				if(h.igual(comerc[i])) {
					h.setPrecio(comerc[i].getPrecio());
					comerc[i]=h;
					encontrado=true;
				}
			} catch (ComercioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		if(!encontrado) {
			if(numDatos>=comerc.length) {
				comerc = Arrays.copyOf(comerc, 2*comerc.length);
			}
			comerc[numDatos]=h;
			numDatos++;
		}
		comerc=Arrays.copyOf(comerc, numDatos);
	}
	
	public void eliminar(String h) throws ComercioException {
		boolean encontrado=false;
		
		for(int i=0;i<numDatos;i++) {
			if(h.equalsIgnoreCase(comerc[i].getDescripcion())) {
				System.arraycopy(comerc, i+1, comerc, i, comerc.length-(i+1));
				numDatos--;
				comerc[numDatos]=null;
				encontrado=true;
			}
		}
		if(encontrado==false) {
			throw new ComercioException("Herramienta no encontrada para eliminar");
		}
		
	}
	
	public Herramienta[] seleccionar(int num1, int num2) {
		int k=0;
		Herramienta[] res= new Herramienta[comerc.length];
		
		for(int j=0;j<numDatos;j++) {
			if(comerc[j].getCantidad()>num1 && comerc[j].getCantidad()<num2) {
				res[k]=comerc[j];
				k++;
			}
		}
		res= Arrays.copyOf(res, k);
		
		return res;
	}
	
	public double calcSumaPrecio(int num1, int num2) {
		double suma=0;
		for(int i=0;i<numDatos;i++) {
			if(comerc[i].getCantidad()>=num1 && comerc[i].getCantidad()<=num2) {
				suma=suma+comerc[i].getPrecio();
			}
		}
		return suma;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(comerc);
	}	
	
}