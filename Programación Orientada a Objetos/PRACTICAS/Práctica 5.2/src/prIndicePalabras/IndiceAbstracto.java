package prIndicePalabras;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class IndiceAbstracto implements Indice{
	protected List<String> frases;
	
	public IndiceAbstracto() {
		frases= new ArrayList<>();
	}
	
	public void agregarFrase(String frase) {
  	  frases.add(frase);
    }
    
    public void presentarIndiceConsola() {
  	  presentarIndice(new PrintWriter(System.out,true));
    }  
	
}
