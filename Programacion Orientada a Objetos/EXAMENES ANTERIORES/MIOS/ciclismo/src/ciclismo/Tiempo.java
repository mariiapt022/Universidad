package ciclismo;

public class Tiempo implements Comparable<Tiempo>{
	private int horas,minutos,segundos;
	
	public Tiempo(int h,int m,int s) {
		if(h<0||m<0||s<0||h>23||m>59||s<59) {
			throw new IllegalArgumentException("Formato de tiempo no válido");
		}else {
			horas=h;
			minutos=m;
			segundos=s;
		}
	}
	
	public Tiempo() {
		this(0,0,0);
	}
	
	public void incrementa(Tiempo t) {
		segundos += t.segundos;
		if (segundos >= 60) {
			minutos++;
			segundos -=60;
		}
		minutos += t.minutos;
		if (minutos >= 60) {
			horas++;
			minutos -= 60;
		}
		horas += t.horas;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res=o instanceof Tiempo;
		Tiempo t=res?(Tiempo)o:null;
		return res&&horas==t.horas&&minutos==t.minutos&&segundos==t.segundos;
	}
	public int hashCode() {
		return Integer.hashCode(horas+minutos+segundos);
	}
	
	public int compareTo(Tiempo t) {
		int res=Integer.compare(horas, t.horas);
		if(res==0) {
			res=Integer.compare(minutos, t.minutos);
		}
		if(res==0) {
			res=Integer.compare(segundos, t.segundos);
		}
		return res;
	}
	
	public String toString() {
		return horas+":"+minutos+":"+segundos;
	}
	
	
}
