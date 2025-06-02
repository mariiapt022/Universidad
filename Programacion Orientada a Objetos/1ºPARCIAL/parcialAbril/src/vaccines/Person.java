package vaccines;

public class Person {
	protected String name;
	protected int age;
	protected boolean inmunized;
	
	public Person(String n,int a) {
		if(a<0) {
			throw new RuntimeException("Edad negativa");
		}else {
			name=n;
			age=a;
			inmunized=false;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean inmunized() {
		return inmunized;
	}
	
	public void vaccinate() {
		inmunized=true;
	}
	
	public boolean equals(Person p) {
		return this.getName().equalsIgnoreCase(p.getName())&&this.getAge()==p.getAge()&&this.inmunized()==p.inmunized();
	}
	
	public String toString() {
		String res;
		if(inmunized()) {
			res= "INMUNIZED";
		}else {
			res= "NOT INMUNIZED";
		}
		return "("+name+", "+age+", "+res+")";
	}
	
	
}
