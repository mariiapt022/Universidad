package prRedSocialArray;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RedSocial {
	protected Persona[] red;
	protected int numPersonas;
	protected static int INIT_RED=10;
	
	public RedSocial(int tam){
		red=new Persona[tam];
		numPersonas=0;
	}
	
	public RedSocial() {
		this(INIT_RED);
	}
	
	private int buscar(Persona p) {
		int pos=-1;
		for(int i=0;i<numPersonas;i++) {
			if(red[i].equals(p)) {
				pos=i;
			}
		}
		return pos;
	}
	
	public void darAlta(Persona p) throws RedSocialException{
		int pos=buscar(p);
		if(pos!=-1) {
			if(numPersonas>=red.length) {
				red=Arrays.copyOf(red, red.length*2);
			}
			red[numPersonas]=p;
			numPersonas++;
			if(p==null) {
				throw new RedSocialException("Persona a introducir nula");
			}
			
		}
	}
	
	public void darAlta(String fichero) throws RedSocialException{
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
