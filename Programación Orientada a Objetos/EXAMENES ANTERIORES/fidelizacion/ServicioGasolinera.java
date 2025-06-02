package fidelizacion;

/**
 * 1 punto por cada 20€ de compra
 */
public class ServicioGasolinera extends Servicio {
	public Transaccion hazTransaccion(int ca, Fecha fe, int nC) {
		return new Transaccion(ca, ca / 20, fe, nC);
	}
}
