package dados;

import java.util.Set;

public class JuegoA extends Juego{
	private int suma,tam;
	
	public JuegoA(int n,int suma) {
		if (n <= 0) 
			throw new IllegalArgumentException("El número de dados del cubilete debe ser mayor que cero");
		if (suma < n || suma > 6*n)
			throw new IllegalArgumentException("La suma debe estar entre " + n + " y " + 6*n);
		tam = n;
		this.suma = suma;
	}
	
	public int simula() {
		Cubilete c=new Cubilete(tam);
		int cont=0,suma=0;
		while(suma!=this.suma) {
			cont++;
			suma=0;
			Set<Dado> dados= c.tira();
			for(Dado d:dados) {
				suma=suma+d.getCara();
			}
		}
		
		return cont;
	}
	
	
	
}
