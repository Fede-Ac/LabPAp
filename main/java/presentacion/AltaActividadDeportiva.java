package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;


public class AltaActividadDeportiva extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaActividadDeportiva frame = new AltaActividadDeportiva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaActividadDeportiva() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(299, 233, 79, 24);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(77, 233, 98, 24);
		getContentPane().add(btnCancelar);
		
		textField = new JTextField();
		textField.setBounds(97, 12, 114, 18);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 12, 55, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(12, 38, 79, 14);
		getContentPane().add(lblDescripcin);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(97, 100, 89, 18);
		getContentPane().add(formattedTextField);
		
		JLabel lblDuracin = new JLabel("Duración");
		lblDuracin.setBounds(12, 102, 55, 14);
		getContentPane().add(lblDuracin);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(97, 161, 89, 18);
		getContentPane().add(formattedTextField_1);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(12, 163, 55, 14);
		getContentPane().add(lblCosto);
		
		JLabel label = new JLabel("New label");
		label.setBounds(12, 196, 55, 14);
		getContentPane().add(label);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d MM y");
		dateChooser.setBounds(100, 191, 75, 19);
		getContentPane().add(dateChooser);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(97, 38, 193, 52);
		getContentPane().add(textArea);

	}
}
