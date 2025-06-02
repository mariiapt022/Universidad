package relacion2;

public class Ejercicio3 {

	public static void main(String[] args) {
		ComplejoPolar suma1,suma2,mult1,mult2;
		double magnitud1,magnitud2,real1,imag1,real2,imag2;
		ComplejoPolar x=new ComplejoPolar(0,1);
		System.out.println("x="+x);
		ComplejoPolar y=new ComplejoPolar(1,-2);
		System.out.println("y="+y);
		
		magnitud1=x.magnitud();
		System.out.println("|x|="+magnitud1);
		magnitud2=y.magnitud();
		System.out.println("|y|="+magnitud2);
		
		real1=x.real();
		System.out.println("real(x)="+real1);
		imag1=x.imaginaria();
		System.out.println("imaginaria(x)="+imag1);
		
		real2=y.real();
		System.out.println("real(y)="+real2);
		imag2=y.imaginaria();
		System.out.println("imaginaria(y)="+imag2);
		
		
		suma1=x.suma(y);
		System.out.println("x+y="+suma1);
		suma2=y.suma(x);
		System.out.println("y+x="+suma2);
		
		mult1=x.mult(y);
		System.out.println("x*y="+mult1);
		mult2=y.mult(x);
		System.out.println("y*x="+mult2);
	}

}
