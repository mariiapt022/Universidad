package dados;

import java.util.Set;

public class JuegoB extends Juego {
	private int numDados;
	private int numSeises;
	
	public JuegoB(int dados, int seises) {
		if (dados <= 0) 
			throw new IllegalArgumentException("El número de dados del cubilete debe ser mayor que 0");
		if (seises < 0)
			throw new IllegalArgumentException("El número de seises no puede ser negativo");
		numDados = dados;
		numSeises = seises;
	}
	
	public int simula() {
		Cubilete cubilete = new Cubilete(numDados);
		int nroSeisesTirada = 0;
		int nroTiradas = 0;
		while (nroSeisesTirada < numSeises) { 
			Set<Dado> tirada = cubilete.tira();
			//System.out.println(tirada);
			for(Dado d : tirada)
				if (d.getCara() == 6) nroSeisesTirada++;
			nroTiradas++;
		}
		return nroTiradas;
	}
}
