package prControl2063;

public class SelectorPrecio implements Selector{
	private double min,max;
	public SelectorPrecio(double i,double a) {
		min=i;
		max=a;
	}
	
	@Override
	public boolean esSeleccionable(Ropa r) {
		return r.getPrecio()>=min&&r.getPrecio()<max;
	}
	
	public String toString() {
		return "S["+min+", "+max+")";
	}
	
}
