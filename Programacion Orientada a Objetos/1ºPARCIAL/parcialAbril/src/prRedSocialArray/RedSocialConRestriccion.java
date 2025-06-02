package prRedSocialArray;

public class RedSocialConRestriccion extends RedSocial{
	
	private TipoRestriccion restriccion;
	
	public RedSocialConRestriccion(TipoRestriccion tr) {
		restriccion=tr;
	}
	
	@Override
	public void darAlta(Persona p) throws RedSocialException {
		if(restriccion.valida(p)) {
			super.darAlta(p);
		}
	}

}
