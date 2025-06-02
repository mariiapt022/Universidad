package dados;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cubilete {
	private List<Dado> dados;
	
	public Cubilete(int nroDados) {
		if (nroDados <= 0) throw new IllegalArgumentException("El número de dados debe ser postiivo");
		dados = new ArrayList<>();
		for (int i = 0; i<nroDados; i++)
			dados.add(new Dado());
	}
	
	public Set<Dado> tira() {
		Set<Dado> res = new HashSet<>();
		for (Dado d : dados) {
			d.agita();
			res.add(d);
		}
		return res;
	}
}
