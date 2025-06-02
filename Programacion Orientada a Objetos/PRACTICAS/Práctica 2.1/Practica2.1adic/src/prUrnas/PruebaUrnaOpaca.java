package prUrnas;

public class PruebaUrnaOpaca {

	public static void main(String[] args) {
		Urna urna = new Urna();
		urna.votar(true);
		urna.votar(true);
		urna.votar(true);
		urna.votar(false);
		urna.votar(false);
		System.out.println("Resultado intermedio urna: "+urna.resultado());
		urna.votar(false);
		urna.votar(false);
		System.out.println("Resultado final urna: "+urna.resultado());
		
		UrnaOpaca urnaopaca= new UrnaOpaca();
		urnaopaca.votar(true);
		urnaopaca.votar(true);
		urnaopaca.votar(true);
		urnaopaca.votar(false);
		urnaopaca.votar(false);
		System.out.println("Resultado intermedio urna opaca: "+urnaopaca.resultado());
		urnaopaca.votar(false);
		urnaopaca.votar(false);
		System.out.println("Resultado final urna opaca: "+urnaopaca.resultado());
	}

}
