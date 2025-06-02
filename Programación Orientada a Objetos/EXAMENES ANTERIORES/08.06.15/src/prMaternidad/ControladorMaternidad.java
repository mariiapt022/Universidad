package prMaternidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;


public class ControladorMaternidad implements ActionListener{
	private Maternidad model;
	private VistaMaternidad vista;
	
	public ControladorMaternidad (VistaMaternidad v){
		vista = v;
		vista.habilitarInit(true);
		vista.mensaje("Introduzca el nombre del fichero de datos");
	}
	
	@Override
	public void actionPerformed(ActionEvent ea) {
		String command = ea.getActionCommand();
		try{
		  switch(command){
			case VistaMaternidad.INICIO:
				String entrada = vista.fichEntrada();
				if (entrada.equals(""))
					vista.error("Introduzca un nombre de fichero");
				else{
					model = new Maternidad(entrada);
					vista.habilitarInit(false);
					vista.mensaje("Datos leídos correctamente");
				}
				break;
			case VistaMaternidad.GUARDAR:
				String salida = vista.fichSalida();
				if (salida.equals(""))
					vista.entradaHistorial(model.toString());
				else
					model.escribirFichero(salida);
				vista.mensaje("Datos guardados correctamente");
				break;
			case VistaMaternidad.BUSCAR:
				int codigoHijo = vista.codigoBebe();
				int habMadre = model.encontrarMadre(codigoHijo);
				vista.entradaHistorial("La madre del niño con código "
							 		  + codigoHijo + " está en la habitación " + habMadre + "\n");
				vista.mensaje("Buscar realizado correctamente");
				break;
			case VistaMaternidad.MEDIA:
				vista.entradaHistorial("Ratio Hijos/Madres = " + model.mediaBebes() + "\n");
				vista.mensaje("Media calculada correctamente");
		  }
		}catch (IOException e){
			vista.error("Error E/S:" + e.getMessage());
		}catch (MaternidadException e){
			vista.error(e.getMessage());
		}
		
	}
	
}
