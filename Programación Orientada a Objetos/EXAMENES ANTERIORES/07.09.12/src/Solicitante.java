
public class Solicitante implements Comparable<Solicitante>{
	private String nif;         //NIF del tutor del solicitante
	private String nombre;		//Nombre del solicitante
	private double puntos;		//Numero de puntos resultado de la baremación
	private boolean tienePlaza;	//Indica si el solicitante tiene o no tiene plaza
	
	public Solicitante(String nif, String nombre, double puntos) {
		this.nif = nif;
		this.nombre = nombre;
		this.puntos = puntos;
		tienePlaza = false;   //Inicialmente el solicitante no tiene plaza
	}
	
	//Orden natural: Es menor el solicitante con mayor número de puntos. 
	//               A igualdad de puntos es menor el que su nombre sea menor alfabéticamente
	public int compareTo(Solicitante j) {
		int res;
		
		if (this.getPuntos() > j.getPuntos())
			res = -1;
		else if (this.getPuntos() < j.getPuntos())
			res = 1;
		else
			res = this.getNombre().compareToIgnoreCase(j.getNombre());
		return res;

	}
	
	//Dos solicitantes son iguales si tienen el mismo nif del tutor, el mismo nombre y los mismos puntos
	public boolean equals(Object o){ 
	    boolean res = false;
		if (o instanceof Solicitante) { 
	      Solicitante j = (Solicitante) o; 
	      res = nif.equalsIgnoreCase(j.nif) && 
	    		  nombre.equalsIgnoreCase(j.nombre) &&
	    		  puntos == j.puntos;
		}
		return res;
	}
		
	public int hasCode() {
		return nif.toLowerCase().hashCode() + nombre.toLowerCase().hashCode() + (int)puntos;
	}
	
	public void setTienePlaza(boolean plaza) {
		tienePlaza = plaza;
	}
	
	public boolean getTienePlaza() {
		return tienePlaza;
	}
	
	public String getNIF() {
		return nif;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPuntos(){
		return puntos;
	}
	
	public String toString() {
		return nif + " " + puntos + " " + nombre;
	}
	
}
