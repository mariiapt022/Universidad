package vuelos;

public class Vuelo implements Comparable<Vuelo>{
	private String nombre,codigo,aeOrigen,aeDestino;
	private Hora hora;
	private int duracion;
	
	public Vuelo(String n,String c,Hora h,int d,String o,String de) {
		if(n==null||c==null||d<0||o==null||de==null) {
			throw new VuelosException("Datos no validos para vuelo");
		}else {
			nombre=n;
			codigo=c;
			hora=h;
			duracion=d;
			aeOrigen=o;
			aeDestino=de;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getAeOrigen() {
		return aeOrigen;
	}

	public String getAeDestino() {
		return aeDestino;
	}

	public Hora getHora() {
		return hora;
	}

	public int getDuracion() {
		return duracion;
	}
	
	public Hora horaLlegada() {
		return hora.horaTrasMinutos(duracion);
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res=o instanceof Vuelo;
		Vuelo v=res?(Vuelo)o:null;
		return res&&aeOrigen.equalsIgnoreCase(v.getAeDestino())&&aeDestino.equalsIgnoreCase(v.getAeDestino())&&codigo.equalsIgnoreCase(v.getCodigo());
	}
	
	public int hashCode() {
		return aeOrigen.hashCode()+aeDestino.hashCode()+codigo.hashCode();
	}
	
	public int compareTo(Vuelo v) {
		int res=aeOrigen.compareToIgnoreCase(v.getAeOrigen());
		if(res==0) {
			res=aeDestino.compareToIgnoreCase(v.getAeDestino());
		}
		if(res==0) {
			res=codigo.compareToIgnoreCase(v.getCodigo());
		}
		return res;
	}
	
	public String toString() {
		return codigo.toUpperCase()+": "+aeOrigen+" -> "+aeDestino+" ("+hora+", "+duracion+" min.)";
	}
	
	
}
