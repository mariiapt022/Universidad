package dados;

import java.util.SortedMap;

public class Main {

	public static void main(String[] args) {
		JuegoA jA = new JuegoA(1,6);
		SortedMap<Integer,Integer> experimentos = jA.agrupa(jA.experimento(30));
		System.out.println(experimentos);
		Estadistica est = new Estadistica(experimentos);
		System.out.println("Media = " + est.media());
        System.out.println("Moda = " + est.moda());
        System.out.println("Mediana = "+ est.mediana());
        
		JuegoB jB = new JuegoB(3,2);
		experimentos = jB.agrupa(jB.experimento(30));
		System.out.println(experimentos);
		est = new Estadistica(experimentos);
		System.out.println("Media = " + est.media());
        System.out.println("Moda = " + est.moda());
        System.out.println("Mediana = "+ est.mediana());

	}

}
