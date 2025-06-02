package practicas;

import java.util.Set;

public class SelectorUmbralExito implements Selector {
	private final int porcMinimo;
	public SelectorUmbralExito(int pm) {
		if (pm < 0) {
			throw new AppException("Porcentaje minimo negativo");
		}
		porcMinimo = pm;
	}
	public int getPorcMinimo() {
		return porcMinimo;
	}
	@Override
	public boolean esSeleccionable(Set<Practica> s) {
		int sumaCntRealizadas = 0;
		int sumaCntExito = 0;
		for (Practica x : s) {
			sumaCntRealizadas += x.getCntRealizadas();
			sumaCntExito += x.getCntExito();
		}
		int p = 0;
		if (sumaCntRealizadas > 0) {
			p = 100 * sumaCntExito / sumaCntRealizadas;
		}
		return p >= this.getPorcMinimo();
	}
}
