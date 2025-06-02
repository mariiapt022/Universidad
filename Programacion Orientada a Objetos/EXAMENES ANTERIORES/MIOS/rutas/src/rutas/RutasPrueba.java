package rutas;

import java.io.FileNotFoundException;

public class RutasPrueba {

	public static void main(String[] args) throws FileNotFoundException {
		// Se crea una ruta
		Ruta ruta = new Ruta("Canillas-Maroma");
						
		// Se crean varios lugares a recorrer
		Lugar canillas = new Lugar("Canillas de Aceituno",36.874,-4.081);
		Lugar fuenteRabita = new Lugar("Fuente Rábita",36.882,-4.067);
		Lugar colladoGitana = new Lugar("Collado de la Gitana",36.888,-4.056);
		Lugar casaNieve = new Lugar("Casa de la Nieve",36.906,-4.052);
		Lugar maroma= new Lugar("La Maroma",36.903,-4.046);
			
		// Se añaden esos lugares a la ruta
		ruta.agregar(canillas);
		ruta.agregar(fuenteRabita);
		ruta.agregar(colladoGitana);
		ruta.agregar(casaNieve);
		ruta.agregar(maroma);
		
		// Confirma que colladoGitana está en la ruta
		System.out.println(colladoGitana +
							(ruta.estaEnRuta(colladoGitana)?" sí ":" no ") + 
							"está en la ruta");
		
		// Imprime en pantalla la distancia total de la ruta
		System.out.println("La distancia total a recorrer es: " + ruta.distanciaRuta());
		
		// Creación de otro objeto Ruta ...
		Ruta rutaMaroma = new Ruta("Canillas a Maroma");
		// ... a la que se agregan los lugares del fichero rutaMaroma.txt
		rutaMaroma.agregarLugares("rutaMaroma.txt");
		
		// Se vuelca la información de rutaMaroma en el fichero salida.txt
		rutaMaroma.guardarRuta("salida.txt");		
	}

}
