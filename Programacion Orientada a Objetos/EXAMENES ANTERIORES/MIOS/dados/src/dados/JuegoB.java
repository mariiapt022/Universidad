package dados;

import java.util.Set;

public class JuegoB extends Juego{
	private int num,tam;
	public JuegoB(int n,int numSeises) {
		if (n <= 0) 
			throw new IllegalArgumentException("El número de dados del cubilete debe ser mayor que 0");
		if (numSeises < 0)
			throw new IllegalArgumentException("El número de seises no puede ser negativo");
		tam = n;
		num = numSeises;
	}
	
	public int simula() {
		Cubilete c=new Cubilete(tam);
		int n6=0,cont=0;
		while(n6<num) {
			cont++;
			Set<Dado> dados=c.tira();
			for(Dado d:dados) {
				if(d.getCara()==6) {
					n6++;
				}
			}
		}
		return cont;
	}

	
}
