
public class Gen {
	private int row, column;
	
	public Gen(int f, int p) {
		row = f;
		column = p;
	}
	
	public int getRow() { return row; }

	public int getColumn() { return column; }

	public void setRow(int row) { this.row = row; }

	public void setColumn(int position) { this.column = position; }
	
	@Override
	public int hashCode() { return this.row+this.column; }
	
	@Override
	public boolean equals(Object o) {
		boolean x = o instanceof Gen;
		Gen item = null;
		if (x) { item = (Gen) o;}
		return x && this.row==item.getRow() && this.column==item.getColumn();
	}

}
