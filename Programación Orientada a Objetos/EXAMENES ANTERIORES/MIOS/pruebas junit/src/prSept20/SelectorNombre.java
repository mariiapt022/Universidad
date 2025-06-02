package prSept20;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SelectorNombre implements Selector{
	
	private SortedSet<String> nombres;
	
	public SelectorNombre(Set<String> n) {
		
		if(n==null) {
			throw new AppException("Conjunto de nombres nulo");
		}
		
		nombres=new TreeSet<>();
		for(String s:n) {
			nombres.add(s.toUpperCase());
		}
		
	}
	
	
	public SortedSet<String> getNombres(){
		return nombres;
	}
	
	
	@Override
	public boolean esSeleccionable(Set<Practica> s) {
		boolean ok = false;
		if ( ! s.isEmpty() ) {
			ok = this.getNombres().contains(s.iterator().next().getNombre().toUpperCase());
		}
		return ok;
	}
	
}
