/* 
 * Ingenieria informatica 
 * Grupo B
 * 
 * */


package prRedSocialArray;

public class RestriccionEdad implements TipoRestriccion{

	private int edadMinima;
	
	public RestriccionEdad(int edadMin) {
		
		if(edadMin<0) {
			throw new RedSocialException("Edad negativa");
		}
		
		edadMinima=edadMin;
	}
	
	@Override
	public boolean valida(Persona p) {
		return p.getEdad()>=edadMinima;
	}
	
}
