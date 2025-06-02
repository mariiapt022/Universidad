import java.util.SortedMap;
import java.util.TreeMap;

import dados.Estadistica;

public class MainPruebaEstadistica {
    public static void prueba(SortedMap<Integer, Integer> prueba) {
        Estadistica est = new Estadistica(prueba);
        System.out.println(prueba);
        System.out.println("Media = " + est.media());
        System.out.println("Moda = " + est.moda());
        System.out.println("Mediana = "+ est.mediana());
    }
    public static void main(String[] args) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 3);
        map.put(5, 2);
        prueba(map);
        map.put(5, 3);
        prueba(map);
        map.put(4, 1);
        map.put(5, 1);
        prueba(map);
    }
}

