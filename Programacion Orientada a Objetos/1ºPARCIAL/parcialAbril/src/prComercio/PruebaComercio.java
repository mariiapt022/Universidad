package prComercio;

import java.util.Arrays;

public class PruebaComercio {

	public static void main(String[] args) throws ComercioException {
		
		Comercio A= new Comercio(2);
		Herramienta a= new Herramienta("martillo",25,2.2);
		Herramienta b= new Herramienta("sierra",12,5.3);
		Herramienta c= new Herramienta("taladro",16,8.4);
		
		A.anyadir(a);
		A.anyadir(b);
		A.anyadir(c);
		
		Herramienta d= new Herramienta("Martillo",9,6.45);
		Herramienta e= new Herramienta("Sierra",6,3.25);
		Herramienta f= new Herramienta("Taladro",3,9.35);
		
		A.anyadir(d);
		A.anyadir(e);
		A.anyadir(f);
		
		System.out.println(A.toString());
		
		System.out.println(Arrays.toString(A.seleccionar(4, 10)));
		
		System.out.println(A.calcSumaPrecio(4, 10));
		
		System.out.println(A.calcSumaPrecio(100, 200));
		
		A.eliminar("martillo");
		
		System.out.println(A.toString());
		
		A.eliminar("xxx");
		
		System.out.println(A.toString());
		
		
	}

}
