package prIndicePalabras;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndiceLineas extends IndiceAbstracto{
	private Map<String,Set<Integer>> indice;
    
    public IndiceLineas() {
   	 super();
   	 indice = new TreeMap<>();
    }
    
    public void resolver(String delimitadores) {
   	 indice.clear();
   	 int k=1;
   	 for (String fr : frases) {
   		 try (Scanner sc = new Scanner(fr)){
   			 sc.useDelimiter(delimitadores);
   			 while(sc.hasNext()) {
   				 String palabra = sc.next().toLowerCase();
   				 agregarPalabra(palabra,k);
   			 }
   		 }
   		 k++;
   	 }
    }
    
    private void agregarPalabra(String pal, int k) {
   	 SortedSet<Integer> ss = (SortedSet<Integer>) indice.getOrDefault(pal, new TreeSet<>());
   	 ss.add(k);
   	 indice.put(pal, ss);
    }
    
    public void presentarIndice(PrintWriter pw) {
   	 for (String pal : indice.keySet()) {
   		pw.printf("%-15s", pal);
   		pw.println("\t" + indice.get(pal));
   	 }
    }
}
