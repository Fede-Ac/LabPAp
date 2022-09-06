package presentacion;

import java.awt.EventQueue;

import java.util.GregorianCalendar;
import javax.swing.JInternalFrame;
import com.toedter.components.JLocaleChooser;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class RegistroDictadoDeClase extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDictadoDeClase frame = new RegistroDictadoDeClase();
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
	public RegistroDictadoDeClase() {
		setTitle("Registro de Dictado de Clase");
		setBounds(100, 100, 440, 331);
		getContentPane().setLayout(null);
		
		//INSTITUCION
		
		JLabel lblNewLabel = new JLabel("Institución");
		lblNewLabel.setBounds(30, 28, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(244, 24, 140, 22);
		getContentPane().add(comboBox);
		
		//ACTIVIDADES
		
		JLabel lblNewLabel_1 = new JLabel("Actividades");
		lblNewLabel_1.setBounds(30, 61, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(244, 57, 140, 22);
		getContentPane().add(comboBox_1);
		
		//CLASES
		
		JLabel lblNewLabel_2 = new JLabel("Clases");
		lblNewLabel_2.setBounds(30, 94, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(244, 90, 140, 22);
		getContentPane().add(comboBox_2);
		
		//DATOS DE CLASE
		
		JLabel lblNewLabel_3 = new JLabel("Datos");
		lblNewLabel_3.setBounds(30, 119, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		List list = new List();
		list.setBounds(244, 118, 140, 60);
		getContentPane().add(list);
		
		//SOCIOS
		
		JLabel lblNewLabel_4 = new JLabel("Socios");
		lblNewLabel_4.setBounds(30, 188, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(244, 184, 140, 22);
		getContentPane().add(comboBox_3);
		
		//FECHA
		
		JLabel lblNewLabel_5 = new JLabel("Fecha");
		lblNewLabel_5.setBounds(30, 217, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d MM y");
		dateChooser.setBounds(244, 217, 140, 20);
		getContentPane().add(dateChooser);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(30, 267, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Acceptar");
		btnNewButton_1.setBounds(295, 267, 89, 23);
		getContentPane().add(btnNewButton_1);
		


	}
}
