package es.uma.psc;

public class Processor extends Thread{
	private SharedData sharedData;
	private int id, numData;
	
	public Processor(int id, int numData, SharedData sharedData) {
		this.sharedData = sharedData;
		this.id = id;
		this.numData = numData;
	}
	
	public void run() {
		int d;
		for (int i=0; i<numData; i++) try {
			// In protocol
			d = sharedData.readData(id);
			// Processing
			d = d+1;
			// Out protocol
			sharedData.updateData(id, d);
		} catch (InterruptedException e) {  e.printStackTrace(); }
	}
}
