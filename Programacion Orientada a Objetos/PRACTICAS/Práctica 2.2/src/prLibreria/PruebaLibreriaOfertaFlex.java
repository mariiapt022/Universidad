package prLibreria;

public class PruebaLibreriaOfertaFlex {

	public static void main(String[] args) {
		String[] autores = {"George Orwell", "Isaac Asimov"};
		OfertaAutor ofaut = new OfertaAutor(20, autores);
		LibreriaOfertaFlex liof = new LibreriaOfertaFlex(20, ofaut);
		
		liof.addLibro("George Orwell", "1984", 8.20);
		liof.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
		liof.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
		liof.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		liof.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		liof.addLibro("Isaac Asimov", "La Fundación", 7.30);
		liof.addLibro("William Gibson", "Neuromante", 8.30);
		liof.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
		liof.addLibro("Isaac Newton", "Arithmetica Universalis", 7.50);
		liof.addLibro("George Orwell", "1984", 6.20);
		liof.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
		
		System.out.println(liof.toString());
		
		liof.remLibro("George Orwell", "1984");
		liof.remLibro("Aldous Huxley", "Un Mundo Feliz");
		liof.remLibro("Isaac Newton", "Arithmetica Universalis");
		liof.remLibro("James Gosling", "The Java Language Specification");
		
		System.out.println(liof.toString());
		
		System.out.println("PrecioFinal(\"George Orwell\", \"1984\"): " + liof.getPrecioFinal("George Orwell", "1984"));
        System.out.println("PrecioFinal(\"Philip K. Dick\", \"¿Sueñan los androides con ovejas eléctricas?\")): " + liof.getPrecioFinal("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?"));
        System.out.println("PrecioFinal(\"Isaac Asimov\", \"Fundación e Imperio\")): " + liof.getPrecioFinal("Isaac Asimov", "Fundación e Imperio"));
        System.out.println("PrecioFinal(\"Ray Bradbury\", \"Fahrenheit 451\")): " + liof.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
        System.out.println("PrecioFinal(\"Aldous Huxley\", \"Un Mundo Feliz\")): " + liof.getPrecioFinal("Aldous Huxley", "Un Mundo Feliz"));
        System.out.println("PrecioFinal(\"Isaac Asimov\", \"La Fundación\")): " + liof.getPrecioFinal("Isaac Asimov", "La Fundación"));
        System.out.println("PrecioFinal(\"William Gibson\", \"Neuromante\")): " + liof.getPrecioFinal("William Gibson", "Neuromante"));
        System.out.println("PrecioFinal(\"Isaac Asimov\", \"Segunda Fundación\")): " + liof.getPrecioFinal("Isaac Asimov", "Segunda Fundación"));
        System.out.println("PrecioFinal(\"Isaac Newton\", \"Arithmetica Universalis\")): " + liof.getPrecioFinal("Isaac Newton", "Arithmetica Universalis"));
		
		
	}

}
