package es.uma.galvez.midterm2019.solution;

import java.util.concurrent.Semaphore;

import es.uma.galvez.midterm2019.Contest;

public class ContestSemaphores extends Contest {
	
	private Semaphore ready[] = {
				new Semaphore(0, true),
				new Semaphore(0, true)
			};
	private Semaphore go[] = {
			new Semaphore(0, true),
			new Semaphore(0, true)
		};
	private Semaphore mutex = new Semaphore(1, true);

	private int bricksPut[] = {0, 0};
	private int setsWon[] = {0, 0};
	
	@Override
	public void putBrick(int id) throws InterruptedException {
		mutex.acquire();
		if (! isSetFinishedPrivate()) {
			bricksPut[id]++;
			System.out.println(id + " puts a brick: "+bricksPut[id]);
			if (isSetFinishedPrivate()) {
				if (bricksPut[0] == bricksPut[1]) {
					System.out.println("Set tie");
				} else {
					int winner = (bricksPut[0] > bricksPut[1])? 0 : 1;
					System.out.println("Set winner is "+ winner);
					setsWon[winner]++;
					if (isContestFinishedPrivate()) {
						System.out.println("CONTEST finished: "+ setsWon[0] + " : " + setsWon[1]);
						if (setsWon[0] > setsWon[1])
							System.out.println("WINNER is 0.");
					else if (setsWon[1] > setsWon[0])
							System.out.println("WINNER is 1.");
					}
				}
			}
		}
		mutex.release();
	}
	

	@Override
	public void readySteadyGo(int id) throws InterruptedException {
		ready[opposite(id)].release();
		ready[id].acquire();
		mutex.acquire();
		
		bricksPut[0] = bricksPut[1] = 0; 
		System.out.println("Worker "+id+" ready to go.");

		mutex.release();
		go[opposite(id)].release();
		go[id].acquire();
	}
	

	@Override
	public boolean isSetFinished() throws InterruptedException {
		mutex.acquire();
		boolean ret = isSetFinishedPrivate();
		mutex.release();
		return ret;
	}

	@Override
	public boolean isContestFinished() throws InterruptedException {
		mutex.acquire();
		boolean ret = isContestFinishedPrivate();
		mutex.release();
		return ret;
	}
	
	private boolean isSetFinishedPrivate() throws InterruptedException {
		return bricksPut[0] + bricksPut[1] == WALL_LENGTH;
	}

	private boolean isContestFinishedPrivate() throws InterruptedException {
		return setsWon[0] + setsWon[1] == THRESHOLD_WINNER;
	}
}
