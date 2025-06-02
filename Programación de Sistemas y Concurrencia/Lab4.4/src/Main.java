
public class Main {
	
	private static final int N=5;
	
	public static void main(String[] args) throws InterruptedException {
		FibThread n1=null,n2=null;
		for(int i=0;i<N+1;i++) {
			FibThread n= new FibThread(i,n1,n2);
			n.start();
			n2=n1;
			n1=n;
		}
		n1.join();
		System.out.println(n1.result);
	}

}
