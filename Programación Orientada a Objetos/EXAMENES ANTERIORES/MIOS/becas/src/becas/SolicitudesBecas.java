package becas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SolicitudesBecas {
	private Set<Beca> becas;
	private Map<Beca,Set<Estudiante>> solicitudes;
	
	public SolicitudesBecas(String nomFich) throws FileNotFoundException {
		solicitudes=new HashMap<>();
		becas=new HashSet<>();
		agregarBecas(nomFich);
	}
	
	private void agregarBecas(String nomFich) throws FileNotFoundException {
		try(Scanner sc=new Scanner(new File(nomFich))){
			agregarBecas(sc);
		}
	}
	
	private void agregarBecas(Scanner sc) {
		while(sc.hasNextLine()) {
			becas.add(Beca.nuevaBeca(sc.nextLine()));
		}
	}
	
	public void agregarSolicitud(Estudiante est,Beca beca) {
		if(!becas.contains(beca)) {
			throw new BecasException("Beca no registrada");
		}
		Set<Estudiante> solicitantes=solicitudes.get(beca);
		if(solicitantes==null) {
			solicitantes=new HashSet<Estudiante>();
			solicitudes.put(beca, solicitantes);
		}
		solicitantes.add(est);
	}
	
	public Set<String> becasSolicitadas(Estudiante est){
		Set<String> bs=new HashSet<String>();
		for(Beca beca:solicitudes.keySet()) {
			if(solicitudes.get(beca).contains(est)) {
				bs.add(beca.getCodigo());
			}
		}
		return bs;
	}
	
	public void asignarBecas(Comparator<Estudiante> criterio) {
		for(Beca beca:solicitudes.keySet()) {
			SortedSet<Estudiante> ests=new TreeSet<Estudiante>(criterio);
			ests.addAll(solicitudes.get(beca));
			Estudiante primero=ests.first();
			beca.asignaBeca(primero);
		}
	}
	
	public void guardarBecasAsignadas(String fichero) throws FileNotFoundException {
		PrintWriter pwFichero = new PrintWriter(fichero);
		guardarBecasAsignadas(pwFichero);
		pwFichero.close();
	}
	
	public void guardarBecasAsignadas(PrintWriter pw) {
		for(Beca beca : solicitudes.keySet()) {
			Estudiante becario = beca.getBecario();
			if (becario != null) pw.println(beca + " -> " + becario);
		}
	}
	
	
}
