package midterm2020.galvez.uma.es;

class Passenger extends Thread {
	private PassengerType type;
	private int id;
	private Bus b;

	Passenger(Bus b, PassengerType pasType, int id) {
		this.type = pasType;
		this.id = id;
		this.b = b;
	}

	@Override
	public void run() {
		try {
			b.waitDisinfection();
			b.onBoardAmbulance(this.type, id);
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
}
