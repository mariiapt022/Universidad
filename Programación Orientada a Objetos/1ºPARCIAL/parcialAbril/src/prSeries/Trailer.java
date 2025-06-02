package prSeries;

public class Trailer extends Episodio{
	public Trailer(String t,int d) throws SerieException {
		super(0,t,d);
		if(d>5) {
			throw new SerieException("Trailer muy largo");
		}
	}
}
