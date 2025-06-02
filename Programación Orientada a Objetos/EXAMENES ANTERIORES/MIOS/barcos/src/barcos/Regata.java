package barcos;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Regata {
	private SortedSet<Barco> barcos;
	
	public Regata() {
		barcos=new TreeSet<>(new OrdenDistanciaMalaga());
	}
	
	public void agrega(Barco b) {
		if(!barcos.contains(b)) {
			barcos.add(b);
		}
	}
	
	public void avanzaTodos(int min) {
		for(Barco b:barcos) {
			b.avanza(min);
		}
	}
	
	public boolean hayBarcoSinArrancada() {
		boolean encontrado=false;
		Iterator<Barco> it=barcos.iterator();
		while(!encontrado&&it.hasNext()) {
			if(it.next().getVelocidad()==0) {
				encontrado=true;
			}
		}
		return encontrado;
	}
	
	public Barco primero() {
		return barcos.first();
	}
	
	public Barco ultimo() {
		return barcos.last();
	}
	
	public void leeBarcos(String nomFich) throws FileNotFoundException {
		try(Scanner sc=new Scanner(new File(nomFich))){
			leeBarcos(sc);
		}
	}
	
	public void leeBarcos(Scanner sc) {
		while(sc.hasNextLine()) {
			agrega(creaBarco(sc.nextLine()));
		}
	}
	
	public Barco creaBarco(String linea) {
		
		try(Scanner sc=new Scanner(linea)){
			sc.useDelimiter("[: ]+");
			String nombre=sc.next();
			double la=sc.nextDouble();
			double lo=sc.nextDouble();
			int rumbo=sc.nextInt();
			int velocidad=sc.nextInt();
			Posicion p=new Posicion(la,lo);
			return new Barco(nombre,p,rumbo,velocidad);
		}catch (InputMismatchException e) {
			throw new RegataException("Algun dato numerico es erroneo en " + linea);
		} catch (NoSuchElementException e) {
			throw new RegataException("Faltan datos  en " + linea);			
		}
		
	}
	
	public void guardaBarcos(String nomFich) throws FileNotFoundException {
		PrintWriter pw=new PrintWriter(nomFich);
		guardaBarcos(pw);
	}
	
	public void guardaBarcos(PrintWriter pw) {
		for(Barco b:barcos) {
			pw.println(b.toString()+"\n");
		}
	}
	
	
	public List<Barco> fueraDeAlcance(Posicion p,int km){
		List<Barco> res=new ArrayList<>();
		for(Barco b:barcos) {
			if(b.getPosicion().distancia(p)>km) {
				res.add(b);
			}
		}
		return res;
	}
	
	public Map<Integer,Set<Barco>> barcosPorCuadrante(){
		Map<Integer, Set<Barco>> map = new TreeMap<>();
		for(Barco b:barcos) {
			int cuad = b.getRumbo()/90 + 1;
			Set<Barco> bs=map.getOrDefault(cuad, new TreeSet<>());
			bs.add(b);
			map.putIfAbsent(cuad, bs);
		}
		return map;
	}
	
	
}
