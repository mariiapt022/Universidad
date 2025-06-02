/* 
 * Ingenieria informatica 
 * Grupo B
 * 
 * */

package prRedSocialArray;

public class Persona {

	private String nombre;
	private int edad;
	private String mail;
	
	public Persona(String nm, int ed, String ml) {
		
		if(nm==null || ml==null) {
			throw new RedSocialException("No has introducido nada en el nombre o email");
		}
		
		if(ed<0) {
			throw new RedSocialException("Edad negativa");
		}
		
		try {
			nombre=nm;
			edad=ed;
			mail=ml;
		}catch(NumberFormatException e) {
			throw new RedSocialException("Introduce un numero natural para la edad");
		}
	}
	
	@Override
	public String toString() {
		return nombre+" "+edad+" ("+mail+")";
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getEmail() {
		return mail;
	}
	
	public boolean equals(Object obj) {
		boolean res=false;
		if(obj instanceof Persona) {
			Persona p = (Persona) obj;
			res = nombre.equalsIgnoreCase(p.nombre) && mail.equals(p.mail); 
		}
		return res;
	}
	
	public int hashCode() {
		return nombre.toLowerCase().hashCode() + mail.hashCode(); 
	}
	
}
