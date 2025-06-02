package prVacunas;
/*
 * Alumna: Peinado Toledo Mar�a, 
 * Titulaci�n: Doble Grado Ingenier�a Inform�tica y Matem�ticas,
 * Grupo 1
 */

public class VacunaDosisExtra extends Vacuna{
	public VacunaDosisExtra(String codigo,int viales, int dosis) {
		super(codigo,viales,dosis);
		if(viales<=0||dosis<=0) {
			throw new RuntimeException("Dosis o viales <=0");
		}
	}
	
	@Override
	public int dosisTotales() {
		int td=super.dosisTotales()+super.getViales();
		return td;
	}
	
	public String toString() {
		return super.toString()+" + "+super.getViales()+" extra";
	}
	
}
