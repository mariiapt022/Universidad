import prRegata.Barco;
import prRegata.Posicion;
import prRegata.Regata;
import prRegata.Velero;

public class Main2 {
	public static void main(String [] args) {
		Barco[] barcos = {
				new Barco("alisa", new Posicion(30,  240), 80, 20),
				new Velero("veraVela", new Posicion(-30, 290), 20, 14),
				new Barco("kamira", new Posicion(80, 182), 230, 33),
				new Barco("gamonal", new Posicion(0, -260), 0, 24),			
		};
		
		Regata regata = new Regata();
		for(Barco barco : barcos) {
			regata.agrega(barco);
		}
		System.out.println(regata.getParticipantes());
		regata.avanza(10);
		System.out.println(regata.getParticipantes());
		System.out.println(regata.velocidadSuperiorA(28));
		System.out.println(regata.dentroDelCirculo(new Posicion(0, 0), 300));		
		System.out.println(regata.ordenadosPorDistancia());
		System.out.println(regata.barcosPorVelocidad());
		
	}
}
