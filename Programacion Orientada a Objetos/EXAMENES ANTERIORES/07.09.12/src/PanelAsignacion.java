import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class PanelAsignacion extends JPanel implements VistaAsignacion {

	private JTextField fichSolicitudes, fichSalidaConPlaza, fichSalidaSinPlaza;
	private JTextField i3, i4, i5, p1, p2, p3, p4, p5, p6;
	private JButton iniciarAsig, iniciarAsigF, asignar, finalizar;
	private JLabel mensaje;
	private JTextArea historico;
	
	public PanelAsignacion() {
		// panel norte
				JPanel norte = new JPanel();
				norte.setLayout(new FlowLayout());
				
				JLabel fE = new JLabel("Fichero Solicitudes");
				fichSolicitudes = new JTextField(10);
				
				iniciarAsig = new JButton("Iniciar Asignación");
				
				iniciarAsigF = new JButton("Iniciar Asignación Familiar");
								
				JPanel eq = new JPanel();
				eq.add(fE);
				eq.add(fichSolicitudes);
					
				norte.add(eq);
				norte.add(iniciarAsig);
				norte.add(iniciarAsigF);
			
		// panel central
				
				// zona de asignación
								
				JPanel numeroPlazas = new JPanel();
				//numeroPlazas.setLayout(new GridLayout(3,3,5,5));
				i3 = new JTextField(10);
				i3.setText("0");
				i3.setBorder(new TitledBorder("I3"));
				i4 = new JTextField(10);
				i4.setText("0");
				i4.setBorder(new TitledBorder("I4"));
				i5 = new JTextField(10);
				i5.setBorder(new TitledBorder("I5"));
				i5.setText("0");
				p1 = new JTextField(10);
				p1.setBorder(new TitledBorder("P1"));
				p1.setText("0");
				p2 = new JTextField(10);
				p2.setBorder(new TitledBorder("P2"));
				p2.setText("0");
				p3 = new JTextField(10);
				p3.setBorder(new TitledBorder("P3"));
				p3.setText("0");
				p4 = new JTextField(10);
				p4.setBorder(new TitledBorder("P4"));
				p4.setText("0");
				p5 = new JTextField(10);
				p5.setBorder(new TitledBorder("P5"));
				p5.setText("0");
				p6 = new JTextField(10);
				p6.setBorder(new TitledBorder("P6"));
				p6.setText("0");
				
				numeroPlazas.add(i3);
				numeroPlazas.add(i4);
				numeroPlazas.add(i5);
				numeroPlazas.add(p1);
				numeroPlazas.add(p2);
				numeroPlazas.add(p3);
				numeroPlazas.add(p4);
				numeroPlazas.add(p5);
				numeroPlazas.add(p6);
				
				JPanel salidaDatos = new JPanel();
				JLabel salidaCP = new JLabel("Fichero de Salida Solicitantes con Plaza:");
				fichSalidaConPlaza = new JTextField(10);
				JLabel salidaSP = new JLabel("Fichero de Salida Solicitantes sin Plaza:");
				fichSalidaSinPlaza = new JTextField(10);

				salidaDatos.add(salidaCP);
				salidaDatos.add(fichSalidaConPlaza);
				salidaDatos.add(salidaSP);
				salidaDatos.add(fichSalidaSinPlaza);

				
				finalizar = new JButton("Finalizar");
							
				
				asignar = new JButton("Realizar Asignación");
				
				
				JPanel zonaAsignacion = new JPanel();
				zonaAsignacion.setLayout(new GridLayout(4,1,5,5));
				zonaAsignacion.add(asignar);
				zonaAsignacion.add(numeroPlazas);
				zonaAsignacion.add(salidaDatos);
				zonaAsignacion.add(finalizar);
				
				
				// area de texto en panel central
				historico =  new JTextArea();
				JScrollPane historicoScroll = new JScrollPane(historico);
				// creacion de panel central
				JPanel central = new JPanel();
				central.setLayout(new GridLayout(2,1,5,5));
				central.add(zonaAsignacion);
				central.add(historicoScroll);
				
		        // panel sur
				mensaje = new JLabel();
				
		        // panel principal
				setLayout(new BorderLayout());
				
				add(norte,BorderLayout.NORTH);
				add(central,BorderLayout.CENTER);
				add(mensaje,BorderLayout.SOUTH);
	}
	
	@Override
	public void controlador(ActionListener ctr) {
		// TODO Auto-generated method stub

		iniciarAsig.addActionListener(ctr);
		iniciarAsig.setActionCommand(INICIAR_ASIGNACION);
		iniciarAsigF.addActionListener(ctr);
		iniciarAsigF.setActionCommand(INICIAR_ASIGNACION_FAMILIAR);
		asignar.addActionListener(ctr);
		asignar.setActionCommand(ASIGNAR);
		finalizar.addActionListener(ctr);
		finalizar.setActionCommand(FINALIZAR);
	}

	@Override
	public String ficheroSolicitudes() {
		// TODO Auto-generated method stub
		return fichSolicitudes.getText();
	}

	@Override
	public String ficheroSalidaConPlaza() {
		// TODO Auto-generated method stub
		return fichSalidaConPlaza.getText();
	}

	@Override
	public String ficheroSalidaSinPlaza() {
		// TODO Auto-generated method stub
		return fichSalidaSinPlaza.getText();
	}

	@Override
	public int plazasI3() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(i3.getText());
	}

	@Override
	public int plazasI4() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(i4.getText());
	}

	@Override
	public int plazasI5() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(i5.getText());
	}

	@Override
	public int plazasP1() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(p1.getText());
	}

	@Override
	public int plazasP2() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(p2.getText());
	}

	@Override
	public int plazasP3() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(p3.getText());
	}

	@Override
	public int plazasP4() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(p4.getText());
	}

	@Override
	public int plazasP5() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(p5.getText());
	}

	@Override
	public int plazasP6() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(p6.getText());
	}

	
	@Override
	public void error(String mensaje) {
		// TODO Auto-generated method stub
		this.mensaje.setForeground(Color.RED);
		this.mensaje.setText(mensaje);
	}

	@Override
	public void ok(String mensaje) {
		// TODO Auto-generated method stub
		this.mensaje.setForeground(Color.BLUE);
		this.mensaje.setText(mensaje);
	}

	@Override
	public void habilitarInicio(boolean b) {
		// TODO Auto-generated method stub

		iniciarAsig.setEnabled(b);
		iniciarAsigF.setEnabled(b);
		fichSolicitudes.setEnabled(b);
		
			
		asignar.setEnabled(!b);
		i3.setEnabled(!b);
		i4.setEnabled(!b);
		i5.setEnabled(!b);
		p1.setEnabled(!b);
		p2.setEnabled(!b);
		p3.setEnabled(!b);
		p4.setEnabled(!b);
		p5.setEnabled(!b);
		p6.setEnabled(!b);
		fichSalidaConPlaza.setEnabled(!b);
		fichSalidaSinPlaza.setEnabled(!b);
		finalizar.setEnabled(!b);
	}

	@Override
	public void añadirAHistórico(String mensaje) {
		// TODO Auto-generated method stub
		historico.append(mensaje + "\n");
	}
	
	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		historico.setText("");
		fichSolicitudes.setText("");
		i3.setText("0");
		i4.setText("0");
		i5.setText("0");
		p1.setText("0");
		p2.setText("0");
		p3.setText("0");
		p4.setText("0");
		p5.setText("0");
		p6.setText("0");
		fichSalidaConPlaza.setText("");
		fichSalidaSinPlaza.setText("");
	}

}
