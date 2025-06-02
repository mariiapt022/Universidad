package prControl16;

import java.util.Arrays;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Observaciones {
	private final static int TAM_INICIAL=16;
	private int numObs;
	private Observación[] obs;
	
	public Observaciones() {
		this(TAM_INICIAL);
	}
	
	public Observaciones(int tam) {
		numObs=0;
		obs=new Observación[tam];
	}
	
	public void addObs(Observación o) {
		int pos=buscarObservacion(o);
		if(pos==-1) {
			if(numObs==obs.length) {
				obs=Arrays.copyOf(obs, numObs+1);
			}
			obs[numObs]=o;
			numObs++;
		}else {
			obs[pos]=o;
		}
		obs=Arrays.copyOf(obs, numObs);
	}
	
	protected int buscarObservacion(Observación o) {
		int i=0;
		boolean encontrado=false;
		
		while(i<numObs&&!encontrado) {
			if(obs[i]!=null&&obs[i].equals(o)) {
				encontrado=true;
			}else {
				i++;
			}
		}
		
		return encontrado? i: -1;
	}
	
	public void addObs(String o) throws IllegalArgumentException{
		if(numObs==obs.length) {
			obs=Arrays.copyOf(obs, numObs+1);
		}
		String estrella,observacion;
		double magnitud;
		
		try (Scanner sc=new Scanner(o)){
			sc.useDelimiter("[;]");
			sc.useLocale(Locale.ENGLISH);
			observacion=sc.next();
			estrella=sc.next();
			magnitud=sc.nextDouble();
			Observación ob=new Observación(observacion,estrella,magnitud);
			addObs(ob);
		}
		
	}
	
	public int getNObs() {
		return numObs;
	}
	
	public Observación getObs(int pos) {
		return obs[pos];
	}
	
	public double getMoe(String o,String e) throws NoSuchElementException{
		Observación a=new Observación(o,e,0);
		int pos=buscarObservacion(a);
		if(pos==-1) {
			throw new NoSuchElementException();
		}else {
			return obs[pos].getMag();
		}
	}
	
	public double getMe(String e) throws NoSuchElementException {
		double suma=0;
		int n=0;
		for(int i=0;i<numObs;i++) {
			if(obs[i].getEst().equalsIgnoreCase(e)) {
				suma=suma+obs[i].getMag();
				n++;
			}
		}
		if(n==0) {
			throw new NoSuchElementException();
		}else {
			return suma/n;
		}
	}
	
	public String toString() {
		return Arrays.toString(obs);
	}
	
	
	
	
	
	
	
	
	
	
}
