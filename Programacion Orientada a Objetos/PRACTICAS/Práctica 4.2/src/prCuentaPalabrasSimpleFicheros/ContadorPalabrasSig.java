package prCuentaPalabrasSimpleFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContadorPalabrasSig extends ContadorPalabras{
	private String[] noSignificativas;
	private final static int TAM=10;
	private int numPalNoSig;
	
	public ContadorPalabrasSig(String[] palsNS) {
		super();
		noSignificativas=palsNS;
		numPalNoSig=noSignificativas.length;
	}
	
	public ContadorPalabrasSig(int n,String[] palsNS) {
		super(n);
		noSignificativas=palsNS;
		numPalNoSig=noSignificativas.length;
	}
	
	public ContadorPalabrasSig(String filNoSig,String del) throws FileNotFoundException{
		super();
 	   	noSignificativas = new String[TAM];
 	   	numPalNoSig = 0;
 	   	leerFicheroNoSig(filNoSig, del);
	}
	
	public ContadorPalabrasSig(int n, String filNoSig, String del) throws FileNotFoundException {
 	   	super(n);
 	   	noSignificativas = new String[TAM];
 	   	numPalNoSig = 0;
 	   	leerFicheroNoSig(filNoSig, del);
    }
	
	private void leerFicheroNoSig(String filNoSig, String del) throws FileNotFoundException {
 	   	Scanner sc = new Scanner (new File(filNoSig));
 	   	leerPalabrasNoSignificativas(sc,del);
    }
	
	private void leerPalabrasNoSignificativas(Scanner sc, String del) throws FileNotFoundException {
 	   	while (sc.hasNextLine()) {
 	   		leerFicheroNoSig(sc.nextLine(),del);
 	   	}
 	   	sc.close();
    }
	
	protected void incluye (String pal) {
 	   	int pos=esta2(pal);
		if (pos==-1) {
 	   		super.incluye(pal);
 	   	}
    }
	
    private int esta2(String pal) {
		boolean encontrado=false;
		int i=0;
		while(!encontrado&&i<numPalNoSig) {
			if(noSignificativas[i]!=null&&noSignificativas[i].equalsIgnoreCase(pal)) {
				encontrado=true;
			}else {
				i++;
			}
		}
		return encontrado? i : -1;
	}
	
	
	
	
	
	
}
