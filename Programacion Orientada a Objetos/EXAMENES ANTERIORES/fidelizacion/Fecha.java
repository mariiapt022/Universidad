package fidelizacion;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * La clase Fecha, disponible en el campus virtual, representa fechas,
 * incluyendo día, mes y año. Valores no válidos en los constructores y métodos
 * provocan el lanzamiento de instancias de la clase IllegalArgumentException.
 */
public class Fecha {
	private int dia;
	private int mes;
	private int ano;
	private int[] sizeIndex = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Fecha(int d, int m, int a) throws RuntimeException {
		if (m < 1 || m > 12 || d < 1 || d > diasDelMes(a, m))
			throw new IllegalArgumentException("Fecha no valida");
		dia = d;
		mes = m;
		ano = a;
	}

	// crea una fecha a partir de una cadena con formato dd/mm/aaaa
	public static Fecha parseFecha(String s) {
		try (Scanner sc = new Scanner(s)) {
			sc.useDelimiter("/");
			return new Fecha(sc.nextInt(), sc.nextInt(), sc.nextInt());
		} catch (InputMismatchException ex) {
			throw new IllegalArgumentException("Fecha no valida");
		} catch (NoSuchElementException ex) {
			throw new IllegalArgumentException("Fecha no valida");
		}
	}

	protected int diasDelMes(int a, int m) {
		return (m == 2 && bisiesto(a)) ? 29 : sizeIndex[m - 1];
	}

	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

	protected boolean bisiesto(int a) {
		return (a % 4 == 0 && !(a % 400 == 0) || (a % 400 == 0));
	}
}
