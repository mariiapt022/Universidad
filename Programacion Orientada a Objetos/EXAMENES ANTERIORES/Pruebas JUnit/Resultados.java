
package practicas;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringJoiner;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Iterator;

public class Resultados {
    private SortedSet<Practica> practicas;
    private SortedMap<String,SortedSet<Practica>> alumnos;
	//------------------------------------------------------------------
    public Resultados(Set<Practica> p) {
		alumnos = new TreeMap<String,SortedSet<Practica>>();
		practicas = new TreeSet<Practica>(p);
    }
	//------------------------------------------------------------------
	private Practica buscar(SortedSet<Practica> s, String d) {
		Practica r = null;
		boolean ok = false;
		Iterator<Practica> it = s.iterator();
		while ( ! ok && it.hasNext() ) {
			r = it.next();
			ok = r.getDescripcion().equalsIgnoreCase(d);
		}
		return ok ? r : null;
	}
	//------------------------------------------------------------------
    public void anyadirPractica(Practica p) {
		Practica t = buscar(practicas, p.getDescripcion());
		if (t == null) {
			throw new AppException("Descripcion erronea " + p.getDescripcion());
		}
		p.setCntRealizadas(t.getCntRealizadas());
		//--------------------------
		SortedSet<Practica> s = alumnos.get(p.getNombre().toLowerCase());
		if (s == null) {
			s = new TreeSet<Practica>();
			alumnos.put(p.getNombre().toLowerCase(), s);
		}
		s.remove(p);	// se elimina anterior en caso de que exista
		s.add(p);
    }
	//------------------------------------------------------------------
	public Resultados seleccionar(Selector sel) {
		Resultados res = new Resultados(practicas);
		for (SortedSet<Practica> s : alumnos.values()) {
			if ( sel.esSeleccionable(s) ) {
				for (Practica p : s) {
					res.anyadirPractica(p);
				}
			}
		}
		return res;
	}
	//------------------------------------------------------------------
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
	//------------------------------------------------------------------
    public void guardarEnFichero(String n) throws IOException {
		try (PrintWriter pw = new PrintWriter(n)) {
			for (SortedSet<Practica> s : alumnos.values()) {
				for (Practica p : s) {
					pw.println(p.getNombre()
							   + "; " + p.getDescripcion()
							   + "; " + p.getCntExito());
				}
			}
		}
	}
	//------------------------------------------------------------------
    public void cargarDeFichero(String n) throws IOException {
		try (Scanner sc = new Scanner(new File(n))) {
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
	//------------------------------------------------------------------
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
		// No se puede modificar la correspondencia mientras se itera sobre ella
		for (Practica p : nuevasPracticas) {
			anyadirPractica(p);
		}
	}
	//------------------------------------------------------------------
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
	//------------------------------------------------------------------
}
