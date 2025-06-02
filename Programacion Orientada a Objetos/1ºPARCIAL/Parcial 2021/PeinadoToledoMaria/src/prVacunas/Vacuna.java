package prVacunas;
/*
 * Alumna: Peinado Toledo María, 
 * Titulación: Doble Grado Ingeniería Informática y Matemáticas,
 * Grupo 1
 */

public class Vacuna {
	private String codigo;
	private int dosis, viales;
	
	public Vacuna(String c,int v,int d) {
		if(v<=0||d<=0) {
			throw new RuntimeException("Dosis o viales <=0");
		}else {
			codigo=c;
			viales=v;
			dosis=d;
		}
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public int getDosis() {
		return dosis;
	}
	
	public int getViales() {
		return viales;
	}
	
	public void setViales(int num) {
		if(num<=0) {
			throw new RuntimeException("Numero introducido no válido");
		}else {
			viales+=num;
		}
		
	}
	
	public void setDosis(int num) {
		if(num<=0) {
			throw new RuntimeException("Numero introducido no válido");
		}else {
			dosis+=num;
		}
	}
	
	public int dosisTotales() {
		int dt=dosis*viales;
		return dt;
	}
	
	public String toString() {
		return "("+codigo.toUpperCase()+": "+viales+" x "+dosis+" dosis)";
	}
}
