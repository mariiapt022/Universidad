package prVotacion;

public class PruebaUrnaExc {

	public static void main(String[] args) {
		UrnaExc U= new UrnaExc();
		
		U.votar(false);
		U.votar(false);
		U.votar(true);
		U.votar(true);
		U.votar(true);
		
		U.cerrarVotacion();
		U.votar(false);
		
		System.out.println(U.resultado());
		
		
	}

}
