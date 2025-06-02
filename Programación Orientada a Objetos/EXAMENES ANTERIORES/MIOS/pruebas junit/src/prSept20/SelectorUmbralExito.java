package prSept20;

import java.util.Set;

public class SelectorUmbralExito implements Selector{
	
	private int porcMinimo;
	
	public SelectorUmbralExito(int p) {
		porcMinimo=p;
	}
	
	public int getPorcMinimo() {
		return porcMinimo;
	}
	
	@Override
	public boolean esSeleccionable(Set<Practica> s) {
		int sumae=0,sumar=0;
		for(Practica x:s) {
			sumae=sumae+x.getCntExito();
			sumar=sumar+x.getCntRealizadas();
		}
		
		double res;
		if(sumar==0) {
			res=0;
		}else {
			res=(100*sumae)/sumar;
		}
		
		return res>=this.getPorcMinimo();
		
	}
	
}
