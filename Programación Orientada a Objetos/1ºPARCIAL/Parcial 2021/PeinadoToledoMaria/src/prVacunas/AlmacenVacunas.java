package prVacunas;
/*
 * Alumna: Peinado Toledo María, 
 * Titulación: Doble Grado Ingeniería Informática y Matemáticas,
 * Grupo 1
 */

import java.util.Arrays;

public class AlmacenVacunas {
	private final static int CAP_INICIAL=3;
	private String nombre;
	private int numVacunas;
	private Vacuna[] vacunas;
	
	public AlmacenVacunas(String n,int tam) {
		if(tam<=0) {
			throw new RuntimeException("Tamaño no válido");
		}else {
			nombre=n;
			vacunas=new Vacuna[tam];
			numVacunas=0;
		}
		
	}
	
	public AlmacenVacunas(String n) {
		this(n,CAP_INICIAL);
	}
	
	private int buscarVacuna(String codigo) {
		int i=0;
		while(i<numVacunas&&!vacunas[i].getCodigo().equalsIgnoreCase(codigo)) {
			i++;
		}
		return i;
	}
	
	public void almacenar(String codigo,int viales, int dosis) {
		int pos=buscarVacuna(codigo);
		if(pos<numVacunas) {
			vacunas[pos].setViales(viales);
		}else {
			if(numVacunas==vacunas.length) {
				vacunas=Arrays.copyOf(vacunas, vacunas.length*2);
			}
			Vacuna nueva= new Vacuna(codigo,viales,dosis);
			vacunas[numVacunas]=nueva;
			numVacunas++;
		}
		vacunas=Arrays.copyOf(vacunas, numVacunas);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int totalDosis() {
		int td=0;
		for(int i=0;i<numVacunas;i++) {
			td=td+vacunas[i].dosisTotales();
		}
		return td;
	}
	
	public void inocularTodas(String codigo) {
		int pos=buscarVacuna(codigo);
		if(pos!=numVacunas) {
			vacunas[pos]=null;
			for(int i=pos;i<numVacunas-1;i++) {
				vacunas[i]=vacunas[i+1];
			}
			numVacunas--;
		}
		vacunas=Arrays.copyOf(vacunas, numVacunas);
	}
	
	public String toString() {
		return nombre+ " = "+Arrays.toString(vacunas);
	}
	
	
}
