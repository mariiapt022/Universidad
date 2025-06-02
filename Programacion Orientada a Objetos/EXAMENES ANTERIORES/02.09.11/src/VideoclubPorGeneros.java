import java.util.*;
import java.io.*;

public class VideoclubPorGeneros extends Videoclub {
	
	public static enum Genero{Drama,Infantil,Suspense};

	// Atributos .....................................
	
	SortedMap<Genero,SortedSet<Pelicula>> peliculas;
	
	// Constructor ...................................
	
	public VideoclubPorGeneros(String file1, String file2){
		// Generar las estructuras heredadas
		super(file1);
		// Generar la nueva estructura
		peliculas = new TreeMap<Genero,SortedSet<Pelicula>>();
		try{
			BufferedReader br = new BufferedReader(
									new FileReader(file2));
			String linea = br.readLine();
			while (linea != null) {
				StringTokenizer stk = new StringTokenizer(linea,":");
				añadir(stk.nextToken(),stk.nextToken());
				linea = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			throw new VideoclubException(
						"ERROR: No se encuentra el fichero");
		} catch (IOException e) {
			throw new VideoclubException(
						"ERROR: no se puede leer/cerrar el fichero");
		} catch (NoSuchElementException e) {
			throw new VideoclubException(
						"ERROR en el formato de la línea");
		}
	}
	
	// Métodos .......................................
	
	// Método para añadir una película a un género cinematográfico
	
	public void añadir(String genero, String titulo){
		Genero gen;
		try {
			gen = Genero.valueOf(genero);
		} catch(IllegalArgumentException e) {
			throw new VideoclubException(
						"ERROR: No existe el género");
		}
		Pelicula p = pelicula(titulo);
		if (p == null) {
			throw new VideoclubException(
						"ERROR: No existe la película");	
		}
		SortedSet<Pelicula> pelis = peliculas.get(gen);
		if (pelis == null){
			pelis = new TreeSet<Pelicula>();
			peliculas.put(gen, pelis);
		}
		pelis.add(p);
		peliculas.put(gen, pelis);
	}
	
	
	// Método para consultar las películas de un determinado género
	
	public Set<Pelicula> genero(String g){
		Genero gen = Genero.valueOf(g);
		// puede lanzar una IllegalArgumentException
		return peliculas.get(gen);
	}
	
	
}
