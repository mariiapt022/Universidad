/**
 * Clase que representa estudiantes
 *
 */
public class Estudiante implements Comparable<Estudiante> {
	/** 
	 * Variables de instancia que representan el nombre del estudiante, 
	 * la nota media que el estudiante posee y la renta familiar.
	 */
	private String nombre;
	private double notaMedia;
	private double rentaFamiliar;
	
	/**
	 * Constructor para crear estudiantes a partir de un nombre, nota media y renta
	 * @param nom	Nombre del estudiante
	 * @param nota	Nota media 
	 * @param renta	Renta familiar
	 */
	public Estudiante(String nom, double nota, double renta) {
		nombre = nom;
		notaMedia = nota;
		rentaFamiliar = renta;
	}
	
	/** 
	 * Devuelve el nombre del estudiante
	 * @return	Nombre del estudiante
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve la nota media del estudiante
	 * @return	Nota media del estudiante
	 */
	public double getNotaMedia() {
		return notaMedia;
	}
	
	/**
	 * Devuelve la renta familiar del estudiante
	 * @return	Renta familiar del estudiante
	 */
	public double getRentaFamiliar() {
		return rentaFamiliar;
	}
	
	/** 
	 * Dos estudiantes se consideran iguales cuando tienen el mismo nombre (sin distinguir entre
	 * mayúsculas y minúsculas), la misma nota media y la misma renta familiar.
	 */
	public boolean equals(Object obj) {
		boolean res = obj instanceof Estudiante;
		Estudiante est = res ? (Estudiante) obj : null;
		return res 	&& nombre.equalsIgnoreCase(est.nombre)
					&& notaMedia == est.notaMedia
					&& rentaFamiliar == est.rentaFamiliar;
	}
	
	/**
	 * El método hashCode() se redefine de forma adecuada.
	 */
	public int hashCode() {
		return 	nombre.toLowerCase().hashCode() + 
				new Double(notaMedia).hashCode() + 
				new Double(rentaFamiliar).hashCode();
	}
	
	/** 
	 * Se define un orden natural que establece que un estudiante es menor que otro cuando 
	 * su nombre lo es lexicográficamente (independientemente de mayúsculas y minúsculas). En
	 * caso d eigualdad de nombres, se utiliza la nota media como forma de comparación y si aún hay c
	 * coincidencias, la renta familiar.
	 */
	public int compareTo(Estudiante est) {
		int res = nombre.compareToIgnoreCase(est.nombre);
		if (res==0) {
			res = new Double(notaMedia).compareTo(est.notaMedia);
			if (res == 0)
				res = new Double(rentaFamiliar).compareTo(est.rentaFamiliar);
		}
		return res;
	}
	
	/**
	 * La representación textual de un estudiante viene dada por:
	 * 		nombre(notaMedia,rentaFamiliar)
	 */
	public String toString() {
		return nombre + " (" + notaMedia + "," + rentaFamiliar + ")";
	}
}
