import java.io.*;
import java.util.*;

public class Colegio {

	/** Aplicaci�n:
	 *    - campo clave: nombre del curso (I3,I4,I5,P1,P2,P3,P4,P5,P6)
	 *    - campo valor: Conjunto ordenado de los solicitantes para un curso determinado
	 *    
	 *    El campo clave podr�a ser un enumerado. Se ha dejado como String
	 *    para no obligarles a que tengan que trabajar con el enumerado
	 */
	protected SortedMap<String,SortedSet<Solicitante>> solicitudes;
	
	public Colegio(String nombreFichero) throws IOException {
		solicitudes = new TreeMap<String,SortedSet<Solicitante>>();
		leerSolicitudes(nombreFichero);
	}
	
	private void leerSolicitudes(String nombreFichero) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
		leer(br);
		br.close();
	}

	private void leer(BufferedReader br) throws IOException {
		String lineaCurso = br.readLine();
		while (lineaCurso != null) {
			procesarCurso(lineaCurso,br);
			lineaCurso = br.readLine();
		}
	}

	private void procesarCurso(String lineaCurso, BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(lineaCurso," ");
		try {
			//EL NOMBRE DEL CURSO EN LUGAR DE STRING PODR�A SER UN ENUMERADO
			String nombre = st.nextToken();
			int numeroSolicitudes = Integer.parseInt(st.nextToken());
			solicitudes.put(nombre, procesarSolicitantes(numeroSolicitudes,br));
		} catch(NoSuchElementException e) {
			throw new AsignacionException("Faltan datos del solicitante");
		} catch (NumberFormatException e) {
			throw new AsignacionException("Formato incorrecto en datos de los solicitantes");
		}
	}

	private SortedSet<Solicitante> procesarSolicitantes(int numeroSolicitantes, BufferedReader br) throws IOException {
		SortedSet<Solicitante> listaSolicitantes = new TreeSet<Solicitante>();
		
		for (int cont = 0; cont < numeroSolicitantes; cont++) {
			String lineaSolicitante = br.readLine();
			StringTokenizer st = new StringTokenizer(lineaSolicitante," ");
			try {
				String nif = st.nextToken();
				double puntos = Double.parseDouble(st.nextToken());
				//�Han visto los alumnos esta versi�n del nextToken, donde indicas un delimitador distinto al que se esta utilizando?
				String nombre = st.nextToken("\n");
				Solicitante j = new Solicitante(nif,nombre,puntos);
				
				listaSolicitantes.add(j);
			} catch(NoSuchElementException e) {
				throw new AsignacionException("Faltan datos del solicitante");
			} catch (NumberFormatException e) {
				throw new AsignacionException("Formato incorrecto en datos del solicitante");
			}
		}
		
		return listaSolicitantes;
	}

	public void asignarPlazas(Map<String,Integer> plazas){
		//Solo asignaremos plazas para los cursos que aparezcan en la aplicaci�n "plazas". 
		//Para los dem�s cursos se supone que no hay plazas
		for (String curso: plazas.keySet()){
			//Para esa versi�n bastar�a con pasar como segundo par�metro el n�mero de plazas para ese curso. 
			//Para la clase que hereda necesitamos todo, por eso pasamos la aplicaci�n completa
			asignarPlazasCurso(curso, plazas); 
		}
	}

	protected void asignarPlazasCurso(String curso, Map<String,Integer> plazas){
		//Si quisi�ramos hacer la asignaci�n por el orden alternativo, primero reordenar�amos los solicitantes seg�n el oden alternativo.
		//SortedSet<Solicitante> solicitantes = new TreeSet<Solicitante>(new SATSolicitante());
		//solicitantes.addAll(solicitudes.get(curso));
		
		SortedSet<Solicitante> solicitantes = solicitudes.get(curso);
		if (solicitantes != null){
			//El numero de plazas a asignar es el valor m�nimo entre el n�mero de plazas disponibles y el n�mero de solicitantes
			Integer plazas_asignar = Math.min(plazas.get(curso), solicitantes.size());
			Iterator<Solicitante> i = solicitantes.iterator();
			while (i.hasNext() && plazas_asignar > 0){
				i.next().setTienePlaza(true);
				plazas_asignar--;
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
