package prSept20;

public class Practica implements Comparable<Practica>{
	
	private final String nombre,descripcion;
	private int cntRealizadas,cntExito;
	
	public Practica(String n,String d) {
		this(n,d,0,0);
	}
	
	public Practica(String n,String d,int r,int e) {
		if(n==null||d==null||r<0||e<0) {
			throw new AppException("Datos erroneos para la practica");
		}else {
			nombre=n;
			descripcion=d;
			cntRealizadas=r;
			cntExito=e;
		}
	}

	public String getNombre() {
		return nombre;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	
	public int getCntRealizadas() {
		return cntRealizadas;
	}

	public void setCntRealizadas(int cntRealizadas) {
		if(cntRealizadas<0) {
			throw new AppException("CntRealizadas negativo");
		}else {
			this.cntRealizadas = cntRealizadas;
		}
	}

	public int getCntExito() {
		return cntExito;
	}

	public void setCntExito(int cntExito) {
		if(cntExito<0) {
			throw new AppException("CntExito negativo");
		}else {
			this.cntExito = cntExito;
		}		
	}
	
	public int getPorcExito() {
		int res;
		if(cntRealizadas==0) {
			res=0;
		}else {
			res=(100*cntExito)/(cntRealizadas);
		}
		return res;
	}
	
	public String toString() {
		return "("+nombre+", "+descripcion+", "+cntRealizadas+", "+cntExito+", "+this.getPorcExito()+"%)";
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Practica;
		Practica p=res? (Practica)o: null;
		return res&&nombre.equalsIgnoreCase(p.getNombre())&&descripcion.equalsIgnoreCase(p.getDescripcion());
	}
	
	public int hashCode() {
		return nombre.hashCode()+descripcion.hashCode();
	}
	
	
	public int compareTo(Practica p) {
		int res=nombre.compareToIgnoreCase(p.getNombre());
		if(res==0) {
			res=descripcion.compareToIgnoreCase(p.getDescripcion());
		}
		return res;
	}
	
}
