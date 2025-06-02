/**
 * @author Pepe Gallardo
 *
 * Clase con m�todos auxiliares �tiles para solucionar
 * el problema de la supersecuencia com�n m�s corta
 * 
 */


import java.util.Random;

public class Utils {

	static Random rnd = new Random();
	
	
	/**
	 * @param tamAlfabeto
	 * @return devuelve un alfabeto de tama�o @tamAlfabeto
	 */
	public static String alfabeto(int tamAlfabeto) {
		String sigma = "";
		for(int i=0; i<tamAlfabeto; i++)
			sigma += (char) ('a'+i);
		return sigma;
		
	}
	
	/**
	 * @param longitud : longitud de la cadena
	 * @param sigma    : alfabeto de s�mbolos posibles
	 * @return         : crea una cadena aleatoria de cierta longitud con 
	 *                   s�mbolos de un alfabeto
	 */
	public static String cadenaAleatoria(int longitud, String sigma){
		String x = "";
		for(int i=0; i<longitud; i++)
			x = x + sigma.charAt(rnd.nextInt(sigma.length()));
		return x;		
	}

	
	/**
	 * @param x		: la cadena x = x1 x2 ... xn
	 * @param pos	: la posici�n (1<=pos<=n)
	 * @return      : Devuelve el caracter que se encuentra en la posici�n @pos
	 *                de la cadena @x. Los caracteres de x se 
	 *                numer�n de 1 en adelante
	 */
	public static char charEn(String x, int pos){
		return x.charAt(pos-1);
	}



	/**
	 * @param s
	 * @return : Devuelve la cadena @s entrecomillada
	 */
	public static String entreComillas(String s){
		return "\""+s+"\"";
	}

	/**
	 * @param sup
	 * @param cad
	 * @return Comprueba si la cadena @sup es supersecuencia de 
	 * 		   la cadena @cad
	 */
	public static boolean esSupersecuencia(String sup, String cad) {
		int p;
		
		for(char c : cad.toCharArray()) {
			p = sup.indexOf(c);
			if(p<0)
				return false;
			sup = sup.substring(1+p);
		}	
		return true;
	}
	
}
