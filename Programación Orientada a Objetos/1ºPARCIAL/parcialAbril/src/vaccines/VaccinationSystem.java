package vaccines;
import java.util.Arrays;

public class VaccinationSystem {
	protected int vaccines;
	protected Person[] persons;
	
	public VaccinationSystem(int tam) {
		if(tam<=0) {
			throw new RuntimeException("Tamaño no válido");
		}else {
			vaccines=0;
			persons= new Person[tam];
		}
	}
	
	private int seekPerson(String n,int a) {
		int i=0;
		boolean encontrado=false;
		while(!encontrado&&i<persons.length) {
			if(persons[i]!=null&&persons[i].getName().equalsIgnoreCase(n)&&persons[i].getAge()==a) {
				encontrado=true;
			}else {
				i++;
			}
		}
		
		return encontrado? i: -1;
	}
	
	private int firstFree() {
		int i=0;
		while(i<persons.length&&persons[i]!=null) {
			i++;
		}
		if(i==persons.length) {
			persons=Arrays.copyOf(persons, persons.length*2);
		}
		return i;
	}
	
	
	protected void addPerson(Person p) {
		int pos=seekPerson(p.getName(),p.getAge());
		if(pos==-1) {
			pos=firstFree();
			persons[pos]=p;
		}
	}
	
	public void addPerson(String n,int a) {
		Person per=new Person(n,a);
		addPerson(per);
	}
	
	public void removePerson(String n,int a) {
		int pos=seekPerson(n,a);
		if(pos!=-1) {
			persons[pos]=null;
		}
	}
	
	public void buyVaccines(int q) {
		if(q>0) {
			vaccines=vaccines+q;
		}
	}
	
	public void vaccinate(int minAge,int maxAge) {
		int k=0;
		while(vaccines!=0&&k<persons.length) {
			if(persons[k]!=null&&persons[k].getAge()>=minAge&&persons[k].getAge()<=maxAge&&!persons[k].inmunized()) {
				persons[k].vaccinate();
				vaccines--;
			}
			k++;
		}
	}
	
	public String toString() {
		return "Vaccines: "+vaccines+" "+Arrays.toString(persons);
	}
	
	
}
