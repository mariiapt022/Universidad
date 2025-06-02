package fidelizacion;

import java.util.Comparator;

/** Orden alternativo. Ordena por cantidad. **/
public class ClienteCantidad implements Comparator<Cliente> {
	@Override
	public int compare(Cliente o1, Cliente o2) {
		return Double.compare(o1.getCantidad(), o2.getCantidad());
	}
}
