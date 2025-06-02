import java.util.*;
import java.io.IOException;

public class TestVideoclub {

	public static void main(String[] args) {
		try {      
		  	Videoclub b = new Videoclub("peliculas.txt");
	       
	        System.out.println("Sobre el titulo :Sentido y sensibilidad");
	        Pelicula p = b.pelicula("Sentido y sensibilidad");
	        System.out.println(p);
	        while (b.disponibles(p) > 0) {
	                b.prestar(p);
	                System.out.println("Pelicula Sentido y sensibilidad prestada");
	         }
	        System.out.println("Pelicula Sentido y sensibilidad no disponible");
	      
	        Pelicula p1 = b.pelicula("Sentido y sensibilidad");
	        b.devolver(p1);
	        System.out.println("Pelicula Sentido y sensibilidad devuelta");

	        for (Pelicula ppp : b.peliculasDeActor("Julie Andrews")) {
	        	System.out.println(ppp);
	        	if (b.disponibles(ppp) > 0) {
	        		b.prestar(ppp);
	                System.out.println("Pelicula " + ppp.titulo() + " prestada");
	        	}
	        }

	        VideoclubPorGeneros v
	                = new VideoclubPorGeneros("peliculas.txt", "generos.txt");
	        
	        
	        
	        Set<Pelicula> gen = v.genero("Suspense");
	        if (gen == null) {
	        	System.out.println("No constan pelicukas de ese genero");
	        } else {
	        	System.out.println("Suspense: " + gen);
	        }  
	    /*
		} catch (IOException ioe) {
			System.err.println("Error de E/S: " + ioe.getMessage());
		*/
		} catch (VideoclubException ee) {
			System.err.println(ee.getMessage());
		}    

	}

}
