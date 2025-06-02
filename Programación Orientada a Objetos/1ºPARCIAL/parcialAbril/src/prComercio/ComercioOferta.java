package prComercio;

import java.util.Arrays;

public class ComercioOferta extends Comercio{
	private String[] listaDescripcion;
	
	public ComercioOferta(int tam, String[] des) throws ComercioException {
		super(tam);
		if(tam==0) {
			throw new ComercioException("Tamaño no válido");
		}else {
			listaDescripcion=des;
		}
	}
	
	@Override
	public double calcSumaPrecio(int num1, int num2) {
		boolean encontrado=false;
		double suma=0;
		for(int i=0;i<super.numDatos;i++) {
			if(super.comerc[i].getCantidad()>num1 && super.comerc[i].getCantidad()<num2) {
				for(int j=0;j<listaDescripcion.length;j++) {
					if(super.comerc[i].getDescripcion().equalsIgnoreCase(listaDescripcion[j])) {
						encontrado=true;
					}
					
				}
				if(encontrado) {
					suma=suma+super.comerc[i].getPrecio()/2;
				}else {
					suma=suma+super.comerc[i].getPrecio();
				}
				
			}
			encontrado=false;
		}
		return suma;
	}
	
	public String toString() {
		return Arrays.toString(listaDescripcion)+", "+Arrays.toString(super.comerc);
	}
	
	

}
