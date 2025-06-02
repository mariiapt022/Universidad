package relacion2;

public class ComplejoCartesiano {
	public double partereal, parteimaginaria;
	
	public ComplejoCartesiano() {
		this(0,0);
	}
	
	public ComplejoCartesiano(double real, double imag) {
		partereal=real;
		parteimaginaria=imag;
	}
	
	public double getReal(){
		return partereal;
	}
	
	public double getImag(){
		return parteimaginaria;
	}
	
	public ComplejoCartesiano suma(ComplejoCartesiano num) {
		ComplejoCartesiano res= new ComplejoCartesiano();
		double real=this.partereal+num.partereal;
		double imaginaria=this.parteimaginaria+num.parteimaginaria;
		res.partereal=real;
		res.parteimaginaria=imaginaria;
		return res;
	}
	
	public ComplejoCartesiano mult(ComplejoCartesiano num) {
		ComplejoCartesiano res= new ComplejoCartesiano();
		double real=(this.partereal*num.partereal)-(this.parteimaginaria*num.parteimaginaria);
		double imaginaria=(this.partereal*num.parteimaginaria)+(this.parteimaginaria*num.partereal);
		res.partereal=real;
		res.parteimaginaria=imaginaria;
		return res;
	}
	
	public double magnitud() {
		double res;
		res=Math.sqrt((Math.pow(this.partereal, 2))+(Math.pow(this.parteimaginaria, 2)));
		return res;
	}
	
	public double real() {
		double res;
		res=this.partereal;
		return res;
	}
	
	public double imaginaria() {
		double res;
		res=this.parteimaginaria;
		return res;
	}

	
	@Override
	public String toString() {
		String resul;
		if(parteimaginaria==0) {
			resul=partereal+" ";
		}else if(parteimaginaria>0) {
			resul=partereal+"+"+parteimaginaria+"i";
		}else {
			resul=partereal+"-"+Math.abs(parteimaginaria)+"i";
		}
		
		return resul;
	}
	
	
	
}
