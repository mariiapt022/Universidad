package fidelizacion;

public class Transaccion {
	private double cantidad;
	private int puntos,numCliente;
	private Fecha fecha;
	
	public Transaccion(double c,int p,Fecha f,int n) {
		if(c<0||p<0||n<0) {
			throw new FidelizacionException("Datos erroneos para transaccion");
		}else {
			cantidad=c;
			puntos=p;
			numCliente=n;
			fecha=f;
		}
	}

	public double getCantidad() {
		return cantidad;
	}

	public int getPuntos() {
		return puntos;
	}

	public int getNumCliente() {
		return numCliente;
	}

	public Fecha getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		return "Transaccion [cantidad=" + cantidad + ", puntos=" + puntos + ", fecha=" + fecha + ", cliente="
				+ numCliente + "]";
	}
	
}
