package relacion2;

public class NumeroRacional {
	private int  numerador, denominador;
	
	public NumeroRacional(){
		this(0,1);
	}
	
	public NumeroRacional(int num, int den){
		if(den==0) {
			throw new RuntimeException("Error. Denominador 0");
		}
		numerador=num;
		denominador=den;
		this.reducir();
	}
	
	public int getNumerador() {
		return numerador;
	}
	public int getDenominador() {
		return denominador;
	}
	
	private int mcd(int num1,int num2) {
		int res;
		if(num1==0) {
			res=num2;
		}else if(num2==0) {
			res=num1;
		}else {
			num1=Math.abs(num1);
			num2=Math.abs(num2);
			
			while(num1 != num2) {
				if(num1>num2) {
					num1=num1-num2;
				}else {
					num2=num2-num1;
				}
			}
			res=num1;
		}
		return res;
	}
	
	private int mcm(int num1,int num2) {
		return((num1*num2)/mcd(num1,num2));
	}
	
	private void reducir() {
		int x=mcd(numerador,denominador);
		if(x!=1) {
			numerador=numerador/x;
			denominador=denominador/x;
		}
		if((denominador<0)&&(numerador<0)) {
			denominador=Math.abs(denominador);
			numerador=Math.abs(numerador);
		}
		if((denominador<0)) {
			denominador=Math.abs(denominador);
			numerador=numerador*-1;
		}
	}
	
	public NumeroRacional mult(NumeroRacional num) {
		NumeroRacional res=new NumeroRacional();
		res.numerador=this.numerador*num.numerador;
		res.denominador=this.denominador*num.denominador;
		res.reducir();
		return res;
	}
	
	public NumeroRacional div(NumeroRacional num) {
		NumeroRacional res=new NumeroRacional();
		res.numerador=this.numerador*num.denominador;
		res.denominador=this.denominador*num.numerador;
		res.reducir();
		return res;
	}
	
	public NumeroRacional suma(NumeroRacional num) {
		NumeroRacional res=new NumeroRacional();
		int min=mcm(this.denominador,num.denominador);
		int primer=this.numerador*min/this.denominador;
		int segundo=num.numerador*min/num.denominador;
		res.numerador=primer+segundo;
		res.denominador=min;
		res.reducir();
		return res;
	}
	
	public NumeroRacional resta(NumeroRacional num) {
		NumeroRacional res=new NumeroRacional();
		int min=mcm(this.denominador,num.denominador);
		int primer=this.numerador * min/this.denominador;
		int segundo=num.numerador* min/num.denominador;
		res.numerador=primer-segundo;
		res.denominador=min;
		res.reducir();
		return res;
	}
	
	@Override
	public String toString() {
		String resul;
		if(denominador==1) {
			resul=Integer.toString(numerador);
		}else {
			resul=numerador+"/"+denominador;
		}
		return resul;
	}
	
	
}
