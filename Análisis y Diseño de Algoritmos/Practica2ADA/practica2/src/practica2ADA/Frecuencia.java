package practica2ADA;

public class Frecuencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void frecElems(Elemento[] a) {
		int[] frec=new int[a.length];
		for(int j=0;j<a.length;j++) {
			int pos= posDyV(a,a[j]);
			frec[a[i]]=pos-i+1;
			
		}
	}
	
	public int posDyV(Elemento[] a,Elemento num) {
		boolean encontrado=false;
		int i = a.length-1,pos=0;
		while(i>=0&&!encontrado) {
			if(a[i].equals(num)) {
				encontrado=true;
				pos=i;
			}
			i--;
		}
		return pos;
	}
	
}
