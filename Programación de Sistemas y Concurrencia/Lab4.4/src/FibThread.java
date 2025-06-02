
public class FibThread extends Thread {
	private int n;
	public int result;
	FibThread n1,n2;
	public FibThread(int n,FibThread n1, FibThread n2) {
		this.n=n;
		this.n1=n1;
		this.n2=n2;
	}
	
	@Override
	public void run() {
		if(n==0 || n==1) {
			result=1;
		}else {
			try {
				n1.join();
				n2.join();
				int r1=n1.result;
				int r2=n2.result;
				result = r1+r2;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
