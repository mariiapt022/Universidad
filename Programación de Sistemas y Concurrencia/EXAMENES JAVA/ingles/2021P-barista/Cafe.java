package june2021.psc.uma.es;

public class Cafe {
	public final int CAPACITY = 5; // Maximum of clients inside the cafe
	protected int currentClientsNum; // Current number of clients inside the cafe
	//...

	public  void enterCafe(int id) throws InterruptedException {		
		//TODO: The Client may enter into the cafe if the CAPACITY is not exceeded
		System.out.println("Client "+id+" enters. Num. clients "+currentClientsNum);
	}
	

	public  void waitCoffee(int id) throws InterruptedException {
		//TODO: The Client waits for his/her coffee to be prepared by the Barista
		System.out.println("Client "+id+" drinks a coffee");
	}
	

	public  void payAndExitCafe(int id) {
		//TODO: The Client pays to the Barista and exits from the cafe
		System.out.println("Client "+id + " pays and exits. Num. clients "+currentClientsNum);
	}
	
	
	public  void  prepareCoffee() throws InterruptedException {
		//TODO: The Barista begins to prepare coffee when there is, at least, one Client
		System.out.println("Coffee ready - waiting the money");
		//TODO: Waits until the coffee has been paid
		
		
	}
	
	


}