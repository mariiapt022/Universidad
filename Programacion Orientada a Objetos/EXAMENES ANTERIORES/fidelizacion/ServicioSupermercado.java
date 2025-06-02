package fidelizacion;

/**
 * 5 puntos por compras superiores a 25 €
 */
public class ServicioSupermercado extends Servicio {
	public Transaccion hazTransaccion(int ca, Fecha fe, int nC) {
		return (ca > 25) ? new Transaccion(ca, 5, fe, nC) : null;
	}
}
