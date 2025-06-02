package es.uma.psc;

public interface SharedData {

	/* The Generator stores a datum to be processed, notifies the Processors that they may begin 
	 * to process the datum and, thereafter, waits for them to finish before putting a new datum
	 * 
	 *  CS_Generator: Once the datum is stored, the Generator waits for every Processor to process it before generating a new one
	 */
	public int generateData(int datum) throws InterruptedException;
	
	/* The processors waits to process the datum. 
	 * A datum is processed by a single processor each time
	 * Once the processor with identifier id processes the datum, it cannot process it again 
	 * and it has to wait for the generator to generate a new one
	 * 
	 *  CS1-Processor. A Processor waits if there is no new datum to process. This may happen because the Generator has not put yet any datum or because that datum has already been processed by that Processor
	 *  CS2-Processor. A Processor waits if there is a datum to process but other Processor is processing it.
	 */
	public int readData(int id) throws InterruptedException;
	
	/* The processor updates the datum and notifies either another processors 
	 * or the generator that it has finished.
	 * 
	 * - If there are remaining processors then it notifies them
	 * - Otherwise, it notifies the generator
	 * 
	 */
	public void updateData(int id, int newValue) throws InterruptedException;
	
}
