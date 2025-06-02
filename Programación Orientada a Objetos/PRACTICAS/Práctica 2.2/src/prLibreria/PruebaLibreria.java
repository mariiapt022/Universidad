package prLibreria;
//Pr�ctica 2.2 
//Mar�a Peinado Toledo 
public class PruebaLibreria {

	public static void main(String[] args) {
		Libreria libro= new Libreria();
		
		libro.addLibro("george orwell", "1984", 8.20);
		libro.addLibro("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?", 3.50);
		libro.addLibro("Isaac Asimov", "Fundaci�n e Imperio", 9.40);
		libro.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		libro.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		libro.addLibro("Isaac Asimov", "La Fundaci�n", 7.30);
		libro.addLibro("William Gibson", "Neuromante", 8.30);
		libro.addLibro("Isaac Asimov", "Segunda Fundaci�n", 8.10);
		libro.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		libro.addLibro("George Orwell", "1984", 6.20);
		libro.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
		
		System.out.println(libro);
		
		libro.remLibro("George Orwell", "1984");
		libro.remLibro("Aldous Huxley", "Un Mundo Feliz");
		libro.remLibro("Isaac Newton", "Arithmetica Universalis");
		libro.remLibro("James Gosling", "The Java Language Specification");
		
		System.out.println(libro);
		
		System.out.println("PrecioFinal(\"George Orwell\", \"1984\"): " + libro.getPrecioFinal("George Orwell", "1984"));
        System.out.println("PrecioFinal(\"Philip K. Dick\", \"�Sue�an los androides con ovejas el�ctricas?\")): " + libro.getPrecioFinal("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?"));
        System.out.println("PrecioFinal(\"Isaac Asimov\", \"Fundaci�n e Imperio\")): " + libro.getPrecioFinal("Isaac Asimov", "Fundaci�n e Imperio"));
        System.out.println("PrecioFinal(\"Ray Bradbury\", \"Fahrenheit 451\")): " + libro.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
        System.out.println("PrecioFinal(\"Aldous Huxley\", \"Un Mundo Feliz\")): " + libro.getPrecioFinal("Aldous Huxley", "Un Mundo Feliz"));
        System.out.println("PrecioFinal(\"Isaac Asimov\", \"La Fundaci�n\")): " + libro.getPrecioFinal("Isaac Asimov", "La Fundaci�n"));
        System.out.println("PrecioFinal(\"William Gibson\", \"Neuromante\")): " + libro.getPrecioFinal("William Gibson", "Neuromante"));
        System.out.println("PrecioFinal(\"Isaac Asimov\", \"Segunda Fundaci�n\")): " + libro.getPrecioFinal("Isaac Asimov", "Segunda Fundaci�n"));
        System.out.println("PrecioFinal(\"Isaac Newton\", \"Arithmetica Universalis\")): " + libro.getPrecioFinal("Isaac Newton", "Arithmetica Universalis"));
		

	}

}
