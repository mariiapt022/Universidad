package prUrnas;

public class PruebaUrna {

	public static void main(String[] args) {
		Urna u= new Urna();
		
		u.votar(true);
		u.votar(true);
		u.votar(true);
		
		u.votar(false);
		u.votar(false);
		
		System.out.println("Resultado intermedio: "+u.resultado());
		u.votar(false);
		u.votar(false);
		System.out.println("Resultado final: "+u.resultado());
		
	}

}
