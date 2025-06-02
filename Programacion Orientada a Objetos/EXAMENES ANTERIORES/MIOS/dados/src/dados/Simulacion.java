package dados;

import java.util.List;
import java.util.SortedMap;

public interface Simulacion {
	public int simula();
	public List<Integer> experimento(int numSim);
	public SortedMap<Integer,Integer> agrupa(List<Integer> list);
}
