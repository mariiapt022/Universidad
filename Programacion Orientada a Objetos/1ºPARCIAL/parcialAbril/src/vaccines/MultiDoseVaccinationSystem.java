package vaccines;

public class MultiDoseVaccinationSystem extends VaccinationSystem{
	
	private int numDoses;
	
	public MultiDoseVaccinationSystem(int tam,int stam) {
		super(tam);
		if(stam<=0) {
			throw new RuntimeException("Specialtam no valid");
		}else {
			numDoses=stam;
		}
		
	}
	
	@Override
	public void addPerson(String n,int a) {
		MultiDosePerson mp=new MultiDosePerson(n,a,numDoses);
		super.addPerson(mp);
	}
	
}
