package prVacunas;
/*
 * Alumna: Peinado Toledo María, 
 * Titulación: Doble Grado Ingeniería Informática y Matemáticas,
 * Grupo 1
 */

public class PruebaVacuna {

	public static void main(String[] args) {
		Vacuna v1= new Vacuna("Moderna-001",100,5);
		Vacuna v2= new Vacuna("AstraZeneca-001",200,8);
		Vacuna v3= new Vacuna("astrazeneca-001",160,10);
		
		System.out.println("El número total de dosis de la vacuna "+v1+" es "+v1.dosisTotales());
		System.out.println("El número total de dosis de la vacuna "+v2+" es "+v2.dosisTotales());
		System.out.println("El número total de dosis de la vacuna "+v3+" es "+v3.dosisTotales());
		
		boolean iguales1=v2.getCodigo().equalsIgnoreCase(v3.getCodigo())&&v2.dosisTotales()==v3.dosisTotales();
		String res1=iguales1? " ": " no ";
		System.out.println("Las vacunas "+v2+" y "+v3 + res1+"son iguales");
		
		boolean iguales2=v1.getCodigo().equalsIgnoreCase(v2.getCodigo())&&v1.dosisTotales()==v2.dosisTotales();
		String res2=iguales2? "": " no ";
		System.out.println("Las vacunas "+v1+" y "+v2 + res2+"son iguales");
		
	}

}
