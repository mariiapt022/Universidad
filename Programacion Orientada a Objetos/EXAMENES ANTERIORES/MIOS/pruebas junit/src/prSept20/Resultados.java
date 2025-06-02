package prSept20;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Resultados {
	private SortedSet<Practica> practicas;
	private SortedMap<String,SortedSet<Practica>> alumnos;
	
	public Resultados(Set<Practica> p) {
		alumnos=new TreeMap<>();
		practicas=new TreeSet<>(p);
	}
	
	private Practica buscar(SortedSet<Practica> p,String d) {
		Practica res=null,r;
		boolean encontrado=false;
		Iterator<Practica> it=p.iterator();
		while(!encontrado&&it.hasNext()) {
			r=it.next();
			if(r.getDescripcion().equalsIgnoreCase(d)) {
				res=r;
				encontrado=true;
			}
		}
		return res;
	}
	
	public void anyadirPractica(Practica p) {
		Practica res=buscar(practicas,p.getDescripcion());
		if(res==null) {
			throw new AppException("Practica no encontrada");
		}else {
			p.setCntRealizadas(res.getCntRealizadas());			
		}
		SortedSet<Practica> s=alumnos.get(p.getNombre().toLowerCase());
		if(s==null) {
			s=new TreeSet<Practica>();
			alumnos.put(p.getNombre().toLowerCase(), s);
		}else {
			s.remove(p);
			s.add(p);
		}
	}
	
	public Resultados seleccionar(Selector s) {
		Resultados res=new Resultados(practicas);
		for(SortedSet<Practica> p:alumnos.values()) {
			if(s.esSeleccionable(p)) {
				for(Practica pr:p) {
					res.anyadirPractica(pr);
				}
			}
		}
		return res;
	}
	
	public String toString() {
		StringJoiner sj1 = new StringJoiner("; ", "[ ", " ]");
		for (Practica p : practicas) {
			sj1.add(p.toString());
		}
		StringJoiner sj2 = new StringJoiner("; ", "[ ", " ]");
		for (SortedSet<Practica> s : alumnos.values()) {
			for (Practica p : s) {
				sj2.add(p.toString());
			}
		}
		StringJoiner sj = new StringJoiner(", ", "{ ", " }");
		sj.add(sj1.toString());
		sj.add(sj2.toString());
		return sj.toString();
	}
	
	public void guardarEnFichero(String nomFich) throws IOException {
		try(PrintWriter pw=new PrintWriter(nomFich)){
			for(SortedSet<Practica> p:alumnos.values()) {
				for(Practica pr:p) {
					pw.println(pr.getNombre()+"; "+pr.getDescripcion()+"; "+pr.getCntExito());
				}
			}
		}
	}
	
	public void cargarDeFichero(String nomFich) throws IOException {
		try (Scanner sc = new Scanner(new File(nomFich))) {
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				try {
					String[] campos = linea.split("\\s*[;]\\s*");
					if (campos.length == 3) {
						anyadirPractica(new Practica(campos[0], campos[1], 0,
												 Integer.parseInt(campos[2])));
					}
				} catch (Exception e) {
					// ignorar
				}
			}
		}
	}
	
	public void completarPracticas() {
		SortedSet<Practica> nuevasPracticas = new TreeSet<Practica>();
		for (Map.Entry<String,SortedSet<Practica>> e : alumnos.entrySet()) {
			if (e.getValue().size() != practicas.size()) {
				for (Practica t : practicas) {
					Practica p = buscar(e.getValue(), t.getDescripcion());
					if (p == null) {
						nuevasPracticas.add(new Practica(e.getKey(), t.getDescripcion()));
					}
				}
			}
		}
		for (Practica p : nuevasPracticas) {
			anyadirPractica(p);
		}
	}
	
	public int calcPorcExitoAlumno(String nombre) {
		int porcExitoAlumno = 0;
		SortedSet<Practica> s = alumnos.get(nombre.toLowerCase());
		if (s != null) {
			int sumaCntRealizadas = 0;
			int sumaCntExito = 0;
			for (Practica x : s) {
				sumaCntRealizadas += x.getCntRealizadas();
				sumaCntExito += x.getCntExito();
			}
			if (sumaCntRealizadas > 0) {
				porcExitoAlumno = 100 * sumaCntExito / sumaCntRealizadas;
			}
		}
        return porcExitoAlumno;
	}
}
