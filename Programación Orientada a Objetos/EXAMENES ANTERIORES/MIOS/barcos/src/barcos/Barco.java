package barcos;

public class Barco implements Comparable<Barco>{
	protected String nombre;
	protected Posicion posicion;
	protected int rumbo,velocidad;
	
	public Barco(String n,Posicion p,int r,int v) {
		if(r<0||r>359) {
			throw new RegataException("Rumbo no válido");
		}else {
			nombre=n;
			posicion=p;
			rumbo=r;
			velocidad=v;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public int getRumbo() {
		return rumbo;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	@Override 
	public boolean equals(Object o) {
		boolean res= o instanceof Barco;
		Barco b=res?(Barco)o:null;
		return res&&nombre.equalsIgnoreCase(b.getNombre());
	}
	public int hashCode() {
		return nombre.toUpperCase().hashCode();
	}
	
	public int compareTo(Barco b) {
		return nombre.compareToIgnoreCase(b.getNombre());
	}
	
	public void avanza(int min) {
		posicion=posicion.posicionTrasRecorrer(min, getRumbo(), getVelocidad());
	}
	
	public String toString() {
		return nombre+": "+posicion.toString()+" R= "+rumbo+" V= "+velocidad;
	}
	
}
