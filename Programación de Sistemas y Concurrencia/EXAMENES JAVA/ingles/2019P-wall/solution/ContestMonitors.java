package es.uma.galvez.midterm2019.solution;

import es.uma.galvez.midterm2019.Contest;

public class ContestMonitors extends Contest {
	private boolean ready[] = {false, false};
	private boolean go[] = {false, false};
	
	private int bricksPut[] = {0, 0};
	private int setsWon[] = {0, 0};
	
		// Fill here
	
	@Override
	public synchronized void putBrick(int id) throws InterruptedException {
		if (! isSetFinished()) {
			bricksPut[id]++;
			System.out.println(id + " puts a brick: "+bricksPut[id]);
			if (isSetFinished()) {
				if (bricksPut[0] == bricksPut[1]) {
					System.out.println("Set tie");
				} else {
					int winner = (bricksPut[0] > bricksPut[1])? 0 : 1;
					System.out.println("Set winner is "+ winner);
					setsWon[winner]++;
					if (isContestFinished()) {
						System.out.println("CONTEST finished: "+ setsWon[0] + " : " + setsWon[1]);
						if (setsWon[0] > setsWon[1])
							System.out.println("WINNER is 0.");
					else if (setsWon[1] > setsWon[0])
							System.out.println("WINNER is 1.");
					}
				}
			}
		}
	}
	

	@Override
	public synchronized void readySteadyGo(int id) throws InterruptedException {
		ready[id] = true;
		notify();
		while(! ready[opposite(id)])
			wait();
		ready[opposite(id)] = false;
		
		bricksPut[0] = bricksPut[1] = 0; 
		System.out.println("Worker "+id+" ready to go.");

		go[id] = true;
		notify();
		while(! go[opposite(id)])
			wait();
		go[opposite(id)] = false;
	}
	

	@Override
	public synchronized boolean isSetFinished() throws InterruptedException {
		return bricksPut[0] + bricksPut[1] == WALL_LENGTH;
	}

	@Override
	public synchronized boolean isContestFinished() throws InterruptedException {
		return setsWon[0] + setsWon[1] == THRESHOLD_WINNER;
	}
}
