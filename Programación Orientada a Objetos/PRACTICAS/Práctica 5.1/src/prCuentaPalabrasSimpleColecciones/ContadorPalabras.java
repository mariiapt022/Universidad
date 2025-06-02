package prCuentaPalabrasSimpleColecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.TreeSet;

public class ContadorPalabras {
	
	private Collection<PalabraEnTexto> palabras;
	
	public ContadorPalabras() {
		palabras = new TreeSet<>();
	}
	
	protected void incluye(String pal) {
		PalabraEnTexto a = new PalabraEnTexto(pal);
		try {
			encuentra(pal).incrementa();
		}catch(NoSuchElementException ee) {
			palabras.add(a);
		}
	}
	
	public PalabraEnTexto encuentra(String pal) throws NoSuchElementException{
		PalabraEnTexto a = new PalabraEnTexto(pal);
    	for (PalabraEnTexto b : palabras) {
    		if (a.compareTo(b)==0) {
    			return b;
    		}
    	}
    	throw new NoSuchElementException ("No existe la palabra " + pal);		
	}
	
	private void incluyeTodas(String linea,String del) {
		Scanner sc = new Scanner(linea);
		sc.useDelimiter(del);
		while (sc.hasNext()) {
			incluye(sc.next());
		}
		sc.close();
	}
	
	public void incluyeTodas(String[] texto,String del) {
		for(String linea:texto) {
			incluyeTodas(linea,del);
		}
	}
	
	public void incluyeTodasFichero(String nomFich,String del) throws FileNotFoundException {
		Scanner sc=new Scanner(new File(nomFich));
		leerFichero(sc, del);
	}
	
	private void leerFichero(Scanner sc,String del) {
		while (sc.hasNext()) {
    		incluyeTodas(sc.next(), del);
    	}
	}
	
	public void presentaPalabras(String fichero) throws FileNotFoundException {
    	PrintWriter pw = new PrintWriter(fichero);
        presentaPalabras(pw);
        pw.close();
    }
    
    public void presentaPalabras(PrintWriter pw) {
    	for (PalabraEnTexto pal : palabras) {
    		pw.println(pal);
    	}
    }
    
    @Override
    public String toString() {
    	StringJoiner sj = new StringJoiner(", ","[","]");
    	for (PalabraEnTexto pal : palabras) {
    		sj.add(pal.toString());
    	}
    	return sj.toString();
    }
	
	
	
	
	
	
	
	
	
	
}
