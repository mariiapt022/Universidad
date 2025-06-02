package dados;

import java.util.List;
import java.util.SortedMap;

public interface Simulacion {
	int simula();
	
	List<Integer> experimento(int numSim);
	
	SortedMap<Integer,Integer> agrupa(List<Integer> list);
}
