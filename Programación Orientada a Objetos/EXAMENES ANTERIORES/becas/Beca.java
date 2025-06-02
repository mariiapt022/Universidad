import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Beca implements Comparable<Beca> {
	/**
	 * Tipo enumerado para representar el tipo de beca
	 */
	public static enum TipoBeca {ORDINARIA, MOVILIDAD, EMPRESA};
	
	/**
	 * Variables de instancia para representar el código, la cuantía, el tipo
	 * y el beneficiario de la beca.
	 */
	private String codigo;
	private double cuantia;
	private TipoBeca tipo;
	private Estudiante becario;
	
	/**
	 * Constructor para crear becas a partir del código, la cuantía y el tipo.
	 * Inicialmente, se supone que nadie ha conseguido la beca, por lo que la 
	 * variable becario será null. Si la cuantía es negativa, se lanza la 
	 * excepción BecaException.
	 * @param cod		Código
	 * @param cantidad	Cuantía 
	 * @param t			Tipo de la beca
	 */
	public Beca(String cod, double cantidad, TipoBeca t) {
		if (cantidad < 0) throw new BecaException("Cuantía negativa de la beca");
		codigo = cod;
		cuantia = cantidad;
		tipo = t;		
		becario = null;
	}
	
	/** 
	 * Método estático que a partir de una cadena de caracteres con el formato:
	 * 		código, cantidad, tipo
	 * devuelve una beca. Si el formato no es correcto se lanzará la excepción BecaException
	 * @param beca	Cadena con el formato anterior
	 * @return		Beca con los datos de la cadena
	 */
	static public Beca nuevaBeca(String beca) {
		Scanner scBeca = new Scanner(beca);
		scBeca.useDelimiter("[, ]+");
		String cod;
		double cant;
		TipoBeca t;
		try {
			cod = scBeca.next();
			cant = scBeca.nextDouble();
			t = TipoBeca.valueOf(scBeca.next());
		} catch (InputMismatchException ime) {		// La cuantía no es un double
			throw new BecaException("Formato incorrecto para la cuantía de la beca");
		} catch (NoSuchElementException nsee) {		// No hay más elementos en el scanner
			throw new BecaException("Formato incorrecto de la información de la beca");
		} catch (IllegalArgumentException iae) {	// El tipo de beca no está entre los enumerados
			throw new BecaException("El tipo de beca no es reconocible");
		}
		return new Beca(cod,cant,t);
	}
	
	/**
	 * Devuelve el código de la beca
	 * @return	String con el código
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Devuelve la cuantía de la beca
	 * @return	Cuantía de la beca
	 */
	public double getCuantia() {
		return cuantia;
	}
	
	/**
	 * Devuelve el tipo de la beca
	 * @return	Tipo de la beca
	 */
	public TipoBeca getTipo() {
		return tipo;
	}
	
	/**
	 * Asigna el estudiante que se pasa como parámetro a la beca.
	 * Si la beca ya estaba asignada, lanza la excepción BecaExcepcion
	 * @param est	Estudiante al que se le asignará la beca
	 */
	public void asignaBeca(Estudiante est) {
		if (becario != null)
			throw new BecaException("Beca ya asignada");
		becario = est;
	}
	
	/** 
	 * Devuelve el becario asignado a la beca. Si la beca aún no está asignada, devuelve null.
	 * @return	Estudiante con la beca asignada
	 */
	public Estudiante getBecario() {
		return becario;
	}
	
	/**
	 * Dos becas son iguales cuando lo son sus códigos, la cuantía y el tipo.
	 * Se considera que la igualdad en el código no depende de mayúsculas o minúsculas.
	 */
	public boolean equals(Object obj) {
		boolean res = obj instanceof Beca;
		Beca beca = res ? (Beca) obj : null;
		return 	res &&
				codigo.equalsIgnoreCase(beca.codigo) &&
				cuantia == beca.cuantia &&
				tipo == beca.tipo;
	}

	/**
	 * El método hashCode se redefine para hacerlo consistente con equals.
	 */
	public int hashCode() {
		return codigo.toLowerCase().hashCode() + tipo.hashCode() + new Double(cuantia).hashCode();
	}
	
	/** 
	 * Una beca es menor que otra cuando lo es la cuantía. En caso de igualdad de cuantías, se considera
	 * el orden establecido por el tipo enumerado TipoBeca, y si aún coinciden, se considera el 
	 * orden lexicográfico de los códigos, independientemente de mayúsculas.
	 */
	public int compareTo(Beca beca) {
		int res = new Double(cuantia).compareTo(beca.cuantia);
		if (res == 0) {
			res = tipo.compareTo(beca.tipo);
			if (res == 0)
				res = codigo.compareToIgnoreCase(beca.codigo);
		}
		return res;
	}
	
	/**
	 * La representación textual de una beca viene dada por:
	 * 		[código, cuantía, tipo]
	 */
	public String toString() {
		return "[" + codigo + "," + cuantia + "," + tipo + "]";
	}
	
}
