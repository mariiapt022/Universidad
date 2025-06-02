import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Colegio {
	private SortedMap<String,SortedSet<Solicitante>> solicitudes;
	
	public Colegio(String nomFich) throws FileNotFoundException {
		solicitudes= new TreeMap<String,SortedSet<Solicitante>>();
		leerFichero(nomFich);
	}
	
	private void leerFichero(String nomFich) throws FileNotFoundException {
		SortedSet<Solicitante> listaSolicitantes=new TreeSet<Solicitante>();
		Solicitante s;
		try {
			Scanner sc=new Scanner(new File(nomFich));
			sc.useDelimiter(" ");
			while(sc.hasNextLine()) {
				String curso=sc.next();
				int num=sc.nextInt();
				for(int i=0;i<num;i++) {
					String linea=sc.nextLine();
					s=procesarSolicitante(linea);
					listaSolicitantes.add(s);
				}
				solicitudes.put(curso, listaSolicitantes);
				listaSolicitantes.clear();
			}
			
		}catch(NoSuchElementException e) {
			throw new AsignacionException("Faltan datos del solicitante");
		}catch(NumberFormatException e) {
			throw new AsignacionException("Formato erroneo del solicitante");
		}
	}
	
	private Solicitante procesarSolicitante(String linea) {
		Scanner sc=new Scanner(linea);
		Solicitante res;
		sc.useDelimiter(" ");
		String NIF=sc.next();
		Double puntos=sc.nextDouble();
		String nombre=sc.next();
		sc.close();
		res=new Solicitante(NIF,nombre,puntos);
		return res;
	}
	
	public void asignarPlazas(Map<String,Integer> plazas) {
		for(String curso:plazas.keySet()) {
			asignarPlazasCurso(curso,plazas);
		}
	}
	
	protected void asignarPlazasCurso(String curso,Map<String,Integer> plazas) {
		
		SortedSet<Solicitante> solicitantes= solicitudes.get(curso);
		if(solicitantes!=null) {
			Integer plazasAsignar=Math.min(plazas.get(curso), solicitantes.size());
			Iterator<Solicitante> i=solicitantes.iterator();
			while(i.hasNext()&&plazasAsignar>0) {
				i.next().setTienePlaza(true);
				plazasAsignar--;
			}
			
		}
		
	}
	
	public void mostrarSolicitantes(boolean conPlaza, PrintWriter pw) {
		for (Map.Entry<String,SortedSet<Solicitante>> curso : solicitudes.entrySet()) {
			pw.println(curso.getKey());
			for(Solicitante sol: curso.getValue()){
				if (sol.getTienePlaza() == conPlaza)
					pw.println(sol);
			}
		}
	}
	
	public void mostrarSolicitantes(boolean conPlaza, PrintWriter pw, Comparator <Solicitante> comparator){
		for (Map.Entry<String,SortedSet<Solicitante>> curso : solicitudes.entrySet()) {
			pw.println(curso.getKey());
			SortedSet<Solicitante> orden_alt = new TreeSet<Solicitante>(comparator);
			orden_alt.addAll(curso.getValue());
			for(Solicitante sol: orden_alt){
				if (sol.getTienePlaza() == conPlaza)
					pw.println(sol);
			}
		}
	}
	
	public void mostrarSolicitantes(boolean conPlaza, String nombreFichero) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(nombreFichero);
		mostrarSolicitantes(conPlaza, pw);
		pw.close();
	}
	
	public void mostrarSolicitantes(boolean conPlaza, String nombreFichero, Comparator <Solicitante> comparator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(nombreFichero);
		mostrarSolicitantes(conPlaza, pw, comparator);
		pw.close();
	}
	
	public void limpiar() {
		for (String curso : solicitudes.keySet()) {
			for (Solicitante solicitante : solicitudes.get(curso)) {
				solicitante.setTienePlaza(false);
			}
		}
	}
	
	
	
	
	
	
	
}
