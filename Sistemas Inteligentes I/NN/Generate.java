package benchmark;

public class Generate {
	public static double valorRandom() {
		return (Math.random() * 2 *Math.PI) - Math.PI;
	}
	public static double generaF(double x, double y) {
		return Math.sin(x) * Math.cos(y);
	}
	public static double[] [] generaMatrix(){
		double [] [] res = new double [1000] [2];
		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < 2; j++) {
				res[i][j] = valorRandom();
			}
		}
		return res;
	}
	public static double [][] generagrid(){
		double [][]res = new double [10000] [2];
		double k = 2 * Math.PI/99;
		for(int i = 0; i < 10000; i++) {
			res[i][0] = -Math.PI + 2 * (Math.PI)*((double)(i%100)/(double) (99));
			res[i][1] = -Math.PI + 2 * (Math.PI)*((double)(i/100)/(double) (99));
		}
		
		return res;
	}
}
