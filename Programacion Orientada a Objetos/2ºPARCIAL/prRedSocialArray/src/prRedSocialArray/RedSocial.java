
/* 
 * Ingenieria informatica 
 * Grupo B
 * 
 * */

package prRedSocialArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class RedSocial {

	private Persona[] red;
	private int numPersonas;
	private static final int INIT_RED = 10;
	
	
	public RedSocial(int tam) {
		red = new Persona[tam];
		numPersonas = 0;
	}
	
	public RedSocial() {
		this(INIT_RED);
	}
	
	private int buscar(Persona p) {
		int i = 0;
		while(i<numPersonas && !red[i].equals(p)) {
			i++;
		}
		
		if(i==numPersonas) {
			i = -1;
		}
		
		return i;
	}
	
	
	public void darAlta(Persona p) {
			
		if(buscar(p)==-1) {
			
			if(red.length == numPersonas) {
				red = Arrays.copyOf(red, red.length*2);
			}
			
			if(p==null) {
				throw new RedSocialException("El objeto no tiene valores");
			}else {
				red[numPersonas] = p;
				numPersonas++;
			}
			
		}
		
	}
	
	
	
	public void darAlta(String fichero) {
		
		try(Scanner sc = new Scanner(new File(fichero))){
			
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				
				try(Scanner sc2 = new Scanner(linea)){
					sc2.useDelimiter("[%]+");
					darAlta(new Persona(sc2.next(),sc2.nextInt(),sc2.next()));
				}
				
			}
			
			
		}catch(FileNotFoundException e){
			throw new RedSocialException("No se ha encontrado el fichero");
		}catch(NumberFormatException e) {
			throw new RedSocialException("Error en la lectura de edad");
		}catch(RuntimeException e) {
			throw new RedSocialException("Error de formato de datos");
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(red[0].toString());
		for(int i=1; i<numPersonas;i++) {
			sb.append("\n"+red[i]);
		}
		
		return sb.toString();
	}
	
	
	
	
	
}
