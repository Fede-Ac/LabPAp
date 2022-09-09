package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.ClaseRepetidaEx;
import excepciones.NoExistenUsuariosEx;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import interfaces.IControladorClase;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import datatypes.DtFecha;
import datatypes.DtFechaHora;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;



public class AltaDictadoDeClase extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorClase icon;//
	private JTextField textNombre;
	private JTextField textURL;
	private JDateChooser dateFecha;
	private JDateChooser dateFechaAlta;
	private JLabel lblError;
	private JTextField txtProfesor;
	private JTextField txtInstitucion;
	private JSpinner spinHora ;
	private JSpinner spinMin;
	private JLabel lblActividadDeportiva;
	private JComboBox comActDep;
	
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
		setTitle("Agregar una clase");
		setBounds(100, 100, 391, 365);
		getContentPane().setLayout(null);
		//

				
		JLabel lblNombreDeLa = new JLabel("Nombre de la clase");
		lblNombreDeLa.setBounds(12, 49, 198, 15);
		getContentPane().add(lblNombreDeLa);
		
		textNombre = new JTextField();
		textNombre.setBounds(243, 46, 114, 19);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		//FECHA
		
		JLabel lblFecha = new JLabel("Fecha y hora de inicio");
		lblFecha.setBounds(12, 76, 165, 15);
		getContentPane().add(lblFecha);
		
		dateFecha = new JDateChooser();
		dateFecha.setDateFormatString("d MM y");
		dateFecha.setBounds(61, 107, 114, 20);
		getContentPane().add(dateFecha);
		
		//URL
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(12, 188, 70, 15);
		getContentPane().add(lblUrl);
		
		textURL = new JTextField();
		textURL.setColumns(10);
		textURL.setBounds(243, 186, 114, 19);
		getContentPane().add(textURL);
		
		//FECHA ALTA
		
		JLabel lblFechaAlt = new JLabel("Fecha de alta");
		lblFechaAlt.setBounds(12, 222, 137, 15);
		getContentPane().add(lblFechaAlt);
		
		dateFechaAlta = new JDateChooser();
		dateFechaAlta.setDateFormatString("d MM y");
		dateFechaAlta.setBounds(243, 217, 114, 20);
		getContentPane().add(dateFechaAlta);
		
		//INGRESAR
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClasePerformed(e);//para facilitar
			}
		});
		btnIngresar.setBounds(240, 299, 117, 25);
		getContentPane().add(btnIngresar);
		
		//CANCELAR
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(12, 299, 117, 25);
		getContentPane().add(btnCancelar);
		
		//ERROR
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(239, 41, 41));
		lblError.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblError.setBounds(115, 186, 227, 33);
		getContentPane().add(lblError);
		
		//INSTITUCION
		
		JLabel lblNewLabel = new JLabel("Institución deportiva");
		lblNewLabel.setBounds(12, 15, 165, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setBounds(12, 159, 70, 15);
		getContentPane().add(lblProfesor);
		
		txtProfesor = new JTextField();
		txtProfesor.setBounds(243, 157, 114, 19);
		getContentPane().add(txtProfesor);
		txtProfesor.setColumns(10);
		
		txtInstitucion = new JTextField();
		txtInstitucion.setBounds(243, 13, 114, 19);
		getContentPane().add(txtInstitucion);
		txtInstitucion.setColumns(10);
		
		spinHora = new JSpinner();
		spinHora.setBounds(189, 107, 49, 20);
		getContentPane().add(spinHora);
		
		spinMin = new JSpinner();
		spinMin.setBounds(250, 107, 43, 20);
		getContentPane().add(spinMin);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(243, 112, 12, 15);
		getContentPane().add(label);
		
		lblActividadDeportiva = new JLabel("Actividad deportiva");
		lblActividadDeportiva.setBounds(12, 259, 165, 15);
		getContentPane().add(lblActividadDeportiva);
		
		comActDep = new JComboBox();
		comActDep.setBounds(243, 259, 114, 24);
		getContentPane().add(comActDep);

	}
	
	
	
	protected void addClasePerformed(ActionEvent arg0) {
		String nomInstDep = this.txtInstitucion.getText();
		String actDep = (String) this.comActDep.getSelectedItem();
		String nombreclase = this.textNombre.getText();
		Calendar fechaCal = this.dateFecha.getCalendar();
		int hora = (int)this.spinHora.getValue();
		int min = (int)this.spinMin.getValue();
		String URL = this.textURL.getText();
		Calendar fechaAlta = this.dateFechaAlta.getCalendar();
		String profesor = this.txtProfesor.getText();
		
		DtFechaHora fechaHoraInicio = new DtFechaHora(fechaCal, hora, min);
		DtFecha fechaAlt = new DtFecha(fechaAlta);

		if (nombreclase.isEmpty()) {
			this.lblError.setText("Nombre no puede estar vacío");
		}else if (dateFecha.getCalendar() == null) {
			this.lblError.setText("La fecha no puede estar vacia");			
		}else if (URL.isEmpty()) {
			this.lblError.setText("URL no puede estar vaci0");
		}else if (dateFechaAlta.getCalendar() == null) {
			this.lblError.setText("La fecha de alta no puede estar vacia");
		}else{
			try {
				try {
					this.icon.addClase(actDep, nombreclase,fechaHoraInicio,profesor,URL,fechaAlt);
				} catch (NoExistenUsuariosEx ex) {
					JOptionPane.showMessageDialog(this, ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
				}
			}catch(ClaseRepetidaEx ex){
				this.lblError.setText(ex.getMessage());
			}
		}
		
	}
}
