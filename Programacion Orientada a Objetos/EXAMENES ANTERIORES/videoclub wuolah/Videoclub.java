package videoclub;

import java.io.*;
import java.util.*;

public class Videoclub {
	
	private Map<Pelicula, Integer> prestadas, disponibles;
	
	public Videoclub (String fich) throws FileNotFoundException {
		
		disponibles = new TreeMap<Pelicula, Integer> ();
		leerfich(fich);
	}

	private void leerfich(String fich) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fich));
		leerdatos(sc);
		sc.close();
		
	}

	private void leerdatos(Scanner sc) {
	 while (sc.hasNext()) {
		 String lin = sc.nextLine();
		 if (!lin.isEmpty()) {
			 try {
				 String[] cads = lin.split("%");
				 String t = cads[0], c=cads[2];
				 int e = Integer.parseInt(cads[3]), copias = Integer.parseInt(cads[4]);
				 Set<String> actores = new HashSet <String>();
				 for(String a : cads[1].split(",")) {
					 
					 actores.add(a);
				 }
				 Pelicula p = new Pelicula (t, actores, c, e);
				 anadir(p,copias);
				 
			 }catch (NumberFormatException e) {
				 throw new VideoclubException("Error: se ha leido un numero incorrecto");
				 
			 }catch (ArrayIndexOutOfBoundsException e2) {
				 
				 throw new VideoclubException("Error: faltan datos en la linea");
			 }
			 
		 }
		 
	 }
		
	}
	
	public void anadir (Pelicula p, int copias) {
		
		if (disponibles.containsKey(p)) {
			disponibles.put(p, disponibles.get(p) + copias);
		} else {
			disponibles.put(p, copias);
		}
	}
	
	public Pelicula pelicula(String titulo) {
		Pelicula res = null;
		Iterator<Pelicula> it = disponibles.keySet().iterator();
		
		while (it.hasNext() && res == null) {
			Pelicula p = it.next();
			if (p.getTitulo().equalsIgnoreCase(titulo))
				res = p;
		}
		
		return res;
	}
	
	public int disponibles(Pelicula p) {
		return (disponibles.get(p) == null) ? 0 : disponibles.get(p);
	}
	
	public Set<Pelicula> peliculasDeActor(String actor) {
		Set<Pelicula> res = new HashSet<Pelicula>();
		
		for (Pelicula p: disponibles.keySet())
			if (p.getActores().contains(actor))
				res.add(p);
		
		return res;
	}
	
}
