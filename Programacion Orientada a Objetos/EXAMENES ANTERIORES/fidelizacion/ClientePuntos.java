package fidelizacion;

import java.util.Comparator;

/** Orden alternativo. Ordena por puntos. **/
public class ClientePuntos implements Comparator<Cliente> {
	@Override
	public int compare(Cliente o1, Cliente o2) {
		return Integer.compare(o1.getPuntos(), o2.getPuntos());
	}
}

