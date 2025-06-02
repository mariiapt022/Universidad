package dados;

import java.util.Set;

public class JuegoA extends Juego {
	private int numDados;
	private int sumaBuscada;
	
	public JuegoA (int dados, int sum) {
		if (dados <= 0) 
			throw new IllegalArgumentException("El número de dados del cubilete debe ser mayor que cero");
		if (sum < dados || sum > 6*dados)
			throw new IllegalArgumentException("La suma debe estar entre " + dados + " y " + 6*dados);
		numDados = dados;
		sumaBuscada = sum;
	}
	
	public int simula() {
		Cubilete cubilete = new Cubilete(numDados);
		int sumaTirada = 0;
		int nroTiradas = 0;
		while (sumaTirada != sumaBuscada) { 
			sumaTirada=0;
			Set<Dado> tirada = cubilete.tira();
			//.out.println(tirada);
			for(Dado d : tirada)
				sumaTirada += d.getCara();
			nroTiradas++;
		}
		return nroTiradas;
	}
}

