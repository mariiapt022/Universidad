package rutas;

public class Lugar {
	private String nombre;
	private double latitud,longitud;
	
	public Lugar(String n,double a,double o) {
		if(n==null||a<-90||a>90||o<-180||o>180) {
			throw new RutasException("Datos no válidos para el lugar");
		}else {
			nombre=n;
			latitud=a;
			longitud=o;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String n) {
		if(n==null) {
			throw new RutasException("Nombre no valido");
		}else {
			nombre=n;
		}
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	@Override
	public boolean equals(Object o) {
		boolean res= o instanceof Lugar;
		Lugar l=res?(Lugar)o:null;
		return res&&nombre.equalsIgnoreCase(l.getNombre())&&latitud==l.getLatitud()&&longitud==l.getLongitud();
	}
	
	public int hashCode() {
		return nombre.hashCode()+Double.hashCode(latitud)+Double.hashCode(longitud);
	}
	
	public double distancia(Lugar l1) {
		return Haversine.distancia(latitud, longitud, l1.getLatitud(), l1.getLongitud());
	}
	
	public String toString() {
		return nombre.toUpperCase()+":"+latitud+","+longitud;
	}
	
}
