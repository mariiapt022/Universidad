import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;
import java.util.TreeMap;


public class Principal {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//Creamos una aplicación donde se indica el número de plazas disponible para cada curso
			//En caso de que para un curso no haya ninguna plaza disponible, no se incluye una entrada en la aplicación para ese curso
			Map<String,Integer> plazas = new TreeMap<String,Integer>();
			plazas.put("I3",2);
			plazas.put("I4",5);
			plazas.put("P2",2);
			plazas.put("P6",2);
			
			//Asignamos plazas
			Colegio pe = new Colegio("solicitudes.txt");
			pe.asignarPlazas(plazas);

			PrintWriter pw = new PrintWriter(System.out, true);
			System.out.println("Solicitantes con plaza: ");
			System.out.println("--------------------------------------------------");
			pe.mostrarSolicitantes(true, pw); //Muestra los solicitantes que han conseguido plaza
			pe.mostrarSolicitantes(true, "conPlaza.txt");
			
			System.out.println("\nSolicitantes sin plaza: ");
			System.out.println("----------------------------------------------------");
			pe.mostrarSolicitantes(false, pw); //Muestra los solicitantes que no han conseguido plaza
			pe.mostrarSolicitantes(false,"sinPlaza.txt");
			
			//Asignamos plazas de forma justa
			ColegioFamiliar pe_mj = new ColegioFamiliar("solicitudes.txt");
			pe_mj.asignarPlazas(plazas);
			
			System.out.println("\nSolicitantes con plaza (asignación familiar): ");
			System.out.println("--------------------------------------------------");
			pe_mj.mostrarSolicitantes(true, pw); //Muestra los solicitantes que han conseguido plaza
			pe_mj.mostrarSolicitantes(true,"conPlaza-familiar.txt");
						
			System.out.println("\nSolicitantes sin plaza (asignación familiar): ");
			System.out.println("--------------------------------------------------");
			pe_mj.mostrarSolicitantes(false, pw); //Muestra los solicitantes que no han conseguido plaza
			pe_mj.mostrarSolicitantes(false,"sinPlaza-familiar.txt");

		} catch (AsignacionException e) {
			System.out.println("ERROR: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR de Entrada/Salida: " + e.getMessage());
		}
		
	}

}
