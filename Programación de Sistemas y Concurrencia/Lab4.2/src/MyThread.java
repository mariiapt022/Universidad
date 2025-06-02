
public class MyThread extends Thread {
	//static private SharedVariable = new SharedVariable();
	private SharedVariable sv;
	
	public MyThread(SharedVariable sv) {
		this.sv=sv;
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			sv.inc();
		}
	}
	
}
