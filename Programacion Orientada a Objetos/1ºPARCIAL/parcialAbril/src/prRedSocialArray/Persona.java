package prRedSocialArray;

public class Persona {
	protected String nombre,correo;
	protected int edad;
	
	public Persona(String n, int e, String c) throws RedSocialException{
		if(n==null || c==null) {
			throw new RedSocialException("Nombre o correo nulo");
		}else if(e<0){
			throw new RedSocialException("Edad no válida");
			
		}else {
			nombre=n;
			edad=e;
			correo=c;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getEmail() {
		return correo;
	}
	
	public boolean equals(Persona p) {
		int k=0;
		
		if(this.getNombre().equalsIgnoreCase(p.getNombre())) {
			k++;
		}
		
		if(this.getEmail().equalsIgnoreCase(p.getEmail())) {
			k++;
		}
		
		return k==2;
	}
	
	public String toString() {
		return nombre+" "+edad+" ("+correo+")";
	}
	
}
