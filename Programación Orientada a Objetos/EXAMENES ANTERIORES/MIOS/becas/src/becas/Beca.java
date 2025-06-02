package becas;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Beca implements Comparable<Beca> {
	private String codigo;
	public static enum TipoBeca {ORDINARIA, MOVILIDAD, EMPRESA};
	private TipoBeca tipo;
	private double cuantia;
	private Estudiante becario;
	
	public Beca(String c,double cu,TipoBeca b) {
		if(cu<0) {
			throw new BecasException("Cuant�a no valida");
		}
		codigo=c;
		cuantia=cu;
		tipo=b;
		becario=null;
	}

	public String getCodigo() {
		return codigo;
	}

	public TipoBeca getTipo() {
		return tipo;
	}

	public double getCuantia() {
		return cuantia;
	}

	public Estudiante getBecario() {
		return becario;
	}
	
	public void asignaBeca(Estudiante est) {
		if(becario!=null) {
			throw new BecasException("Beca ya asignada");
		}
		becario=est;
	}
	
	public static Beca nuevaBeca(String info) {
		try(Scanner sc=new Scanner(info)){
			sc.useDelimiter(", ");
			sc.useLocale(Locale.ENGLISH);
			String codigo=sc.next();
			double cuantia=sc.nextDouble();
			TipoBeca tipo=TipoBeca.valueOf(sc.next());
			return new Beca(codigo,cuantia,tipo);
		}catch (InputMismatchException ime) {		// La cuantía no es un double
			throw new BecasException("Formato incorrecto para la cuantía de la beca");
		} catch (NoSuchElementException nsee) {		// No hay más elementos en el scanner
			throw new BecasException("Formato incorrecto de la información de la beca");
		} catch (IllegalArgumentException iae) {	// El tipo de beca no está entre los enumerados
			throw new BecasException("El tipo de beca no es reconocible");
		}
	}
	
	
	@Override 
	public boolean equals(Object o) {
		boolean res=o instanceof Beca;
		Beca b=res?(Beca)o:null;
		return res&&codigo.equals(b.getCodigo())&&cuantia==b.getCuantia()&&tipo.equals(b.getTipo());
	}
	public int hashCode() {
		return codigo.hashCode()+tipo.hashCode()+Double.hashCode(cuantia);
	}
	
	public int compareTo(Beca b) {
		int res=Double.compare(cuantia, b.getCuantia());
		if(res==0) {
			res=tipo.compareTo(b.getTipo());
		}
		if(res==0) {
			res=codigo.compareToIgnoreCase(b.getCodigo());
		}
		return res;
	}
	
	public String toString() {
		return "["+codigo+", "+cuantia+", "+tipo+"]";
	}
		
}
