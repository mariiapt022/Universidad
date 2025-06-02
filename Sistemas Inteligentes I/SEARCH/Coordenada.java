
public class Coordenada {
	private int x, y;
	
	public Coordenada() { x = 0; y = 0;}
	
	public Coordenada(int i, int j) { x = i; y = j;}

	public int getX() { return x;}

	public int getY() { return y;}

	public void setX(int x) { this.x = x;}

	public void setY(int y) { this.y = y;}
	
	public int heuristic(int g1, int g2) { return Math.abs(x - g1) + Math.abs(y - g2); }
	
	@Override
	public int hashCode() { return this.x+this.y;}
	
	@Override
	public boolean equals(Object o) {
		boolean x = o instanceof Coordenada;
		Coordenada item = null;
		
		if (x) {
			item = (Coordenada) o;
			
		}
		
		return x && this.x==item.getX() && this.y==item.getY();
	}
	
	@Override
	public String toString() { return this.x+"   "+this.y;}
	
}
