
public class Solicitante implements Comparable<Solicitante>{
	private String NIF,nombre;
	private double puntos;
	private boolean plaza;
	
	public Solicitante(String NIFs,String n,double p) {
		NIF=NIFs;
		nombre=n;
		puntos=p;
		plaza=false;
	}
	
	public String toString() {
		return NIF+" "+nombre+" "+puntos;
	}
	
	public String getNIF() {
		return NIF;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPuntos() {
		return puntos;
	}
	
	public boolean getTienePlaza() {
		return plaza;
	}
	
	public void setTienePlaza(boolean plazas) {
		plaza=plazas;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Solicitante;
		Solicitante s= res? (Solicitante)o:null;
		return res&&nombre.equalsIgnoreCase(s.getNombre())&&puntos==s.getPuntos();
	}
	
	public int hashCode() {
		return nombre.toUpperCase().hashCode()+Double.hashCode(puntos);
	}
	
	public int compareTo(Solicitante s) {
		int res;
		if(this.puntos<s.puntos) {
			res=1;
		}else if(this.puntos>s.puntos) {
			res=-1;
		}else {
			res=nombre.compareToIgnoreCase(s.getNombre());
		}
		return res;
	}
	
	
	
}
