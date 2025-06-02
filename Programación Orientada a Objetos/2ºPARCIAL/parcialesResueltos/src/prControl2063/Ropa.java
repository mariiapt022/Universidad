package prControl2063;

public class Ropa {
	private String descripcion;
	private int cantidad;
	private double precio;
	
	public Ropa(String d,int c,double p) throws BazarException{
		if(d==null||c==0||p<0) {
			throw new BazarException();
		}else {
			descripcion=d;
			cantidad=c;
			precio=p;
		}
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setCantidad(int n) throws BazarException{
		if(n<0) {
			throw new BazarException();
		}else {
			cantidad=n;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Ropa;
		Ropa r=res? (Ropa)o:null;
		return res&&descripcion.equalsIgnoreCase(r.getDescripcion());
	}
	
	public int hashCode() {
		return descripcion.toUpperCase().hashCode();
	}
	
	public String toString() {
		return "("+descripcion+", "+cantidad+", "+precio+")";
	}
	
}
