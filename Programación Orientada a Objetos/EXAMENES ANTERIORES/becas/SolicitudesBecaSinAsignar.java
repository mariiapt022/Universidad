import java.io.FileNotFoundException;


public class SolicitudesBecaSinAsignar extends SolicitudesBeca {
	
	/**
	 * Constructor para crear instancias de la clase a partir de la información del fichero que
	 * se pasa como argumento.
	 * @param fichero	Fichero con información sobre las becas disponibles
	 * @throws FileNotFoundException
	 */
	public SolicitudesBecaSinAsignar(String fichero) throws FileNotFoundException {
		super(fichero);
	}

	/**
	 * Añade al estudiante como solicitante de la beca si ésta no se ha asignado ya.
	 * En caso contrario, no tiene ningún efecto.
	 * Estamos suponiendo que la beca que se utiliza como segundo argumento es exactamente
	 * la misma que aparece en el map con las solicitudes. De no ser así, habría que haber
	 * localizado entre las solicitudes, la beca que es igual (equals) a "beca" para 
	 * comprobar si tiene un becario ya asignado.
	 */
	public void agregarSolicitud(Estudiante est, Beca beca) {
		if (beca.getBecario() != null) super.agregarSolicitud(est, beca);
	}
	
}
