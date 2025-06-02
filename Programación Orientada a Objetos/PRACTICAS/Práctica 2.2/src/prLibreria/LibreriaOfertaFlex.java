package prLibreria;

public class LibreriaOfertaFlex extends Libreria{
	private OfertaFlex oferta;
	
	public LibreriaOfertaFlex(OfertaFlex of) {
		this(CAP_INICIAL,of);
	}
	
	public LibreriaOfertaFlex(int cap, OfertaFlex of) {
		super(cap);
		oferta=of;
	}
	
	public void setOferta(OfertaFlex of) {
		oferta=of;
	}
	
	public OfertaFlex getOferta() {
		return oferta;
	}
	
	@Override
	public void addLibro(String a, String t, double p) {
		Libro libro= new Libro(a,t,p);
		double des=oferta.getDescuento(libro);
		if(des!=0) {
			LibroOferta liof= new LibroOferta(a,t,p,des);
			this.anyadirLibro(liof);
		}else {
			this.anyadirLibro(libro);
		}
	}
	
	public String toString() {
		return oferta.toString() + "/n" + super.toString();
	}
	
}
