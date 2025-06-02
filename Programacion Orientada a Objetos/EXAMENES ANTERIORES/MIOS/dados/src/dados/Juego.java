package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class Juego implements Simulacion{
	
	public List<Integer> experimento(int numSim){
		if(numSim<=0) {
			throw new IllegalArgumentException("numSim no valido");
		}
		List<Integer> res=new ArrayList<>();
		for(int i=0;i<numSim;i++) {
			res.add(this.simula());
		}
		
		return res;
	}
	
	public SortedMap<Integer,Integer> agrupa(List<Integer> list){
		SortedMap<Integer,Integer> res=new TreeMap<>();
		
		for(Integer i:list) {
			int reps = res.getOrDefault(i, 0);
			res.put(i, reps+1);
		}
				
		return res;
	}
	
	
	
	
	
	
	
}
