package prMaternidad;

import java.awt.event.ActionListener;

public interface VistaMaternidad {
	public static final String INICIO = "INICIO";
	public static final String GUARDAR = "GUARDAR";
	public static final String BUSCAR = "BUSCAR";
	public static final String MEDIA = "MEDIA";
	
	/**
	 * Habilita/Deshabilita el panel de inicialización
	 * @param init Si true, se habilitan los componentes del panel de inicialización y se deshabilita el resto.
	 * 			   Si false, lo contrario.
	 */
	public void habilitarInit(boolean init);
	
	/**
	 * Muestra un mensaje informativo en el panel
	 */
	public void mensaje(String msg);
	
	/**
	 * Muestra un mensaje de error en el panel.
	 * @param msg
	 */
	public void error(String msg);
	
	/**
	 * Devuelve la ruta del fichero de entrada
	 */
	public String fichEntrada();
	
	/**
	 * Devuelve la ruta del fichero de salida
	 */
	public String fichSalida();
	
	/**
	 * Añade una cadena de texto al historial del panel
	 */
	public void entradaHistorial(String s);
	
	/** 
	 * Leer el código del hijo cuya madre queremos buscar
	 */
	public int codigoBebe();
	
	/**
	 * Registra el controlador en los componentes de la vista
	 * 
	 */
	public void controlador(ActionListener ctr);
	
}
