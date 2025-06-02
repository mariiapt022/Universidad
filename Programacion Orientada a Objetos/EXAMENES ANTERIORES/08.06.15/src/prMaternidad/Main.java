package prMaternidad;

import java.io.PrintWriter;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		try{
			//Testing class Maternidad------------------------------------------------
			Maternidad mat = new Maternidad("pacientes.txt");
			System.out.println("Datos leidos:");
			System.out.println(mat);
			
			System.out.println("Ratio Bebés/Madre: " + mat.mediaBebes());
						
			int codigoBebe = 1100;
			System.out.println("La madre del bebé con código " + codigoBebe +
								" está en la habitación " + mat.encontrarMadre(codigoBebe));
			
			
			System.out.println("Enviando la información a la salida estándar");
			PrintWriter pw = new PrintWriter(System.out,true); 
			mat.escribir(pw);
			pw.flush();
			
			System.out.println("Guardar Datos en salida.txt");
			mat.escribirFichero("salida.txt");
			
			//Testing class MaternidadLimiteNiñosHabitacion-----------------------------------
			System.out.println("\n\nProbando maternidad con límite de bebés por habitación");
			mat = new MaternidadLimiteBebesHabitacion(2,"pacientes.txt");
			System.out.println("Datos leidos:");
			System.out.println(mat);
			
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
