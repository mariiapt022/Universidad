
public class Main {

	public static void main(String[] args) throws InterruptedException {
		SharedVariable sv=new SharedVariable();
		MyThread a= new MyThread(sv);
		MyThread b= new MyThread(sv);
		
		a.start();
		b.start();
		a.join();
		b.join();
		System.out.println(sv.get());
		

	}

}
