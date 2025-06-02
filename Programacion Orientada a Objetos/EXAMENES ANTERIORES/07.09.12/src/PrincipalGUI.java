import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class PrincipalGUI {
	
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		VistaAsignacion panel = new PanelAsignacion();
		ControladorAsignacion ctr = new ControladorAsignacion(panel); // el modelo se crea dentro del controlador
		panel.controlador(ctr);
		
		JFrame ventana = new JFrame("Asignación de Plazas Infantil y Primaria");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) panel);
		ventana.pack();
		ventana.setVisible(true);
	}

}
