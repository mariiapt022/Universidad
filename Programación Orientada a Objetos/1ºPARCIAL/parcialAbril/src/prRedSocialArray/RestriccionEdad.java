package prRedSocialArray;

public class RestriccionEdad implements TipoRestriccion{
	protected int edadMinima;
	
	public RestriccionEdad(int e) throws RedSocialException{
		if(e<0) {
			throw new RedSocialException("Edad minima no válida");
		}else {
			edadMinima=e;
		}
	}
	
	@Override
	public boolean valida(Persona p) {
		return p.getEdad()>=edadMinima;
	}

}
