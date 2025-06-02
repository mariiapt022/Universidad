package prSeries;

public class PruebaSerie {

	public static void main(String[] args) throws SerieException {
		Episodio A= new Episodio(1,"Invernalia",51);
		Episodio B= new Episodio(1,"INVERNALIA",51);
		
		System.out.println("Los episodios "+A+" y "+B+(A.equals(B)? " ": " no ")+ "son iguales");
		
		Episodio a=new Episodio(1,"Invernalia",51);
		Episodio b=new Episodio(7,"La última guardia",109);
		Episodio c=new Episodio(2,"Caballero de los siete reinos",56);
		Episodio d=new Episodio(5,"Las campanas",75);
		Episodio e=new Episodio(3,"La larga noche",78);
		Episodio f=new Episodio(4,"Los últimos Starks",73);
		Episodio g=new Episodio(6,"El trono de hierro",76);
		
		Episodio[] capitulos=new Episodio[7];
		capitulos[0]=a;
		capitulos[1]=b;
		capitulos[2]=c;
		capitulos[3]=d;
		capitulos[4]=e;
		capitulos[5]=f;
		capitulos[6]=g;
		
		Serie juegoTronosT8= new Serie("Juego de Tronos",capitulos);
		
		System.out.println(juegoTronosT8.obtenerEpisodio(3));
		
		System.out.println(juegoTronosT8.duracionTotal()+" minutos");
		
		System.out.println(juegoTronosT8);
		

	}

}
