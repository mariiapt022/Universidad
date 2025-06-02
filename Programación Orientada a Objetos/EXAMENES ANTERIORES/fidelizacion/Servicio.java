package fidelizacion;

/**
 * Servicio ofrecido por una empresa dentro de un programa
 */
public abstract class Servicio {
	abstract Transaccion hazTransaccion(int ca, Fecha fe, int nC);
}
