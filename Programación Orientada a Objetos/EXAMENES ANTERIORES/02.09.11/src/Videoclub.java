import java.util.*;
import java.io.*;

public class Videoclub {

	// Atributos ..........................................
	
	 SortedMap<Pelicula, Integer> disponibles;
	 SortedMap<Pelicula, Integer> prestadas;
	 
	// Constructores ......................................
	 
	 Videoclub() {
		 disponibles = new TreeMap<Pelicula, Integer>();
		 prestadas = new TreeMap<Pelicula, Integer>();
	 }
	
	 public Videoclub(String file) {
		 this();
		 try {
			 BufferedReader br = new BufferedReader(
					 				new FileReader(file));
			 leerFuente(br);
			 br.close();
		 } catch(FileNotFoundException e) {
			 throw new VideoclubException(
					 "ERROR: no se encuentra el fichero");
		 } catch(IOException e) {
			 throw new VideoclubException(
					 "ERROR cerrando el fichero");
		 }
	 }
	 
	 private void leerFuente(BufferedReader br) {
		 try{
			 String linea = br.readLine();
			 while (linea != null) {
				 // Extraer datos de la línea
				 StringTokenizer stk = 
					 			new StringTokenizer(linea,"%");
				 String titulo = stk.nextToken();
				 String elenco = stk.nextToken();
				 String codigo = stk.nextToken();
				 int año = Integer.parseInt(stk.nextToken());
				 int copias = Integer.parseInt(stk.nextToken());
				 StringTokenizer act =
					   			new StringTokenizer(elenco,",");
				 Set<String> actores = new HashSet<String>();
				 while (act.hasMoreTokens()) {
					 actores.add(act.nextToken());
				 }
				 // Agregar película
				 añadir(new Pelicula(titulo,actores,codigo,año), 
						 copias);
				 // Leer una nueva línea
				 linea = br.readLine();
			 }
		 } catch(IOException e){
			 throw new VideoclubException(
					 "ERROR de lectura");
		 } catch(NoSuchElementException e){
			 throw new VideoclubException(
					 "ERROR faltan datos en la línea");
		 } catch(NumberFormatException e) {
			 throw new VideoclubException(
					 "ERROR de formato en la lectura");
		 }
		 
	 }
	 
	// Métodos ............................................
	
	 // Método para añadir copias de una película
	public void añadir(Pelicula p, int copias) {
		if (copias < 1) {
			throw new VideoclubException(
					"ERROR no hay copias para añadir");
		}
		Integer stock = disponibles.get(p);
		if (stock == null) {
			stock = 0;
		}
		stock = stock + copias;
		disponibles.put(p, stock);
	}
	
	// Método para consultar el número de copias disponibles
	public int disponibles(Pelicula p){
		return disponibles.get(p);
	}
	
	// Método para consultar un título
	public Pelicula pelicula(String titulo){
		Pelicula res = null;
		Iterator<Pelicula> it = disponibles.keySet().iterator();
		while(res == null && it.hasNext()){
			Pelicula pel = it.next();
			if (titulo.equalsIgnoreCase(pel.titulo)){
				res = pel;
			}
		}
		return res;
	}
	
	// Método para consultar las películas en las que actúa un
	// determinado actor
	public Set<Pelicula> peliculasDeActor(String actor){
		Set<Pelicula> peliculas = new TreeSet<Pelicula>();
		for (Pelicula p : disponibles.keySet()) {
			for (String nom : p.actores){
				if (actor.equalsIgnoreCase(nom)){
					peliculas.add(p);
				}
			}
		}
		return peliculas;
	}
	
	// Métodos para prestar y para devolver películas
	public void prestar(Pelicula p) {
		Integer stock = disponibles.get(p);
		if (stock == null) {
			throw new VideoclubException(
					"ERROR: la película no está");
		} else if (stock == 0) {
			throw new VideoclubException(
					"ERROR: no hay copias disponibles");
		}
		// Actualizar disponibles
		disponibles.put(p, stock-1);
		// Actualizar préstamos
		if (prestadas.keySet().contains(p)){
			prestadas.put(p, prestadas.get(p)+1);
		} else {
			prestadas.put(p, 1);
		}
	}
	
	public void devolver(Pelicula p) {
		Integer enPrestamo = prestadas.get(p);
		if (enPrestamo == null) {
			throw new VideoclubException(
				"ERROR: la película no está prestada");
		}
		// enPrestamo no puede ser 0
		// Actualizar disponibles
		disponibles.put(p, disponibles.get(p) + 1);
		if (enPrestamo == 1) {
			prestadas.remove(p);
		} else {
			prestadas.put(p, enPrestamo - 1);
		}
	}
	
}
