package covid;
//Mar�a Peinado Toledo. Doble Grado Ingenier�a Inform�tica y Matem�ticas. Grupo A
public class DistritoSanitario implements Comparable<DistritoSanitario>{
	private String nombre;
	private int poblacion,positivos;
	
	public DistritoSanitario(String n,int pobl,int pos) {
		if(pobl<=0||pos<0) {
			throw new COVIDException("Datos err�neos para DistritoSanitario");
		}
		nombre=n;
		poblacion=pobl;
		positivos=pos;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public int getPositivos() {
		return positivos;
	}
	
	public void setPositivos(int num) {
		if(num<0) {
			throw new COVIDException("N�mero de positivos no v�lido");
		}
		positivos=num;
	}
	
	public int incidenciaAcumuluda() {
		return positivos/100000;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof DistritoSanitario;
		DistritoSanitario d=res? (DistritoSanitario)o:null;
		return res&&nombre.equalsIgnoreCase(d.getNombre());
	}
	public int hashCode() {
		return nombre.toUpperCase().hashCode();
	}
	
	public int compareTo(DistritoSanitario d) {
		return nombre.compareToIgnoreCase(d.getNombre());
	}
	
	public String toString() {
		return "Distrito("+nombre+","+positivos+")";
	}
	
	
}
