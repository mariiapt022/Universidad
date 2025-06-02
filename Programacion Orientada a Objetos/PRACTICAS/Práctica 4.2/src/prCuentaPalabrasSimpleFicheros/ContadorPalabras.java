package prCuentaPalabrasSimpleFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContadorPalabras {
	private int numPalabras;
	private final static int TAM_INICIAL=10;
	private PalabraEnTexto[] palabras;
	
	public ContadorPalabras() {
		this(TAM_INICIAL);
		numPalabras=0;
	}
	
	public ContadorPalabras(int n) {
		numPalabras=0;
		palabras= new PalabraEnTexto[n];
	}
	
	private int esta(String pal) {
		boolean encontrado=false;
		int i=0;
		while(!encontrado&&i<palabras.length) {
			if(palabras[i]!=null&&pal.toUpperCase().equals(this.palabras[i].palabra)) {
				encontrado=true;
			}else {
				i++;
			}
		}
		return encontrado? i : -1;
	}
	
	protected void incluye(String pal) {
		if(pal!=null) {
			int pos=esta(pal.toUpperCase());
			if(pos==-1) {
				if (palabras.length <= numPalabras) {
	 			   	palabras = Arrays.copyOf(palabras, numPalabras + 1);
	 		   	}  
				palabras[numPalabras]=new PalabraEnTexto(pal.toUpperCase());
				numPalabras++;
			}else {
				palabras[pos].incrementa();
			}
		}
		palabras=Arrays.copyOf(palabras,numPalabras);
	}
	
	private void incluyeTodas(String linea,String del) {
		Scanner sc = new Scanner(linea);
 	   	sc.useDelimiter(del);
 	   	String a;
 	   	while (sc.hasNext()) {
 	   		a = sc.next();
 	   		if (a.length() != 0) {
 	   			incluye(a);
 	   		}
 	   	}
 	   	sc.close();
	}
	
	public void incluyeTodas(String[] texto, String del) {
		for(String linea:texto) {
			incluyeTodas(linea,del);
		}
	}
	
	public void incluyeTodasFichero(String nomFich,String del) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(nomFich));
 	   	leerFichero(sc, del);
	}
	
	private void leerFichero(Scanner sc,String del) {
		while (sc.hasNextLine()) {
 		   incluyeTodas(sc.nextLine(), del);
 	   }
	}
	
	public PalabraEnTexto encuentra(String pal) throws NoSuchElementException{
		int k=esta(pal);
 	   	if (k!=-1) {
 	   		return palabras[k];
 	   	}else{
 		   throw new NoSuchElementException();
 	   	}
	}
	
	@Override
    public String toString() {
 	   	StringBuilder sb = new StringBuilder("[");
 	   	for (int i=0;i<numPalabras;i++) {
 	   		sb.append(palabras[i].toString());
 	   		if (i < numPalabras - 1) {
 	   			sb.append(", ");
 	   		}
 	   	}
 	   	sb.append("]");
 	   	return sb.toString();
    }
	
    public void presentaPalabras(String fichero) throws FileNotFoundException {
 	   	PrintWriter pw = new PrintWriter(fichero);
 	   	presentaPalabras(pw);
    }
    
    public void presentaPalabras(PrintWriter pw) {
 	   	for (int i=0;i<numPalabras;i++) {
 	   		pw.println(palabras[i].toString());
 	   	}
 	   	pw.close();
    }
	
	
}
