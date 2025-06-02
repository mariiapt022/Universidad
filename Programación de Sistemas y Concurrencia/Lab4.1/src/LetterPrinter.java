
public class LetterPrinter extends Thread {
	private int t,myId;
	private char c;
	private static int currentTurn=0;
	
	public LetterPrinter(int id,int t,char c) {
		this.myId=id;
		this.t=t;
		this.c=c;
	}
	
	
	@Override
	public void run() {
		for(int i=0;i<t;i++) {
			while(currentTurn != myId) {
				//Thread.yield();
			}
			for(int j=0;j<myId+1;j++) {
				System.out.print(c);
			}
			currentTurn=(currentTurn+1)%3;
			
		}
	}
	
	
	
	
}
