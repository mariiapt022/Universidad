
public class Tiempo implements Comparable<Tiempo> {
	private int horas, minutos, segundos;
	
	public Tiempo() {
		this(0,0,0);
	}
	
	public Tiempo(int h, int m, int s) {
		if (h < 0 || m < 0 || m > 59 || s < 0 || s >59) {
			throw new IllegalArgumentException("Tiempo errónea "+ h + ":" + m + ":" + s);
		}
		horas = h;
		minutos = m;
		segundos = s;
	}
	
	public void incrementa(Tiempo t) {
		// Alternativa:
		// int segundosTotales = (horas+t.horas)*3600 + (minutos+t.minutos)*60 + segundos+t.segundos;
		// horas = segundosTotales / 3600;
		// minutos = (segundosTotales % 3600) / 60;
		// segundos = (segundosTotales % 3600) % 60;
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
	
	public boolean equals(Object o) {
		boolean res = o instanceof Tiempo;
		Tiempo t = res ? (Tiempo) o : null;
		return res && horas == t.horas && minutos == t.minutos && segundos == t.segundos;
	}
	
	public int hashCode() {
		return new Integer(horas).hashCode() + new Integer(minutos).hashCode()
				+ new Integer(segundos).hashCode();

	}
	
	public String toString() {
		String hh = conDosPosiciones(horas);
		String mm = conDosPosiciones(minutos);
		String ss = conDosPosiciones(segundos);
		return hh + ":" + mm + ":" + ss;
	}
	
	private String conDosPosiciones(int tt) {
		return (tt < 10 ? "0" : "") + tt;
	}
	
	public int compareTo(Tiempo tiempo) {
		// Alterativa:
		// int res = (horas-tiempo.horas)*3600 + (minutos-tiempo.minutos)*60 + segundos-tiempo.segundos;
		int res = horas - tiempo.horas;
		if (res == 0) {
			res = minutos - tiempo.minutos;
			if (res == 0) 
				res = segundos - tiempo.segundos;
		}
		return res;
	}
}
