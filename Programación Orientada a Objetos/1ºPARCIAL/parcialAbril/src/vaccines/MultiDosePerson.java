package vaccines;

public class MultiDosePerson extends Person{
	private int requiredDoses,shotDoses;
	
	public MultiDosePerson(String n, int a, int r) {
		super(n,a);
		if(r<=0) {
			throw new RuntimeException("Required doses no valid");
		}else {
			shotDoses=0;
			requiredDoses=r;
		}
	}
	
	@Override
	public void vaccinate() {
		shotDoses++;
		if(shotDoses==requiredDoses) {
			super.vaccinate();
		}
	}
	
	
}
