package prControl2063;

import java.util.Arrays;

public class Bazar {
	private Ropa[] datos;
	private int numDatos;
	public Bazar() {
		datos=new Ropa[0];
		numDatos=0;
	}
	
	private int buscarRopa(Ropa r) {
		int i=0;
		boolean encontrado=false;
		while(i<datos.length&&!encontrado) {
			if(datos[i]!=null&&datos[i].equals(r)) {
				encontrado=true;
			}else {
				i++;
			}
		}
		return encontrado? i:-1;
	}
	
	public void anyadir(Ropa r) throws BazarException {
		int pos=buscarRopa(r);
		if(pos==-1) {
			if(numDatos==datos.length) {
				datos=Arrays.copyOf(datos, numDatos+1);
			}
			datos[numDatos]=r;
		}else {
			int cantidad=datos[pos].getCantidad();
			datos[pos]=r;
			datos[pos].setCantidad(cantidad);
		}
		datos=Arrays.copyOf(datos, numDatos);
	}
	
	public Bazar seleccionar(Selector s) throws BazarException {
		Bazar res=new Bazar();
		for(int i=0;i<numDatos;i++) {
			if(s.esSeleccionable(datos[i])) {
				res.anyadir(datos[i]);
			}
		}
		return res;
	}
	
	public double calcSumaCantidad(Selector s) {
		int suma=0;
		for(int i=0;i<numDatos;i++) {
			if(s.esSeleccionable(datos[i])) {
				suma=suma+datos[i].getCantidad();
			}
		}
		return suma;
	}
	
	public String toString() {
		return "";
	}
	
	
	
}
