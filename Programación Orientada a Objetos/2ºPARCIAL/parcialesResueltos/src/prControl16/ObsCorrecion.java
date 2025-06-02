package prControl16;

import java.util.Arrays;

public class ObsCorrecion extends Observaciones{
	private Correcion[] obsc;
	
	public ObsCorrecion() {
		super();
	}
	public ObsCorrecion(int tam) {
		super(tam);
	}
	public ObsCorrecion(Correcion[] c) {
		super();
		obsc=c;
	}
	
	private int buscarCorrecion(String o) {
		int i=0;
		boolean encontrado=false;
		while(i<obsc.length&&!encontrado) {
			if(obsc[i]!=null&&o.equalsIgnoreCase(super.getObs(i).getObs())) {
				encontrado=true;
			}else {
				i++;
			}
		}
		
		return encontrado? i: -1;
	}
	
	@Override
	public double getMoe(String o,String e) {
		double moe=super.getMoe(o, e);
		int pos=buscarCorrecion(o);
		return moe*obsc[pos].getCo();
	}
	@Override
	public double getMe(String e) {
		double suma=0;
		int n=0;
		for(int i=0;i<super.getNObs();i++) {
			if(super.getObs(i).getEst().equalsIgnoreCase(e)) {
				suma=suma+getMoe(super.getObs(i).getObs(),e);
				n++;
			}
		}
		return suma/n;
	}
	
	@Override
	public String toString() {
		return super.toString()+Arrays.toString(obsc);
	}
	
}
