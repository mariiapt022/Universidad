package alturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Mundo {
	private List<Pais> paises;
	
	private Mundo(List<Pais> p) {
		paises=p;
	}
	
	public static Mundo createFromFile(String file) throws FileNotFoundException {
		List<Pais> ps=new ArrayList<>();
		try(Scanner sc= new Scanner(new File(file))){
			while(sc.hasNextLine()) {
				String datoPais=sc.nextLine();
				try(Scanner scPais=new Scanner(datoPais)){
					scPais.useDelimiter("[,]");
					scPais.useLocale(Locale.ENGLISH);
					Pais pais=new Pais(scPais.next(),scPais.next(),scPais.nextDouble());
					ps.add(pais);
				}catch(NoSuchElementException e) {
					
				}
			}
		}
		return new Mundo(ps);
	}
	
	public static <K,V> void presentaEnConsola(Map<K,V> map) {
		for(Map.Entry<K, V> valores: map.entrySet()) {
			System.out.println(valores.getKey()+"\t"+valores.getValue());
		}
	}
	
	public List<Pais> getPaises(){
		return paises;
	}
	
	public Map<String,Integer> numeroDePaisesPorContinente(){
		Map<String,Integer> res=new TreeMap<>();
		for(Pais pais:paises) {
			String continente=pais.getContinente();
			int nroPaises=res.getOrDefault(continente, 0);
			res.put(continente, nroPaises+1);
		}
		return res;
	}
	
	public SortedMap<Double,List<Pais>> paisesPorAltura(){
		SortedMap<Double,List<Pais>> res=new TreeMap<>();
		for(Pais pais:paises) {
			double altura=pais.getAltura();
			double altura1Dec=(int)(altura*10)/10.0;
			List<Pais> listaPaisesAltura=res.getOrDefault(altura1Dec, new ArrayList<>());
			res.putIfAbsent(altura1Dec, listaPaisesAltura);
			listaPaisesAltura.add(pais);
		}
		
		return res;
	}
	
	public SortedMap<String,SortedSet<Pais>> paisesPorContinente(){
		SortedMap<String,SortedSet<Pais>> res=new TreeMap<>();
		for(Pais pais:paises) {
			String continente=pais.getContinente();
			SortedSet<Pais> paises=res.getOrDefault(continente, new TreeSet<>());
			res.putIfAbsent(continente, paises);
			paises.add(pais);
		}
		return res;
	}
	
	public SortedMap <Character,SortedSet<Pais>> paisesPorInicial(){
		
	}
	
	public SortedMap <String,Double> mediaPorContinente(){
		
	}
	
	public List<String> continentesConMasPaises(){
		
	}
	
}
