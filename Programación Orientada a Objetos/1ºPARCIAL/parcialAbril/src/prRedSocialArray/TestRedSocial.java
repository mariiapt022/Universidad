package prRedSocialArray;

import java.io.IOException;


public class TestRedSocial {

	public static void main(String[] args) throws IOException {
		try {
			RedSocial red= new RedSocial();
			red.darAlta("redsocial.txt");
			System.out.println(red.toString());
			
			TipoRestriccion rest= null;
			rest= new RestriccionEdad(22);
			
			RedSocialConRestriccion redRestringida= new RedSocialConRestriccion(rest);
			redRestringida.darAlta("redsocial.txt");
			System.out.println(redRestringida);
		}catch(RedSocialException e) {
			System.out.println("ERROR: "+e.getMessage());
		}

	}

}
