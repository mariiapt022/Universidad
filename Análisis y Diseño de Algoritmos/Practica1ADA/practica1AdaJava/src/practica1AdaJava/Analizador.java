package practica1AdaJava;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Analizador {
	
	public static int algoritmo1(int n) {
		//n>0
		if (n<=2) return 1;
		else return algoritmo1(n-1) + algoritmo1(n-2);
	}
	
	public void algoritmo2(int[] a) {
		for(int i=0;i<a.length;i++) {
			int suma=0;
			for(int j=0;j<a.length;j++) {
				suma+=a[j];
			}
			a[i]=suma;
		}
	}
	
	public static void main(String[] args) {
		int [] tamEntrada = {1,2,3,4,5,10,15,20,25,30,35,40};
		int numPruebas = tamEntrada.length;
		long [] t1 = new long [numPruebas];
		long [] t2 = new long [numPruebas];
		
		Temporizador reloj = new Temporizador(Temporizador.NANO);
		//Fichero de salida
		try(PrintWriter fich1 = new PrintWriter(fileName: "algoritmo1.csv");
				PrintWriter fich2 = new PrintWriter(fileName: "algoritmo2.csv");
				){
			fich1.println("Tam_N,Tiempo");
			fich2.println("Tam_N,Tiempo");
			for(int prueba=0;prueba<numPruebas;prueba++) {
				//Algoritmo 1
				algoritmo1(tamEntrada[prueba]);
				reloj.reiniciar();
				reloj.iniciar();
				algoritmo1(tamEntrada[prueba]);
				reloj.parar();
				t1[prueba]=reloj.tiempoPasado();
				fich1.print(tamEntrada[prueba]);
				fich1.print(",");
				fich1.println(t1[prueba]);
				
				//Algoritmo2
				int [] datos = new int[tamEntrada[prueba]];
				for(int i=0;i<tamEntrada[prueba];i++) {
					datos[i]=i;
				}
				
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error al crear el fichero de salida");
		}
		

	}

}
