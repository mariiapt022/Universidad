package prMaternidad;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGUI {
	public static void main(String [] args){
		VistaMaternidad panel = new PanelMaternidad();
		ActionListener ctr = new ControladorMaternidad(panel); 
		panel.controlador(ctr);
		
		JFrame ventana = new JFrame("Servicio de Maternidad");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) panel);
		ventana.pack();
		ventana.setVisible(true);
	}
}
