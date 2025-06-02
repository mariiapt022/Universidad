package relacion2;

public class ComplejoPolar extends ComplejoCartesiano {
	public double r,theta;
	
	public ComplejoPolar() {
		this(0,0);
	}
	
	public ComplejoPolar(double r,double theta) {
		r=this.magnitud();
		theta=Math.atan(this.partereal/this.parteimaginaria);
	}
	
	public double getReal(){
		return partereal;
	}
	
	public double getImag(){
		return parteimaginaria;
	}
	
	public ComplejoPolar suma(ComplejoPolar num) {
		ComplejoPolar res= new ComplejoCartesiano();
		double real=(this.r*Math.cos(this.theta))+(num.r*Math.cos(num.theta));
		double imaginaria=(this.r*Math.sin(this.theta))+(num.r*Math.sin(num.theta));
		res.partereal=real;
		res.parteimaginaria=imaginaria;
		return res;
	}
	
	public ComplejoPolar mult(ComplejoPolar num) {
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
