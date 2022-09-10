package presentacion;

import javax.swing.JInternalFrame;

import javax.swing.JComboBox;

import java.awt.List;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class RegistroDictadoDeClase extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 
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

	
	 * Create the frame.
	 */
	public RegistroDictadoDeClase() {
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Registro de Dictado de Clase");
		setBounds(100, 100, 440, 331);
		getContentPane().setLayout(null);
		
		//INSTITUCION
		
		JLabel lblNewLabel = new JLabel("Institución");
		lblNewLabel.setBounds(30, 28, 86, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comInst = new JComboBox();
		comInst.setBounds(223, 28, 140, 22);
		getContentPane().add(comInst);
		
		//ACTIVIDADES
		
		JLabel lblNewLabel_1 = new JLabel("Actividades");
		lblNewLabel_1.setBounds(30, 61, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comActDep = new JComboBox();
		comActDep.setBounds(223, 61, 140, 22);
		getContentPane().add(comActDep);
		
		//CLASES
		
		JLabel lblNewLabel_2 = new JLabel("Clases");
		lblNewLabel_2.setBounds(30, 94, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comClases = new JComboBox();
		comClases.setBounds(223, 94, 140, 22);
		getContentPane().add(comClases);
		
		//DATOS DE CLASE
		
		JLabel lblNewLabel_3 = new JLabel("Datos");
		lblNewLabel_3.setBounds(30, 119, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		List list = new List();
		list.setBounds(223, 122, 156, 49);
		getContentPane().add(list);
		
		//SOCIOS
		
		JLabel lblNewLabel_4 = new JLabel("Socios");
		lblNewLabel_4.setBounds(30, 188, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JComboBox comSocios = new JComboBox();
		comSocios.setBounds(223, 188, 140, 22);
		getContentPane().add(comSocios);
		
		//FECHA
		
		JLabel lblNewLabel_5 = new JLabel("Fecha");
		lblNewLabel_5.setBounds(30, 217, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d MM y");
		dateChooser.setBounds(223, 221, 140, 20);
		getContentPane().add(dateChooser);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(30, 267, 107, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Acceptar");
		btnNewButton_1.setBounds(295, 267, 107, 23);
		getContentPane().add(btnNewButton_1);
		
	}
}
