package prComercio;

public class Herramienta {
	private int cantidad;
	private double precio;
	private String descripcion;
	
	public Herramienta(String d, int c, double p) {
		descripcion= d;
		cantidad=c;
		precio=p;
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
	
	public void setPrecio(double x) throws ComercioException{
		if(x<0) {
			throw new ComercioException("Precio negativo no válido");
		}else{
			precio=x;
		}
		
	}
	
	public String toString() {
		return "("+getDescripcion()+"; "+getCantidad()+"; "+getPrecio()+")";
	}
	
	public boolean igual(Herramienta h) {
		return this.getDescripcion().equalsIgnoreCase(h.getDescripcion());
	}
}
