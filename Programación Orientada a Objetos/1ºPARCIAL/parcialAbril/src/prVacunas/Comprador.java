package prVacunas;

import java.util.Arrays;

public class Comprador {
	private Vacuna[] listaVacunas;
	private int numVacunas;
	private String nombre;
	private final static int TAM_INICIAL=10;
	
	public Comprador(String n,int tam) {
		nombre=n;
		if(tam<=0) {
			throw new RuntimeException("Tamaño no válido");
		}else {
			listaVacunas=new Vacuna[tam];
		}
	}
	
	public Comprador(String n) {
		this(n,TAM_INICIAL);
	}
	
	private int buscarVacuna(String codigo) {
		int i=0;
		while(i<numVacunas&&!listaVacunas[i].getCodigo().equalsIgnoreCase(codigo)) {
			i++;
		}
		return i;
	}
	
	public void comprar(String codigo, double precio, int cantidad) {
		if(cantidad<=0) {
			throw new RuntimeException("Cantidad no válida");
		}
		int pos=buscarVacuna(codigo);
		if(pos!=numVacunas) {
			listaVacunas[pos].setCantidad(listaVacunas[pos].getCantidad()+cantidad);
		}else {
			if(numVacunas==listaVacunas.length) {
				listaVacunas=Arrays.copyOf(listaVacunas, numVacunas*2);
			}
			listaVacunas[numVacunas]=new Vacuna(codigo,precio,cantidad);
			numVacunas++;
		}
		listaVacunas=Arrays.copyOf(listaVacunas, numVacunas);
	}
	
	public int getNumVacunas() {
		return numVacunas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double precioTotal() {
		double suma=0;
		for(int i=0;i<listaVacunas.length;i++) {
			if(listaVacunas[i]!=null) {
				suma=suma+listaVacunas[i].precioTotal();
			}
		}
		return suma;
	}
	
	public void eliminar(String codigo) {
		int pos=buscarVacuna(codigo);
		listaVacunas[pos]=null;
		numVacunas--;
	}
	
	public String toString() {
		return getNombre()+" = "+ Arrays.toString(listaVacunas);
	}
	
	
}
