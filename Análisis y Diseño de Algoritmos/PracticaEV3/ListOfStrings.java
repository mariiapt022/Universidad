import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pepe Gallardo
 *
 * Clase para representar una lista de cadenas de caracteres.
 * Se puede acceder a todos sus elementos con un bucle "for each"
 */
public class ListOfStrings implements Iterable<String> {

	private List<String> ls;
	
	/**
	 * Crea una lista de cadenas vac�a, es decir, con cero cadenas
	 */
	public ListOfStrings() {
		ls = new LinkedList<String>();
	}
			
	/**
	 * A�ade una cadena a la lista de cadenas
	 * @param s : cadena a a�adir
	 * @return  : la lista modificada (con la nueva cadena a�adida) 
	 */
	public ListOfStrings add(String s) {
		ls.add(s);
		return this;
	}
	
	/** 
	 * A�ade a todas las cadenas en la lista el caracter @x como sufijo
	 * @param x : caracter a a�adir como prefijo
	 * @return  : devuelve la lista modificada
	 */
	public ListOfStrings suffixAll(char x){
		for (int p=0; p<ls.size(); p++) {
			String s = ls.get(p);
			s = s+x;
			ls.set(p,s);
		}	
		return this;
	}

	
	/**
	 * A�ade a la lista de cadenas todas las cadenas de la lista @ls2 
	 * @param ls2 : lista de cadenas a a�adir
	 * @return    : la lista con las cadenas ya a�adidas
	 */
	public ListOfStrings addAll(ListOfStrings ls2) {
		ls.addAll(ls2.ls);
		return this;
	}	
	

	/**
	 * @param ls2 : una lista de cadenas
	 * @return    : true si todas las cadenas de @ls2 est�n en la lista
	 */
	public boolean containsAll(ListOfStrings ls2) {
		return ls.containsAll(ls2.ls);
	}
	
	/**
	 * Elimina las cadenas de @ls2 de la lista
	 * @param ls2 : una lista de cadenas
	 * @return : true si la lista original cambia
	 */
	public boolean removeAll(ListOfStrings ls2) {
		return ls.removeAll(ls2.ls);
	}
	
	
	/**
	 * @return : el n�mero de elementos de la lista
	 */
	public int size(){
		return ls.size();
	}
	
	/**
	 * @param s : una cadena 
	 * @return  : true si la cadena @s est� en la lista 
	 */
	public boolean contains(String s){
		return ls.contains(s);
	}
	
	public String toString() {
		String s = "{";
		int last = ls.size()-1;
		for (int i=0; i<last; i++)
			s += Utils.entreComillas(ls.get(i))+",";
		if (last>=0) 
			s += Utils.entreComillas(ls.get(last));
		s +="}";
		return s;
	}	
	
	public Iterator<String> iterator() {
		return ls.iterator(); 
	}
	
}
