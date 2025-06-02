package becas;

import java.io.FileNotFoundException;

public class SolicitudesBecaSinAsignar extends SolicitudesBecas{

	public SolicitudesBecaSinAsignar(String nomFich) throws FileNotFoundException {
		super(nomFich);
	}
	
	@Override
	public void agregarSolicitud(Estudiante est,Beca beca) {
		if (beca.getBecario() != null) {
			super.agregarSolicitud(est, beca);
		}
	}

}
