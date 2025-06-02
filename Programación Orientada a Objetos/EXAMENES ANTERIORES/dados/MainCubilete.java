import java.util.Iterator;
import java.util.Set;
import java.util.StringJoiner;

import dados.Cubilete;
import dados.Dado;

public class MainCubilete {
	public static void main(String[] args) {
		Cubilete cub = new Cubilete(5);
		Set<Dado> dados = cub.tira();
		System.out.println(dados);
		System.out.println(algun6(dados) ? "Ha salido al menos un 6" : "No ha salido ningún 6");
	}
	
	static boolean algun6(Set<Dado> dados) {
		boolean hay6 = false;
		Iterator<Dado> iter = dados.iterator();
				while(iter.hasNext() && ! hay6) {
			Dado d = iter.next();
			hay6 = d.getCara() == 6;
		}
		return hay6;
	}
}
