package fidelizacion;

/**
 * Clientes del programa de fidelización
 */
public class Cliente {
	private int puntos; // puntos acumulados por el cliente
	private double cantidad; // cantidad de dinero gastada dentro del programa
	private int numero; // número de identificación del cliente

	// los clientes son creados con puntos y consumo ceros inicialmente
	public Cliente(int n) {
		puntos = 0;
		cantidad = 0.0;
		numero = n;
	}

	@Override
	public String toString() {
		return "Cliente [puntos=" + puntos + ", cantidad=" + cantidad + ", numero=" + numero + "]";
	}

	// actualización de los datos del cliente con una transacción
	public void actualiza(Transaccion tr) {
		puntos += tr.getPuntos();
		cantidad += tr.getCantidad();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	public int getPuntos() {
		return puntos;
	}

	public double getCantidad() {
		return cantidad;
	}

	public int getNumero() {
		return numero;
	}
}
