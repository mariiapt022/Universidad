package covid;
//María Peinado Toledo. Doble Grado Ingeniería Informática y Matemáticas. Grupo A
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;



public class MapaCOVID {
	private String nombre;
	private SortedMap<String,SortedSet<DistritoSanitario>> mapa;
	
	public MapaCOVID(String n,String nomFich) throws FileNotFoundException {
		nombre=n;
		mapa=new TreeMap<String,SortedSet<DistritoSanitario>>();
		leerDatos(nomFich);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void leerDatos(String nomFich) throws FileNotFoundException{
		try(Scanner sc=new Scanner(new File(nomFich))){
			leerDatos(sc);
		}
	}
	
	public void leerDatos(Scanner sc) {
		try {
			while(sc.hasNextLine()) {
				leerLinea(sc.nextLine());
			}
		}catch(IllegalArgumentException e) {
			//omitimos
		}
	}
	
	public void leerLinea(String linea) {
		try(Scanner sc=new Scanner(linea)) {
			sc.useDelimiter("[():]+");
			String distrito=sc.next();
			String prov=sc.next();
			int pobl=sc.nextInt();
			int pos=sc.nextInt();
			DistritoSanitario ds=new DistritoSanitario(distrito,pobl,pos);
			agregarDistrito(prov,ds);
		}catch(IllegalArgumentException e) {
			//omitimos
		}
	}
	
	
	public Set<String> getProvincias(){
		return mapa.keySet();
	}
	
	public Set<DistritoSanitario> getDistritos(){
		Set<DistritoSanitario> res=new TreeSet<>();
		for(String prov:mapa.keySet()) {
			for(DistritoSanitario ds:mapa.get(prov)) {
				res.add(ds);
			}
		}
		return res;
	}
	
	
	public void agregarDistrito(String prov,DistritoSanitario d) {
		if(!mapa.keySet().contains(prov)) {
			SortedSet<DistritoSanitario> ds =new TreeSet<>();
			ds.add(d);
			mapa.put(prov, ds);
		}else if(!mapa.get(prov).contains(d)) {
			mapa.get(prov).add(d);
		}
		
	}
	
	
	public int incidenciaProvincia(String p) {
		int res,pobl=0,pos=0;
		for(DistritoSanitario d:mapa.get(p)) {
			pobl=pobl+d.getPoblacion();
			pos=pos+d.getPositivos();
		}
		
		if(pobl==0||!mapa.containsKey(p)) {
			res=0;
		}else {
			res=100000*pos/pobl;
		}
		return res;
	}
	
	public Set<String> obtenerInfoCOVID(InfoCOVID ic){
		return ic.obtenerInfo(this);
	}
	
	public void mostrarMapa(String nomFich) throws FileNotFoundException{
		PrintWriter pw=new PrintWriter(nomFich);
		mostrarMapa(pw);
		pw.close();
	}
	
	public void mostrarMapa(PrintWriter pw) {
		pw.println(nombre.toUpperCase());
		for(String prov:mapa.keySet()) {
			pw.println(prov);
			for(DistritoSanitario d:mapa.get(prov)) {
				pw.println(d);
			}
		}
	}
		
	
}
