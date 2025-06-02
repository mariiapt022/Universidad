package videoclub;

import java.io.FileNotFoundException;

public class Mainmio {

	public static void main(String[] args) throws FileNotFoundException {
		
		Videoclub v=new Videoclub("peliculas.txt");
		System.out.println(v.toString());
		System.out.println("Sobre el titulo :Sentido y sensibilidad");
	    Pelicula p = v.pelicula("Sentido y sensibilidad");
	    System.out.println(p);
	    Pelicula[] res=v.peliculasDeActor("Julie Andrews");
	    System.out.println(res.toString());
		

	}

}
