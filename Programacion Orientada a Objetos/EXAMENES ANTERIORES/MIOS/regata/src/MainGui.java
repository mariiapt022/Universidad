import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import regata.CtrRegata;
import regata.PanelRegata;
import regata.VistaRegata;

public class MainGui {
	public static void main(String [] args) {
		VistaRegata vistaRegata = new PanelRegata();
		ActionListener ctrRegata = new CtrRegata(vistaRegata);
		vistaRegata.controlador(ctrRegata);
		
		JFrame ventana = new JFrame("Regata");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel)vistaRegata) ;
		ventana.pack();
		ventana.setVisible(true);
	}
}
