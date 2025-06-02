package videoclub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Videoclub {
	protected Pelicula[] disponibles= new Pelicula[10];
	private int numDisponibles;
	
	public Videoclub(String a) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(a));
		leerFichero(sc);
		numDisponibles=0;
	}
	
	private void leerFichero(Scanner sc) throws FileNotFoundException{
		
		String titulo,codigo,act;
		String[] actores = new String[10];
		int año,numCopias;
		System.out.println("Hola");
		try (sc) {
			sc.useDelimiter("[%]");
			sc.useLocale(Locale.ENGLISH);
			while(sc.hasNext()) {
				titulo = sc.next();
				
  	  			act=sc.next();
  	  			
  	  			codigo = sc.next();
  	  	
  	  			año = sc.nextInt();
  	  		
  	  			numCopias=sc.nextInt();
  	  		
  	  			Scanner ac=new Scanner(act);
  	  			
  	  			ac.useDelimiter("[,]");
				ac.useLocale(Locale.ENGLISH);
  	  			try(ac){
  	  				int numActores=0;
  	  				while(ac.hasNext()) {
  	  					String actor=ac.next();
  	  					if(numActores==actores.length) {
  	  						actores=Arrays.copyOf(actores, numActores*2);
  	  					}
  	  					actores[numActores]=actor;
  	  					numActores++;
  	  				
  	  				}
  	  				
  	  				actores=Arrays.copyOf(actores, numActores);
  	  			}
  	  			Pelicula p = new Pelicula(titulo,actores,año,codigo);
  	  			disponibles[numDisponibles] = p;
  	  			numDisponibles++;
			}
  	  			
		}
	}
	
	public Pelicula pelicula(String titulo) {
		int i=0;
		boolean encontrado=false;
		Pelicula res = null;
		while(i<numDisponibles&&!encontrado) {
			if(disponibles[i]!=null&&disponibles[i].getTitulo().equalsIgnoreCase(titulo)) {
				encontrado=true;
				res=disponibles[i];
			}else {
				i++;
			}
		}
		return res;
	}
	
	private boolean estaActor(String[] actores,String actor) {
		boolean encontrado=false;
		int i=0;
		while(i<actores.length&&!encontrado) {
			if(actores[i].equalsIgnoreCase(actor)) {
				encontrado=true;
			}
		}
		return encontrado;
	}
	
	public Pelicula[] peliculasDeActor(String actor) {
		Pelicula[] res=new Pelicula[10];
		int i=0,n=0;
		while(i<numDisponibles) {
			if(estaActor(disponibles[i].getActores(),actor)) {
				if(n==res.length) {
					res=Arrays.copyOf(res, n+1);
				}
				res[n]=disponibles[i];
				n++;
			}
		}
		res=Arrays.copyOf(res, n);
		return res;
	}
	
	public String toString() {
		String res=null;
		for(int i=0;i<numDisponibles;i++) {
			res=res+disponibles[i].toString();
		}
		return res;
	}
	
	
}
