import vaccines.Person;
import vaccines.VaccinationSystem;
import vaccines.MultiDoseVaccinationSystem;

public class VaccinationTest {
	public static void main(String[] args) {
		Person[] persons = { new Person("Alberto Gomez", 64), 
				             new Person("Maria Abad", 50),
				             new Person("Sara Campos", 80), 
				             new Person("Jorge Tellez", 25), 
				             new Person("Rafael Sanchez", 75),
				             new Person("Alicia Gutierrez", 82) };

		System.out.println("\nSingle-dose vaccination system");
		VaccinationSystem s = new VaccinationSystem(5);
		addPersons(s, persons);
		s.addPerson("ALICIA Gutierrez", 40);
		System.out.println(s);
		s.removePerson("Maria Abad", 50);
		System.out.println(s);
		s.vaccinate(0, 100);
		System.out.println(s);
		s.buyVaccines(20);
		s.vaccinate(60, 100);
		System.out.println(s);

		System.out.println("\nMultiple-dose vaccination system");
		MultiDoseVaccinationSystem sd = new MultiDoseVaccinationSystem(5, 2);
		addPersons(sd, persons);
		System.out.println(sd);
		s.removePerson("Maria Abad", 50);
		System.out.println(s);
		sd.buyVaccines(20);
		sd.vaccinate(60, 100);
		System.out.println("First dose shot. No one immunized yet.");
		System.out.println(sd);
		sd.vaccinate(60, 100);
		System.out.println("Second dose shot. Immunized group of people between 60 and 100 years.");
		System.out.println(sd);
	}

	private static void addPersons(VaccinationSystem s, Person personas[]) {
		for (int i = 0; i < personas.length; i++) 
			s.addPerson(personas[i].getName(), personas[i].getAge());
	}
}
/*
 * Salida esperada: 

Single-dose vaccination system
Vaccines: 0 [(Alberto Gomez, 64, NOT IMMUNIZED), (Maria Abad, 50, NOT IMMUNIZED), (Sara Campos, 80, NOT IMMUNIZED), (Jorge Tellez, 25, NOT IMMUNIZED), (Rafael Sanchez, 75, NOT IMMUNIZED), (Alicia Gutierrez, 82, NOT IMMUNIZED), (ALICIA Gutierrez, 40, NOT IMMUNIZED), null, null, null]
Vaccines: 0 [(Alberto Gomez, 64, NOT IMMUNIZED), null, (Sara Campos, 80, NOT IMMUNIZED), (Jorge Tellez, 25, NOT IMMUNIZED), (Rafael Sanchez, 75, NOT IMMUNIZED), (Alicia Gutierrez, 82, NOT IMMUNIZED), (ALICIA Gutierrez, 40, NOT IMMUNIZED), null, null, null]
Vaccines: 0 [(Alberto Gomez, 64, NOT IMMUNIZED), null, (Sara Campos, 80, NOT IMMUNIZED), (Jorge Tellez, 25, NOT IMMUNIZED), (Rafael Sanchez, 75, NOT IMMUNIZED), (Alicia Gutierrez, 82, NOT IMMUNIZED), (ALICIA Gutierrez, 40, NOT IMMUNIZED), null, null, null]
Vaccines: 16 [(Alberto Gomez, 64,  IMMUNIZED), null, (Sara Campos, 80,  IMMUNIZED), (Jorge Tellez, 25, NOT IMMUNIZED), (Rafael Sanchez, 75,  IMMUNIZED), (Alicia Gutierrez, 82,  IMMUNIZED), (ALICIA Gutierrez, 40, NOT IMMUNIZED), null, null, null]

Multiple-dose vaccination system
Vaccines: 0 [(Alberto Gomez, 64, NOT IMMUNIZED), (Maria Abad, 50, NOT IMMUNIZED), (Sara Campos, 80, NOT IMMUNIZED), (Jorge Tellez, 25, NOT IMMUNIZED), (Rafael Sanchez, 75, NOT IMMUNIZED), (Alicia Gutierrez, 82, NOT IMMUNIZED), null, null, null, null]
Vaccines: 16 [(Alberto Gomez, 64,  IMMUNIZED), null, (Sara Campos, 80,  IMMUNIZED), (Jorge Tellez, 25, NOT IMMUNIZED), (Rafael Sanchez, 75,  IMMUNIZED), (Alicia Gutierrez, 82,  IMMUNIZED), (ALICIA Gutierrez, 40, NOT IMMUNIZED), null, null, null]
First dose shot. No one immunized yet.
Vaccines: 16 [(Alberto Gomez, 64, NOT IMMUNIZED), (Maria Abad, 50, NOT IMMUNIZED), (Sara Campos, 80, NOT IMMUNIZED), (Jorge Tellez, 25, NOT IMMUNIZED), (Rafael Sanchez, 75, NOT IMMUNIZED), (Alicia Gutierrez, 82, NOT IMMUNIZED), null, null, null, null]
Second dose shot. Immunized group of people between 60 and 100 years.
Vaccines: 12 [(Alberto Gomez, 64,  IMMUNIZED), (Maria Abad, 50, NOT IMMUNIZED), (Sara Campos, 80,  IMMUNIZED), (Jorge Tellez, 25, NOT IMMUNIZED), (Rafael Sanchez, 75,  IMMUNIZED), (Alicia Gutierrez, 82,  IMMUNIZED), null, null, null, null]
 */