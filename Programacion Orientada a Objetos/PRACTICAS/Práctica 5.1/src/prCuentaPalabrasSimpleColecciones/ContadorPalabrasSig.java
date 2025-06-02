package prCuentaPalabrasSimpleColecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContadorPalabrasSig extends ContadorPalabras{
	private Set<String> noSignificativas;
	
	public ContadorPalabrasSig(Collection<String> palsNS) {
		super();
   	 	noSignificativas = new HashSet<>();
   	 	for(String p : palsNS) {
   	 		noSignificativas.add(p.toUpperCase());
   	 	} 
	}
	
	public ContadorPalabrasSig(String fichNoSig, String del) throws FileNotFoundException {
   	 	super();
   	 	noSignificativas = new HashSet<>();
   	 	try {
   	 		leerFicheroNoSig(fichNoSig, del);
   	 	} catch (FileNotFoundException e) {
   	 		e.getMessage();
   	 	}
    }
	
    private void leerFicheroNoSig(String filNoSig, String del) throws FileNotFoundException{
   	 	try {
   	 		Scanner sc = new Scanner(new File(filNoSig));
   	 		leerPalabrasNoSignificativas(sc, del);
   	 	} catch (IOException e) {
   	 		throw new FileNotFoundException();
   	 	}
    }
    
    private void leerPalabrasNoSignificativas(Scanner sc, String del) {
    	sc.useDelimiter(del);
    	while (sc.hasNext()) {
    		leerPalabrasNoSignificativas(sc.next(), del);
    	}
    }
    
    private void leerPalabrasNoSignificativas (String palsNS, String del) {
   	 	try (Scanner sc = new Scanner(palsNS)) {
   	 		while (sc.hasNext()) {
   	 			noSignificativas.add(sc.next().toUpperCase());
   	 		}
   	 	}
    }
    
    protected void incluye(String pal) {
    	if (!noSignificativas.contains(pal.toUpperCase())) {
    		super.incluye(pal);
    	}
    }
	
	
	
}
