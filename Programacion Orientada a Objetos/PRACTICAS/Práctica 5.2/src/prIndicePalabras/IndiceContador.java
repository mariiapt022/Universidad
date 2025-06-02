package prIndicePalabras;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class IndiceContador extends IndiceAbstracto{
	
	private Map<String,Integer> indice;
	
	public IndiceContador() {
  	  super();
  	  indice = new TreeMap<>();
    }
	
	public void resolver(String delimitadores) {
  	  indice.clear();
  	  for (String fr : frases) {
  		  try (Scanner sc = new Scanner(fr)){
  			  sc.useDelimiter(delimitadores);
  			  while(sc.hasNext()) {
  				  String palabra = sc.next().toLowerCase();
  				  agregarPalabra(palabra);
  			  }
  		  }
  	  }
    }
    private void agregarPalabra(String pal) {
  	  int ind = indice.getOrDefault(pal, 0);
  	  indice.put(pal, ind+1);
    }
    
    public void presentarIndice(PrintWriter pw){
  	  for (String pal : indice.keySet()) {
  		  pw.printf("%s\t%d\n", pal, indice.get(pal));
  	  }
    }
	
}
