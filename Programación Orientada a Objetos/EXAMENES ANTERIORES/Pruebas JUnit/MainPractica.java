import practicas.Practica;
import java.util.*;

public class MainPractica {
	public static void main(String[] args) {
		Practica practica1 = new Practica("Pepe", "pr1", 20, 15);
		Practica practica2 = new Practica("pepe", "PR1", 22, 10);
		Practica practica3 = new Practica("paco", "pr3", 25, 12);
		Practica practica4 = new Practica("paco", "pr4", 30, 17);
		System.out.println(practica1.equals(practica2) ? "iguales" : "distintas");
		System.out.println(practica2.equals(practica3) ? "iguales" : "distintas");
		System.out.println(practica3.equals(practica4) ? "iguales" : "distintas");
		practica1.setCntExito(18);
		practica3.setCntRealizadas(40);
		SortedSet<Practica> conjunto = new TreeSet<>();
		conjunto.add(practica1);
		conjunto.add(practica2);
		conjunto.add(practica3);
		conjunto.add(practica4);
		System.out.println(conjunto);
	}
}
