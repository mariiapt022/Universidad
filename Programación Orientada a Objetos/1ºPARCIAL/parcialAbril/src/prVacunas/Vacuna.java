package prVacunas;

public class Vacuna {
	private String codigo;
	private double precio;
	private int cantidad;
	
	public Vacuna(String c, double p, int q) {
		if(p<=0||q<=0) {
			throw new RuntimeException("Cantidad o precio negativo");
		}else {
			codigo=c;
			precio=p;
			cantidad=q;
		}
	}
	
	public Vacuna(String c,double p) {
		this(c,p,1);
		if(p<=0) {
			throw new RuntimeException("Precio negativo");
		}
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setPrecio(double p) {
		if(p<=0) {
			throw new RuntimeException("Precio no válido");
		}else {
			precio=p;
		}
		
	}
	
	public void setCantidad(int q) {
		if(q<=0) {
			throw new RuntimeException("Cantidad no válida");
		}else {
			cantidad=q;
		}
	}
	
	public double precioTotal() {
		double pt=precio*cantidad;
		return pt;
	}
	
	public String toString() {
		return "("+codigo+": "+precio+" "+cantidad+")";
	}
	
	
}
