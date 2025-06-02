

import java.util.NoSuchElementException;

import covid.COVIDException;
import covid.DistritoSanitario;

//María Peinado Toledo. Doble Grado Ingeniería Informática y Matemáticas. Grupo A

public class PruebaDistritoSanitario {
	
		
	public static void main(String[] args) {

		try {
		DistritoSanitario d1=new DistritoSanitario("La Vega",110176,Integer.decode(args[0]));
		DistritoSanitario d2=new DistritoSanitario("Axarquía",170141,Integer.decode(args[1]));
		DistritoSanitario d3=new DistritoSanitario("Valle del Guadalhorce",156298,Integer.decode(args[2]));
		DistritoSanitario d4=new DistritoSanitario("Costa del Sol",560785,Integer.decode(args[3]));
		DistritoSanitario d5=new DistritoSanitario("Málaga Distrito",633521,Integer.decode(args[4]));
		DistritoSanitario d6=new DistritoSanitario("Serranía",54999,Integer.decode(args[5]));
		}catch(NoSuchElementException e) {
			throw new COVIDException(e.getMessage());
		}catch(IllegalArgumentException ee) {
			throw new COVIDException(ee.getMessage());
		}catch(COVIDException eee) {
			throw new COVIDException(eee.getMessage());
		}catch(ArrayIndexOutOfBoundsException eeee) {
			throw new COVIDException(eeee.getMessage());
		}
		
		
		
	}

}
