package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import excepciones.ClaseRepetidaEx;
import excepciones.InstitucionDepRepetidaEx;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import interfaces.IControladorClase;
import javax.swing.JSpinner;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JSlider;
import com.toedter.components.JSpinField;


public class AltaDictadoDeClase extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorClase icon;//
	private JTextField textNombre;
	private JTextField textURL;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaInstitucionDep frame = new AltaInstitucionDep(icon);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public AltaDictadoDeClase(IControladorClase icon) {
		//
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Agregar una Institución deportiva");
		//
		setBounds(100, 100, 391, 313);
		getContentPane().setLayout(null);
		
		//NOMBRRE
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la clase");
		lblNombreDeLa.setBounds(12, 24, 198, 15);
		getContentPane().add(lblNombreDeLa);
		
		textNombre = new JTextField();
		textNombre.setBounds(243, 21, 114, 19);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		//FECHA
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 54, 124, 15);
		getContentPane().add(lblFecha);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d MM y");
		dateChooser.setBounds(243, 51, 114, 20);
		getContentPane().add(dateChooser);
		
		//HORA
		
		JLabel lblHora = new JLabel("Hora de inicio");
		lblHora.setBounds(12, 84, 70, 15);
		getContentPane().add(lblHora);
		
		JSpinField spinField = new JSpinField();
		spinField.setBounds(311, 82, 46, 20);
		getContentPane().add(spinField);
		
		//URL
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(12, 114, 70, 15);
		getContentPane().add(lblUrl);
		
		textURL = new JTextField();
		textURL.setColumns(10);
		textURL.setBounds(243, 111, 114, 19);
		getContentPane().add(textURL);
		
		//FECHA ALTA
		
		JLabel lblFechaAlt = new JLabel("Fecha de alta");
		lblFechaAlt.setBounds(12, 144, 70, 15);
		getContentPane().add(lblFechaAlt);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("d MM y");
		dateChooser_1.setBounds(243, 141, 114, 20);
		getContentPane().add(dateChooser_1);
		
		//INGRESAR
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//para facilitar
				addClasePerformed(e);
			}
		});
		btnIngresar.setBounds(243, 231, 117, 25);
		getContentPane().add(btnIngresar);
		
		//CANCELAR
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(12, 231, 117, 25);
		getContentPane().add(btnCancelar);
		

		

	}
	
	protected void addClasePerformed(ActionEvent arg0) {
		String nombre = this.textNombre.getText();
		String fecha = this.textFecha.getText();
		String horaIn = this.textHoraIn.getText();
		String URL = this.textURL.getText();
		String fechaAlt = this.textFechaAlt.getText();
		if (nombre.isEmpty()) {
			this.lblError.setText("Nombre no puede estar vacio");
		}else if (fecha.isEmpty()) {
			this.lblError.setText("La fecha no puede estar vacia");			
		}else if (horaIn.isEmpty()) {
			this.lblError.setText("La hora de inicio no puede estar vacia");
		}else if (URL.isEmpty()) {
			this.lblError.setText("URL no puede estar vaci0");
		}else if (fechaAlt.isEmpty()) {
			this.lblError.setText("La fecha de alta no puede estar vacia");
		}else{
			try {
				this.icon.addClase(this.textNombre.getText(),this.textFecha.getText(),this.textHoraIn.getText(),this.textURL.getText(),this.textFechaAlt.getText());
			}catch(ClaseRepetidaEx ex){
				
			}
		}
		
	}
}
