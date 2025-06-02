import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class VideoclubPorGeneros extends Videoclub{
	
	public static enum Genero{Drama,Infantil,Suspense};
	SortedMap<Genero,SortedSet<Pelicula>> peliculas=new TreeMap<Genero,SortedSet<Pelicula>>();
	
	public VideoclubPorGeneros(String p,String generos) {
		super(p);
		try {
			Scanner sc=new Scanner(new File(generos));
			sc.useDelimiter(":");
			String linea=sc.nextLine();
			while(linea!=null) {
				String gen=sc.next();
				String pel=sc.next();
				añadir(gen, pel);
				linea=sc.nextLine();
			}
			sc.close();
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Fichero no encontrado");
		}catch(NoSuchElementException e) {
			throw new RuntimeException("Error en el formato de la linea");
		}
	}
	
	public void añadir(String g,String t) {
		Genero gen;
		try {
			gen = Genero.valueOf(g);
		} catch(IllegalArgumentException e) {
			throw new RuntimeException("ERROR: No existe el género");
		}
		
		Pelicula p= pelicula(t);
		if (p == null) {
			throw new RuntimeException("ERROR: No existe la película");	
		}
		
		SortedSet<Pelicula> pelis = peliculas.get(gen);
		if (pelis == null){
			pelis = new TreeSet<Pelicula>();
			peliculas.put(gen, pelis);
		}
		pelis.add(p);
		peliculas.put(gen, pelis);
	}
	
	public Set<Pelicula> genero(String g){
		Genero gen = Genero.valueOf(g);
		return peliculas.get(gen);
	}
	
	
}
