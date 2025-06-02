package dados;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cubilete {
	private List<Dado> dados;
	
	public Cubilete(int tam) {
		if(tam<=0) {
			throw new IllegalArgumentException("Numero de dados no valido");
		}
		dados=new ArrayList<>();
		for(int i=0;i<tam;i++) {
			dados.add(new Dado());
		}
	}
	
	public Set<Dado> tira(){
		Set<Dado> res= new HashSet<>();
		for(Dado d:dados) {
			d.agita();
			res.add(d);
		}
		return res;
	}
	
	
}
