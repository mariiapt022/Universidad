import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;

//DE MOMENTO NO SE DA LA OPCION DE MOSTRAR O BIEN ALFABETICAMENTE O POR PUNTOS.
//ADAPTAR CUANDO SE TOME UNA DECISIÓN
public class ControladorAsignacion implements ActionListener {

	private VistaAsignacion vista;
	private Colegio asignacion; // modelo
	
	public ControladorAsignacion(VistaAsignacion v) {
		vista = v;
		vista.ok("Introduzca nombre de ficheros y pulse Botón Iniciar preferido");
		vista.habilitarInicio(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		try {
			if (comando.equals(VistaAsignacion.INICIAR_ASIGNACION)) {
				asignacion = new Colegio(vista.ficheroSolicitudes());
				vista.ok("Datos leídos correctamente. Puede iniciar la asignación");
				vista.habilitarInicio(false);
			} else if (comando.equals(VistaAsignacion.INICIAR_ASIGNACION_FAMILIAR)) {
				asignacion = new ColegioFamiliar(vista.ficheroSolicitudes());
				vista.ok("Datos leídos correctamente. Puede iniciar la asignación familiar");
				vista.habilitarInicio(false);
			} else if (comando.equals(VistaAsignacion.ASIGNAR)) {
				asignacion.limpiar();
				Map<String,Integer> plazas = new TreeMap<String,Integer>();
				if (vista.plazasI3() > 0) plazas.put("I3",vista.plazasI3());
				if (vista.plazasI4() > 0) plazas.put("I4",vista.plazasI4());
				if (vista.plazasI5() > 0) plazas.put("I5",vista.plazasI5());
				if (vista.plazasP1() > 0) plazas.put("P1",vista.plazasP1());
				if (vista.plazasP2() > 0) plazas.put("P2",vista.plazasP2());
				if (vista.plazasP3() > 0) plazas.put("P3",vista.plazasP3());
				if (vista.plazasP4() > 0) plazas.put("P4",vista.plazasP4());
				if (vista.plazasP5() > 0) plazas.put("P5",vista.plazasP5());
				if (vista.plazasP6() > 0) plazas.put("P6",vista.plazasP6());
				
				asignacion.asignarPlazas(plazas);
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				asignacion.mostrarSolicitantes(true, pw);
				pw.close();
				vista.añadirAHistórico(sw.toString());
				asignacion.mostrarSolicitantes(true,vista.ficheroSalidaConPlaza());
				asignacion.mostrarSolicitantes(false, vista.ficheroSalidaSinPlaza());
				vista.ok("Salida correcta en pantalla y en fichero");
			} else if (comando.equals(VistaAsignacion.FINALIZAR)) {
				vista.limpiar();
				vista.ok("Introduzca nombre de ficheros y pulse Botón Iniciar preferido");
				vista.habilitarInicio(true);
			} 
		} catch (AsignacionException exc) {
			vista.error("ERROR: " + exc.getMessage());
		} catch (IOException exc) {
			vista.error("ERROR de Entrada/Salida: " + exc.getMessage());
		} catch (NullPointerException exc) {
			exc.printStackTrace();
			vista.error("ERROR: faltan datos por introducir");
		}
	}

}
