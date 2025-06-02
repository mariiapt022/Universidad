package prLibreria;
//Pr�ctica 2.3
//Mar�a Peinado Toledo 
public class PruebaLibreriaOferta {

	public static void main(String[] args) {
		String[] autoresOferta = {"George Orwell", "Isaac Asimov"};
        LibreriaOferta liof = new LibreriaOferta(8, 20, autoresOferta);
        
        liof.addLibro("George Orwell", "1984", 6.20);
        liof.addLibro("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?", 3.50);
        liof.addLibro("Isaac Asimov", "Fundaci�n e Imperio", 9.40);
        liof.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
        liof.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
        liof.addLibro("Isaac Asimov", "La Fundaci�n", 7.30);
        liof.addLibro("William Gibson", "Neuromante", 8.30);
        liof.addLibro("Isaac Asimov", "Segunda Fundaci�n", 8.10);
        liof.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
        liof.addLibro("George Orwell", "1984", 6.20);
        liof.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
        
        System.out.println(liof.toString());
        
        liof.remLibro("George Orwell", "1984");
        liof.remLibro("Aldous Huxley", "Un Mundo Feliz");
        liof.remLibro("Isaac Newton", "Arithmetica Universalis");
        liof.remLibro("James Gosling", "The Java Language Specification");
        
        System.out.println(liof.toString());
        
        System.out.println("PrecioFinal(\"George Orwell\", \"1984\"): " + liof.getPrecioFinal("George Orwell", "1984"));
        System.out.println("PrecioFinal(\"Philip K. Dick\", \"�Sue�an los androides con ovejas el�ctricas?\")): " + liof.getPrecioFinal("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?"));
        System.out.println("PrecioFinal(\"Isaac Asimov\", \"Fundaci�n e Imperio\")): " + liof.getPrecioFinal("Isaac Asimov", "Fundaci�n e Imperio"));
        System.out.println("PrecioFinal(\"Ray Bradbury\", \"Fahrenheit 451\")): " + liof.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
        System.out.println("PrecioFinal(\"Aldous Huxley\", \"Un Mundo Feliz\")): " + liof.getPrecioFinal("Aldous Huxley", "Un Mundo Feliz"));
        System.out.println("PrecioFinal(\"Isaac Asimov\", \"La Fundaci�n\")): " + liof.getPrecioFinal("Isaac Asimov", "La Fundaci�n"));
        System.out.println("PrecioFinal(\"William Gibson\", \"Neuromante\")): " + liof.getPrecioFinal("William Gibson", "Neuromante"));
        System.out.println("PrecioFinal(\"Isaac Asimov\", \"Segunda Fundaci�n\")): " + liof.getPrecioFinal("Isaac Asimov", "Segunda Fundaci�n"));
        System.out.println("PrecioFinal(\"Isaac Newton\", \"Arithmetica Universalis\")): " + liof.getPrecioFinal("Isaac Newton", "Arithmetica Universalis"));
        
	}

}
