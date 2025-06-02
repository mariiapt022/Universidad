package dados;

public class MainPruebaJuegos {

	public static void main(String[] args) {
		Juego jA = new JuegoA(2,7);
		System.out.println(jA.simula());
		
		Juego jB = new JuegoB(3,4);
		System.out.println(jB.simula());

	}

}
