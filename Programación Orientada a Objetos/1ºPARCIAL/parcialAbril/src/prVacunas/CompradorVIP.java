package prVacunas;

public class CompradorVIP extends Comprador {
	private double descuento;
	private final static int TAM_INICIAL=10;
	
	public CompradorVIP(String n,int tam,double d) {
		super(n,tam);
		if(d<0) {
			throw new RuntimeException("Descuento menor que 0");
		}
		descuento=d;
	}
	
	public CompradorVIP(String n,double d) {
		this(n,TAM_INICIAL,d);
		if(d<0) {
			throw new RuntimeException("Descuento menor que 0");
		}
		descuento=d;
	}
	
	@Override
	public double precioTotal() {
		double res=super.precioTotal()-super.precioTotal()*(descuento/100);
		return res;
	}
	
}
