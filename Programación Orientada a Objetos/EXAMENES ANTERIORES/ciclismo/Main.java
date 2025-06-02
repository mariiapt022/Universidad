import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Main {
	public static void main(String [] args) {
		Clasificacion clasificacion = new Clasificacion();
		try {
			PrintWriter pw = new PrintWriter(System.out, true);
			Clasificacion clasTrasEtapa1 = clasificacion.nuevaClasificacion("etapa1.txt");
			clasTrasEtapa1.muestraClasificacion(pw);
			pw.println("Tiempo equipo STB : " + clasTrasEtapa1.tiempoEquipo("STB"));
			Clasificacion clasTrasEtapa2 = clasTrasEtapa1.nuevaClasificacion("etapa2.txt");
			clasTrasEtapa2.muestraClasificacion(pw);
			pw.println("Tiempo equipo STB : " + clasTrasEtapa1.tiempoEquipo("STB"));
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error IO "+ e.getMessage());
		} catch (RuntimeException e) {
			System.out.println( e.getMessage());
		}
	}
}
