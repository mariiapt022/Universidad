package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeSet;


public class Estadistica {
	private SortedMap<Integer,Integer> experimentos;
	
	public Estadistica(SortedMap<Integer,Integer> expers) {
		experimentos = expers;
	}
	
	public double media() {
		double totalTiradas = 0;
		double totalSimulaciones = 0;
		for (Map.Entry<Integer, Integer> entrada : experimentos.entrySet()) {
			totalTiradas += entrada.getKey() * entrada.getValue();
			totalSimulaciones += entrada.getValue();
		}
		return totalTiradas / totalSimulaciones;
	}
	
	public Set<Integer> moda() {
		Set<Integer> moda = new TreeSet<>();
		int maxTiradas = (new TreeSet<Integer>(experimentos.values())).last();
		for(Integer i : experimentos.keySet()) {
			if (experimentos.get(i) == maxTiradas) moda.add(i);
		}
		return moda;
	}
	
	public int mediana() {
		List<Integer> lista = new ArrayList<>();
		for (int i : experimentos.keySet()) {
			for (int j = 1; j <= experimentos.get(i); j++)
				lista.add(i);
		}
		int pos = lista.size()%2 == 0 ? lista.size()/2-1 : (lista.size()-1)/2;
		return lista.get(pos);
	}
}

