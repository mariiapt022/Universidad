package prComercio;

import java.util.Arrays;

public class PruebaComercioOferta {

	public static void main(String[] args) throws ComercioException{
		String[] h= new String[2];
		h[0]="martillo";
		h[1]="sierra";
		
		ComercioOferta C= new ComercioOferta(2,h);
		
		Herramienta a= new Herramienta("martillo",25,2.2);
		Herramienta b= new Herramienta("sierra",12,5.3);
		Herramienta c= new Herramienta("taladro",16,8.4);
		
		C.anyadir(a);
		C.anyadir(b);
		C.anyadir(c);
		
		Herramienta d= new Herramienta("Martillo",9,6.45);
		Herramienta e= new Herramienta("Sierra",6,3.25);
		Herramienta f= new Herramienta("Taladro",3,9.35);
		
		C.anyadir(d);
		C.anyadir(e);
		C.anyadir(f);
		
		System.out.println(C.toString());
		
		System.out.println(Arrays.toString(C.seleccionar(4, 10)));
		
		System.out.println(C.calcSumaPrecio(4, 10));
		
		System.out.println(C.calcSumaPrecio(100, 200));
		
		C.eliminar("martillo");
		
		System.out.println(C.toString());
		
		C.eliminar("xxx");
		
		System.out.println(C.toString());
		

	}

}
