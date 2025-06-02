package packageprJarras;
//Práctica 2.1 
//María Peinado Toledo 
public class Jarra {

	private int contenido;
	private final int capacidad;
		
	public Jarra(int capacidad) {
		if(capacidad<=0) {
			throw new RuntimeException("Capacidad no valida");
		}
		this.capacidad=capacidad;
		contenido=0;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public int getContenido() {
		return contenido;
	}
	
	public void llenar() {
		contenido=capacidad;
	}
	
	public void vaciar() {
		contenido=0;
	}
	
	public void llenarDesde(Jarra j) {
		int falta= this.capacidad-this.contenido;
		if(falta>= j.getContenido()) {
			this.contenido+=j.getContenido();
			j.vaciar();
		}else {
			this.llenar();
			j.contenido-=falta;
		}
	}
	
	public String toString() {
		return "J("+capacidad+" , "+contenido+")";
	}

}
