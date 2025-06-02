package dados;

import java.util.Iterator;
import java.util.Set;

public class MainCubilete {

	public static void main(String[] args) {
		Cubilete c=new Cubilete(5);
		Set<Dado> dados=c.tira();
		System.out.println(dados);
		
		boolean res=false;
		Iterator<Dado> it= dados.iterator();
		while(!res&&it.hasNext()) {
			if(it.next().getCara()==6) {
				res=true;
			}
		}
		if(res) {
			System.out.println("Ha salido al menos un 6");
		}else {
			System.out.println("No ha salido ningun 6");
		}
		
		
	}

}
