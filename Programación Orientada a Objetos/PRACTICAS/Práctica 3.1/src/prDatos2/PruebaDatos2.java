package prDatos2;

import java.util.Arrays;

import prDatos.Datos;
import prDatos.DatosException;

public class PruebaDatos2 {

	public static void main(String[] args) {
		String string = "10 hola 5 9 Pepe 10 María 12 13 Paco 17 20 Ana 25 Juan Lola";
		String[] secuencia = string.split(" ");
		
		if (secuencia.length < 3) {
			System.out.println("Error, no hay valores suficientes");
		}else {
			double min=0,max=0;
			try {
				min=Double.parseDouble(secuencia[0]);
				max=Double.parseDouble(secuencia[1]);
				Datos dat=new Datos(Arrays.copyOfRange(secuencia, 2, secuencia.length),min,max);
				dat.getDatos();
				System.out.println(dat.toString());
				dat.setRango("0;4");
				System.out.println(dat.toString());
				dat.setRango("15 25");
			}catch (NumberFormatException e) {
		    	System.out.println("Error al convertir un valor a número real ( " + e.getMessage() + ")");
		    } catch (DatosException e) {
		    	System.out.println(e.getMessage());
		    }
		}


	}

}
