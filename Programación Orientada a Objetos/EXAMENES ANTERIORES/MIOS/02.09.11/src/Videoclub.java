import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Videoclub {
	
	SortedMap<Pelicula, Integer> disponibles,prestadas= new TreeMap<Pelicula, Integer>();
		
	public Videoclub(String nomFich) {
		try {
			Scanner sc= new Scanner(new File(nomFich));
			leerFichero(sc);
			sc.close();
		}catch(FileNotFoundException e) {
			throw new RuntimeException("ERROR fichero no encontrado");
		}
	}
	
	private void leerFichero(Scanner sc) {
		String titulo,codigo,actores;
		int ae,nc;
		Set<String> acts = new HashSet<String>();
		sc.useDelimiter("%");
		try {
			
			while(sc.hasNextLine()) {
				
				titulo=sc.next();
				
				actores=sc.next();
				
				codigo=sc.next();
				
				ae=sc.nextInt();
				System.out.println(ae);
				nc=sc.nextInt();
				System.out.println(nc);
				
				Scanner act=new Scanner(actores);
				act.useDelimiter(",");
				
				while(act.hasNext()) {
					acts.add(act.next());
				}
				act.close();
				añadir(new Pelicula(titulo,acts,codigo,ae),nc);
			}
		}catch(NoSuchElementException e){
			 throw new RuntimeException("ERROR faltan datos en la línea");
		 } catch(NumberFormatException e) {
			 throw new RuntimeException("ERROR de formato en la lectura");
		 }
	}
	
	public void añadir(Pelicula p,int copias) {
		if (copias < 1) {
			throw new RuntimeException("ERROR no hay copias para añadir");
		}
		Integer stock=disponibles.get(p);
		if(stock==null) {
			stock=0;
		}
		stock=stock+copias;
		disponibles.put(p, stock);		
	}
	
	public int disponibles(Pelicula p) {
		return disponibles.get(p);
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
	
	public Set<Pelicula> peliculasDeActor(String actor){
		Set<Pelicula> res = new HashSet<Pelicula>();
		
		for (Pelicula p: disponibles.keySet()) {
			if (p.getActores().contains(actor)) {
				res.add(p);
			}
		}
		
		return res;
	}
	
	public void prestar(Pelicula p) {
		Integer stock=disponibles.get(p);
		if(stock==null) {
			throw new RuntimeException("La pelicula no se encuentra");
		}else if(stock==0) {
			throw new RuntimeException("No hay copias de la pelicula");
		}
		
		disponibles.put(p,stock-1);
		if(prestadas.keySet().contains(p)) {
			prestadas.put(p, prestadas.get(p)+1);
		}else {
			prestadas.put(p, 1);
		}
	}
	
	public void devolver(Pelicula p) {
		Integer stock=prestadas.get(p);
		if(stock==null) {
			throw new RuntimeException("La pelicula no esta prestada");
		}
		
		disponibles.put(p, disponibles.get(p)+1);
		if(stock==1) {
			prestadas.remove(p);
		}else {
			prestadas.put(p,stock-1);
		}
	}
	
}
