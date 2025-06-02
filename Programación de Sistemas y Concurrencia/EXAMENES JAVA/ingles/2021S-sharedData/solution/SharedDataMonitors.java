package es.uma.psc;

public class SharedDataMonitors implements SharedData {
	private int datum; 					// Datum to process
	private int numProcessors; 			// Total amount of processors
	private int remainingProcessors;   	// Remaining amount of processors to manage the datum
	
	private boolean canGenerate;
	private boolean canProcess;
	private boolean availableDatum[];
	public SharedDataMonitors(int numProcessors) {
		if (numProcessors <=0) throw new IllegalArgumentException();
		
		this.numProcessors = numProcessors;
		canProcess = false; 
		canGenerate = false;
		availableDatum = new boolean[numProcessors];
		for (int i=0; i<numProcessors; i++) {
			availableDatum[i]  = false;
		}
	}
	
	/* The Generator stores a datum to be processed, notifies the Processors that they may begin 
	 * to process the datum and, thereafter, waits for them to finish before putting a new datum
	 * 
	 *  CS_Generator: Once the datum is stored, the Generator waits for every Processor to process it before generating a new one
	 */
	public synchronized int generateData(int datum) throws InterruptedException {
		// Stores the datum to be processed
		this.datum = datum;
		System.out.println("Datum to process: " + datum);
		// Initialize the remaining processors that have to process the datum
		remainingProcessors = numProcessors;
		System.out.println("Amount of remaining processors: " + remainingProcessors);
		// Notify that a new datum is available
		for (int i=0; i<numProcessors; i++)
			availableDatum[i] = true;
		canProcess = true;
		notifyAll();
		
		// Waits for every processor to process the datum
		while (! canGenerate)
			wait();
		canGenerate = false;
		return this.datum;
	}

	/* The processors waits to process the datum. 
	 * A datum is processed by a single processor each time
	 * Once the processor with identifier id processes the datum, it cannot process it again 
	 * and it has to wait for the generator to generate a new one
	 * 
	 *  CS1-Processor. A Processor waits if there is no new datum to process. This may happen because the Generator has not put yet any datum or because that datum has already been processed by that Processor
	 *  CS2-Processor. A Processor waits if there is a datum to process but other Processor is processing it.
	 */
	public synchronized int readData(int id) throws InterruptedException {
		while (!availableDatum[id]) wait();
		availableDatum[id] = false;
		while (!canProcess) wait();
		canProcess = false;
		return datum;
	}
	
	/* The processor updates the datum and notifies either another processors 
	 * or the generator that it has finished.
	 * 
	 * - If there are remaining processors then it notifies them
	 * - Otherwise, it notifies the generator
	 * 
	 */
	public synchronized void updateData(int id, int newValue) throws InterruptedException {
		datum = newValue;
		remainingProcessors--;
		System.out.println("\tProcessor " + id + " has processed the datum. New datum: " + datum);
		System.out.println("Number of remaining processors: " + remainingProcessors);
		if (remainingProcessors == 0) 
			canGenerate = true; 
		else
			canProcess = true;
		notifyAll();
	}
}
