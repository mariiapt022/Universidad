package prControl16;

public class PruebaObservaciones {

	public static void main(String[] args) {
		Observaciones a=new Observaciones();
		a.addObs("Roque de los Muchachos;Rigel;0.13064");
		a.addObs("Mauna Kea;Vega;0.02673");
		a.addObs("Mauna Kea;Rigel;0.13248");
		a.addObs("Roque de los Muchachos;Vega;0.02627");
		
		System.out.println(a.toString());
		System.out.println("Moe(Mauna Kea, Rigel): "+a.getMoe("Mauna Kea", "Rigel"));
		System.out.println("Moe(Mauna Kea, Vega): "+a.getMoe("Mauna Kea", "Vega"));
		System.out.println("Moe(Roque de los Muchachos, Rigel): "+a.getMoe("Roque de los Muchachos", "Rigel"));
		System.out.println("Moe(Roque de los Muchachos, Vega): "+a.getMoe("Roque de los Muchachos", "Vega"));
		System.out.println("Me(Rigel): "+a.getMe("Rigel"));
		System.out.println("Me(Vega): "+a.getMe("Vega"));
		
	}

}
