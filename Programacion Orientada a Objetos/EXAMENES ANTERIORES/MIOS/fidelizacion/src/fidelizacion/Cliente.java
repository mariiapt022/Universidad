package fidelizacion;

public class Cliente {
	private int numero,puntos;
	private double cantidad;
	
	public Cliente(int n) {
		numero=n;
		puntos=0;
		cantidad=0.0;
	}

	public int getNumero() {
		return numero;
	}

	public int getPuntos() {
		return puntos;
	}

	public double getCantidad() {
		return cantidad;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res=o instanceof Cliente;
		Cliente c=res?(Cliente)o:null;
		return res&&numero==c.getNumero();
	}
	public int hashCode() {
		return Integer.hashCode(numero);
	}
	
	public void actualiza(Transaccion tr) {
		puntos+=tr.getPuntos();
		cantidad+=tr.getCantidad();
	}
	
	@Override
	public String toString() {
		return "Cliente [puntos=" + puntos + ", cantidad=" + cantidad + ", numero=" + numero + "]";
	}
	
	
}
