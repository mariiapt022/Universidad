package prControl16;

public class PruebaObsCorrecion {

	public static void main(String[] args) {
		Correcion b=new Correcion("Roque de los Muchachos",1.00789);
		Correcion c=new Correcion("Manu Kea",0.99222);
		
		Correcion[] corec=new Correcion[2];
		corec[0]=b;
		corec[1]=c;
		
		ObsCorrecion o=new ObsCorrecion(corec);
		o.addObs("Roque de los Muchachos;Rigel;0.13064");
		o.addObs("Mauna Kea;Vega;0.02673");
		o.addObs("Mauna Kea;Rigel;0.13248");
		o.addObs("Roque de los Muchachos;Vega;0.02673");
		
		
		System.out.println(o.toString());
		System.out.println("M'oe(Mauna Kea, Rigel): "+o.getMoe("Mauna Kea", "Rigel"));
		System.out.println("M'oe(Mauna Kea, Vega): "+o.getMoe("Mauna Kea", "Vega"));
		System.out.println("M'oe(Roque de los Muchachos, Rigel): "+o.getMoe("Roque de los Muchachos", "Rigel"));
		System.out.println("M'oe(Roque de los Muchachos, Vega): "+o.getMoe("Roque de los Muchachos", "Vega"));
		System.out.println("M'e(Rigel): "+o.getMe("Rigel"));
		System.out.println("M'e(Vega): "+o.getMe("Vega"));
		
	}

}
