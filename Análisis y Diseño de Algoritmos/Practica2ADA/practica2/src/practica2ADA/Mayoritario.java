package practica2ADA;

import java.util.Arrays;

public class Mayoritario {

	public static void main(String[] args) {
		int[] prueba1 = {1,8,7,4,1,2,2,2,2,2,2,2};
		Elemento[] a = new Elemento[prueba1.length];
		for(int i=0;i<prueba1.length;i++) {
			a[i]=new Elemento(prueba1[i],0);
		}
		
		System.out.println("Prueba1. Mayoritario (2,0)");
		System.out.println("Solucion FB: "+mayoritarioFB(a));
		System.out.println("Solucion DyV: "+mayoritarioDyV(a));
		System.out.println("Solucion Boyer-Moore: "+mayoritarioBM(a));
		
		
		//Array sin elemento mayoritario
		for(int i=0;i<prueba1.length;i++) {
			a[i]=new Elemento(i,0);
		}
		
		System.out.println("Prueba2. No hay mayoritario");
		System.out.println("Solucion FB: "+mayoritarioFB(a));
		System.out.println("Solucion DyV: "+mayoritarioDyV(a));
		System.out.println("Solucion Boyer-Moore: "+mayoritarioBM(a));
		
	}
	
	public static Elemento mayoritarioFB(Elemento[] a) {
		int i=0,cont=0;
		boolean encontrado=false;
		Elemento may = new Elemento();
		while(i<a.length&&!encontrado) {
			for(int j=0;j<a.length;j++) {
				if(a[i].equals(a[j])) {
					cont++;
				}
			}
			if(cont>a.length/2) {
				encontrado=true;
				may=a[i];
			}
			i++;
			cont=0;
		}
		
		//Comprobación
		int conta=0;
		for(int z=0;z<a.length;z++) {
			if(a[z].equals(may)) {
				conta++;
			}
		}
		if(conta>a.length/2) {
			return may;
		}else {
			return null;
		}
		
	}
	
	public static Elemento mayoritarioDyV(Elemento[] a) {
		Elemento[] b = new Elemento[a.length/2];
		int j=0;
		for(int i=0;i<a.length-1;i+=2) {
			Elemento posterior = a[i+1];
			if(a[i]!=null&&a[i].equals(posterior)) {
				b[j]=a[i];
				j++;
			}
		}
		b=Arrays.copyOf(b, j);
		if(b.length>2) {
			return mayoritarioDyV(b);
		}else if(b.length==0){
			return null;
		}else {
			return b[0];
		}
		
	}
	
	public static Elemento mayoritarioBM(Elemento[] a) {
		int i=0;
		Elemento m = new Elemento();
		for(int j=0;j<a.length;j++) {
			if(i==0) {
				m=a[j];
			}else {
				if(m.equals(a[j])) {
					i++;
				}else {
					i--;
				}
			}
		}
		//Comprobación
		int cont=0;
		for(int z=0;z<a.length;z++) {
			if(a[z].equals(m)) {
				cont++;
			}
		}
		if(cont>a.length/2) {
			return m;
		}else {
			return null;
		}
		
	}
	
	

}
