package prSeries;
import java.util.Arrays;

public class Serie {
	protected String titulo;
	protected Episodio[] serie;
	private int numEp=7;
	
	public Serie(String t, Episodio[] e) {
		titulo=t;
		serie= e;
	}
	
	public int duracionTotal() {
		int suma=0;
		for(int i=0;i<numEp;i++) {
			suma=suma+serie[i].getDuracion();
		}
		return suma;
	}
	
	public Episodio obtenerEpisodio(int capitulo) {
		int pos=-1;
		for(int i=0;i<numEp;i++) {
			if(serie[i].getCapitulo()==capitulo) {
				pos=i;
			}
		}
		if(pos==-1) {
			return null;
		}else {
			return serie[pos];
		}
	}
	
	public String toString() {
		return titulo+Arrays.toString(serie);
	}
	
	
}
