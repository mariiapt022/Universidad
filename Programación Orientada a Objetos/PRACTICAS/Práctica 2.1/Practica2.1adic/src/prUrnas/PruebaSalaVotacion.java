package prUrnas;

public class PruebaSalaVotacion {

	public static void main(String[] args) {
		
		SalaVotacion sala= new SalaVotacion();
		
		sala.votar(1, false);
		System.out.println("Resultado intermedio 1: "+sala.resultado(1));
		sala.votar(1, true);
		sala.votar(1, true);
		System.out.println("Resultado final 1: "+sala.resultado(1));
		
		sala.votar(2, true);
		System.out.println("Resultado intermedio 2: "+sala.resultado(2));
		sala.votar(2, false);
		sala.votar(2, false);
		System.out.println("Resultado final 2: "+sala.resultado(2));
	}

}
