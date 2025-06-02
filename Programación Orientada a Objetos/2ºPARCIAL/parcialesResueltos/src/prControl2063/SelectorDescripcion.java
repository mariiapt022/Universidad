package prControl2063;

import java.util.Arrays;

public class SelectorDescripcion implements Selector{
	private String[] descripciones;
	
	public SelectorDescripcion(String[] d) throws BazarException{
		if(d!=null) {
			descripciones=d;
		}else {
			throw new BazarException();
		}
	}
	
	private boolean buscarRopa(Ropa r) {
		int i=0;
		boolean encontrado=false;
		while(i<descripciones.length&&!encontrado) {
			if(descripciones[i]!=null&&descripciones[i].equalsIgnoreCase(r.getDescripcion())) {
				encontrado=true;
			}else {
				i++;
			}
		}
		return encontrado;
	}
	
	
	@Override
	public boolean esSeleccionable(Ropa r) {
		return buscarRopa(r);
	}
	
	public String toString() {
		return "S"+Arrays.toString(descripciones);
	}
	
}
