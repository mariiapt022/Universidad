package fidelizacion;

/**
 * Transacción dentro del programa. Representa una transacción por una cantidad
 * de euros que se corresponde por una cantidad de puntos según el servicio en
 * cuestión a través del que se consiguen.
 */
public class Transaccion {
	private double cantidad; // cantidad de dinero de la transacción
	private int puntos; // puntos de la transacción
	private Fecha fecha; // fecha de realización de la transacción
	private int numCliente; // cliente que ha realizado la transacción

	public Transaccion(double ca, int pu, Fecha fe, int nC) {
		if (ca < 0)
			throw new FidelizacionException("cantidad no válida");
		if (pu < 0)
			throw new FidelizacionException("número de puntos no válido");
		cantidad = ca;
		puntos = pu;
		fecha = fe;
		numCliente = nC;
	}

	public double getCantidad() {
		return cantidad;
	}

	public int getPuntos() {
		return puntos;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public int getCliente() {
		return numCliente;
	}

	@Override
	public String toString() {
		return "Transaccion [cantidad=" + cantidad + ", puntos=" + puntos + ", fecha=" + fecha + ", cliente="
				+ numCliente + "]";
	}
}
