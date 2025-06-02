import java.awt.event.ActionListener;


public interface VistaAsignacion {
	public static final String INICIAR_ASIGNACION = "INICIAR_ASIGNACION";
	public static final String INICIAR_ASIGNACION_FAMILIAR = "INICIAR_ASIGNACION_FAMILIAR";
	public static final String ASIGNAR = "ASIGNAR";
	public static final String FINALIZAR = "FINALIZAR";
	
	/**
	 * Pasamos el controlador.
	 */
	public void controlador(ActionListener ctr);
	
	/**
	 * Obtenemos el fichero con los datos de las solicitudes de plaza.
	 * @return String con el nombre de fichero de las solicitudes.
	 */
	public String ficheroSolicitudes();
	
	/**
	 * Obtenemos el fichero de salida con los solicitantes con plaza.
	 * @return String con el nombre de fichero de salida.
	 */
	public String ficheroSalidaConPlaza();

	/**
	 * Obtenemos el fichero de salida con los solicitantes sin plaza.
	 * @return String con el nombre de fichero de salida.
	 */
	public String ficheroSalidaSinPlaza();

	/**
	 * Obtenemos el n�mero de plazas de I3
	 * @return int con el n�mero de plazas de I3
	 */
	public int plazasI3();

	/**
	 * Obtenemos el n�mero de plazas de I4
	 * @return int con el n�mero de plazas de I4
	 */
	public int plazasI4();

	/**
	 * Obtenemos el n�mero de plazas de I5
	 * @return int con el n�mero de plazas de I5
	 */
	public int plazasI5();

	/**
	 * Obtenemos el n�mero de plazas de P1
	 * @return int con el n�mero de plazas de P1
	 */
	public int plazasP1();

	/**
	 * Obtenemos el n�mero de plazas de P2
	 * @return int con el n�mero de plazas de P2
	 */
	public int plazasP2();

	/**
	 * Obtenemos el n�mero de plazas de P3
	 * @return int con el n�mero de plazas de P3
	 */
	public int plazasP3();

	/**
	 * Obtenemos el n�mero de plazas de P4
	 * @return int con el n�mero de plazas de P4
	 */
	public int plazasP4();

	/**
	 * Obtenemos el n�mero de plazas de P5
	 * @return int con el n�mero de plazas de P5
	 */
	public int plazasP5();

	/**
	 * Obtenemos el n�mero de plazas de P6
	 * @return int con el n�mero de plazas de P6
	 */
	public int plazasP6();
	
	/**
	 * Mostramos un mensaje de error.
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void error(String mensaje);
	
	/**
	 * Mostramos un mensaje de informaci�n.
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void ok(String mensaje);
	
	/**
	 * Habilitamos o deshabilitamos el modo inicializaci�n o asignaci�n de plazas
	 * @param b
	 *       true para habilitar el modo inicializaci�n; false para el modo asignaci�n de plazas
	 */
	public void habilitarInicio(boolean b);
	
	/**
	 * A�adimos un mensaje al hist�rico.
	 * @param mensaje
	 *            String con el mensaje a a�adir.
	 */
	public void a�adirAHist�rico(String mensaje);
	
	/**
	 * Limpiamos el hist�rico.
	 */
	public void limpiar();
}
