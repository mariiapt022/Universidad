
public class Initialize {
	private char[][] maze;
	private Coordenada initial;
	private Coordenada goal;
	
	public Initialize(char[][] a, Coordenada b, Coordenada c) {
		maze = a;
		initial= b;
		goal = c;
	}

	public char[][] getMaze() { return maze;}

	public void setMaze(char[][] maze) { this.maze = maze;}

	public Coordenada getInitial() { return initial;}

	public void setInitial(Coordenada initial) { this.initial = initial;}

	public Coordenada getGoal() { return goal;}

	public void setGoal(Coordenada goal) { this.goal = goal;}
}
