

import java.io.IOException;
import prRedSocialArray.RestriccionEdad;
import prRedSocialArray.TipoRestriccion;
import prRedSocialArray.RedSocial;
import prRedSocialArray.RedSocialConRestriccion;
import prRedSocialArray.RedSocialException;

public class TestRedSocial {

	public static void main(String[] args) {
		try {
			RedSocial red = new RedSocial();
			red.darAlta("redsocial.txt");
			
			System.out.println(red.toString());	
			
			//Asignar a apartadoElegido el nmero del apartado escogido (67)
			int apartadoElegido = 6;
			
			TipoRestriccion rest = null;
			if (apartadoElegido == 7) {
				//rest = new RestriccionNombre('M');
			}else {
				rest = new RestriccionEdad(22);	
			}
			
			RedSocialConRestriccion redRestringida = new RedSocialConRestriccion(rest);
			redRestringida.darAlta("redsocial.txt");
			System.out.println(redRestringida);

						
		} catch (RedSocialException e) {
			System.out.println("ERROR: " + e.getMessage());
		} 	
	}
}

/*SALIDA DEL PROGRAMA PRINCIPAL si se escogi apartado 6: 
  
Brandon Tras 31 (brandon@correo.com)
Alicia Wong 23 (wong@correo.com)
Mao Chin 25 (chin@correo.com)
Juan Uno 15 (uno@correo.com)
Pedro Dos 18 (dos@correo.com)
Mara Tres 25 (tres@correo.com)
Ramn Cuatro 40 (cuatro@correo.com)
John M Perkinson 38 (jmperk@correo.com)
David Hofferpield 55 (dhoff@correo.com)
Peggy Stanton 21 (pegstan@correo.com)

Brandon Tras 31 (brandon@correo.com)
Alicia Wong 23 (wong@correo.com)
Mao Chin 25 (chin@correo.com)
Mara Tres 25 (tres@correo.com)
Ramn Cuatro 40 (cuatro@correo.com)
John M Perkinson 38 (jmperk@correo.com)
David Hofferpield 55 (dhoff@correo.com)
*/
