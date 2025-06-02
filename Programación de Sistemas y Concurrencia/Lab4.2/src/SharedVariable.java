
public class SharedVariable {
	private int v=0;
	public int get() {
		return v;
	}
	public void set(int v) {
		this.v=v;
	}
	public void inc() {
		this.v++;
	}
}
