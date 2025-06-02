package prRegata;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelRegata extends JPanel implements VistaRegata {
	JTextField jtfFicheroEntrada;
	JTextField jtfFicheroSalida;
	JButton jbLee;
	JButton jbAvanza;
	JButton jbGuarda;
	JTextArea jtaTexto;
	JLabel jlMensaje;
	
	public PanelRegata() {
		setLayout(new BorderLayout());
		jtfFicheroEntrada = new JTextField(20);
		jtfFicheroEntrada.setBorder(BorderFactory.createTitledBorder("Nombre Fichero Entrada"));
		jtfFicheroSalida = new JTextField(20);
		jtfFicheroSalida.setBorder(BorderFactory.createTitledBorder("Nombre Fichero Salida"));
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new FlowLayout());
		panelNorte.add(jtfFicheroEntrada);
		panelNorte.add(jtfFicheroSalida);
		add(panelNorte, BorderLayout.NORTH);

		jbLee = new JButton("Lee");
		jbAvanza = new JButton("Avanza");
		jbGuarda = new JButton("Guarda");
		JPanel jpDerecho = new JPanel();
		jpDerecho.setLayout(new BoxLayout(jpDerecho, BoxLayout.Y_AXIS));
		jpDerecho.add(jbLee);
		jpDerecho.add(jbAvanza);
		jpDerecho.add(jbGuarda);
		add(jpDerecho, BorderLayout.EAST);
		
		jtaTexto = new JTextArea(30,70);
		add(new JScrollPane(jtaTexto), BorderLayout.CENTER);
		
		jlMensaje = new JLabel(" ");
		add(jlMensaje, BorderLayout.SOUTH);
	}
	
	/* (non-Javadoc)
	 * @see prNautica.VistaRegata#getFichero()
	 */
	@Override
	public String getFicheroEntrada() {
		return jtfFicheroEntrada.getText();
	}

	@Override
	public String getFicheroSalida() {
		return jtfFicheroSalida.getText();
	}

	/* (non-Javadoc)
	 * @see prNautica.VistaRegata#agregaLinea(java.lang.String)
	 */
	@Override
	public void agregaLinea(String linea) {
		jtaTexto.append(linea+"\n");
	}
	
	/* (non-Javadoc)
	 * @see prNautica.VistaRegata#limpiaPantalla()
	 */
	@Override
	public void limpiaPantalla() {
		jtaTexto.setText("");
	}
	
	/* (non-Javadoc)
	 * @see prNautica.VistaRegata#setMensaje(java.lang.String)
	 */
	@Override
	public void setMensaje(String msg) {
		jlMensaje.setText(msg);
	}
	
	public void controlador(ActionListener ctr) {
		jbLee.setActionCommand(VistaRegata.LEE);
		jbLee.addActionListener(ctr);
		jbGuarda.setActionCommand(VistaRegata.GUARDA);
		jbGuarda.addActionListener(ctr);
		jbAvanza.setActionCommand(VistaRegata.AVANZA);
		jbAvanza.addActionListener(ctr);
	}
}
