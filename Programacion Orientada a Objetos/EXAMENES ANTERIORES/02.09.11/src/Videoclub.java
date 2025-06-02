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
				 // Extraer datos de la l�nea
				 StringTokenizer stk = 
					 			new StringTokenizer(linea,"%");
				 String titulo = stk.nextToken();
				 String elenco = stk.nextToken();
				 String codigo = stk.nextToken();
				 int a�o = Integer.parseInt(stk.nextToken());
				 int copias = Integer.parseInt(stk.nextToken());
				 StringTokenizer act =
					   			new StringTokenizer(elenco,",");
				 Set<String> actores = new HashSet<String>();
				 while (act.hasMoreTokens()) {
					 actores.add(act.nextToken());
				 }
				 // Agregar pel�cula
				 a�adir(new Pelicula(titulo,actores,codigo,a�o), 
						 copias);
				 // Leer una nueva l�nea
				 linea = br.readLine();
			 }
		 } catch(IOException e){
			 throw new VideoclubException(
					 "ERROR de lectura");
		 } catch(NoSuchElementException e){
			 throw new VideoclubException(
					 "ERROR faltan datos en la l�nea");
		 } catch(NumberFormatException e) {
			 throw new VideoclubException(
					 "ERROR de formato en la lectura");
		 }
		 
	 }
	 
	// M�todos ............................................
	
	 // M�todo para a�adir copias de una pel�cula
	public void a�adir(Pelicula p, int copias) {
		if (copias < 1) {
			throw new VideoclubException(
					"ERROR no hay copias para a�adir");
		}
		Integer stock = disponibles.get(p);
		if (stock == null) {
			stock = 0;
		}
		stock = stock + copias;
		disponibles.put(p, stock);
	}
	
	// M�todo para consultar el n�mero de copias disponibles
	public int disponibles(Pelicula p){
		return disponibles.get(p);
	}
	
	// M�todo para consultar un t�tulo
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
	
	// M�todo para consultar las pel�culas en las que act�a un
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
	
	// M�todos para prestar y para devolver pel�culas
	public void prestar(Pelicula p) {
		Integer stock = disponibles.get(p);
		if (stock == null) {
			throw new VideoclubException(
					"ERROR: la pel�cula no est�");
		} else if (stock == 0) {
			throw new VideoclubException(
					"ERROR: no hay copias disponibles");
		}
		// Actualizar disponibles
		disponibles.put(p, stock-1);
		// Actualizar pr�stamos
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
				"ERROR: la pel�cula no est� prestada");
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
