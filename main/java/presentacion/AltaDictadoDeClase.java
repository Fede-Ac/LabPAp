package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import excepciones.ClaseRepetidaEx;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import interfaces.IControladorClase;
import logica.Fecha;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class AltaDictadoDeClase extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorClase icon;//
	private JTextField textNombre;
	private JTextField textURL;
	private JDateChooser dateFecha;
	private JSpinField spinHora;
	private JDateChooser dateFechaAlta;
	private JLabel lblError;
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
		setBounds(100, 100, 391, 313);
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
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 76, 124, 15);
		getContentPane().add(lblFecha);
		
		dateFecha = new JDateChooser();
		dateFecha.setDateFormatString("d MM y");
		dateFecha.setBounds(243, 76, 114, 20);
		getContentPane().add(dateFecha);
		
		//HORA
		
		JLabel lblHora = new JLabel("Hora de inicio");
		lblHora.setBounds(12, 112, 117, 15);
		getContentPane().add(lblHora);
		
		spinHora = new JSpinField();
		spinHora.setMinimum(1);
		spinHora.setMaximum(24);
		spinHora.setBounds(311, 107, 46, 20);
		getContentPane().add(spinHora);
		
		//URL
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(12, 141, 70, 15);
		getContentPane().add(lblUrl);
		
		textURL = new JTextField();
		textURL.setColumns(10);
		textURL.setBounds(243, 138, 114, 19);
		getContentPane().add(textURL);
		
		//FECHA ALTA
		
		JLabel lblFechaAlt = new JLabel("Fecha de alta");
		lblFechaAlt.setBounds(12, 173, 137, 15);
		getContentPane().add(lblFechaAlt);
		
		dateFechaAlta = new JDateChooser();
		dateFechaAlta.setDateFormatString("d MM y");
		dateFechaAlta.setBounds(243, 168, 114, 20);
		getContentPane().add(dateFechaAlta);
		
		//INGRESAR
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClasePerformed(e);//para facilitar
			}
		});
		btnIngresar.setBounds(243, 231, 117, 25);
		getContentPane().add(btnIngresar);
		
		//CANCELAR
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(12, 231, 117, 25);
		getContentPane().add(btnCancelar);
		
		//ERROR
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(239, 41, 41));
		lblError.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblError.setBounds(115, 186, 227, 33);
		getContentPane().add(lblError);
		
		//INSTITUCION
		
		JLabel lblNewLabel = new JLabel("Institucion");
		lblNewLabel.setBounds(12, 15, 87, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(243, 11, 114, 22);
		getContentPane().add(comboBox);

	}
	
	protected void addClasePerformed(ActionEvent arg0) {
		String nombre = this.textNombre.getText();
		Calendar fechaCal = this.dateFecha.getCalendar();
		Integer hora = (int)this.spinHora.getValue();
		String URL = this.textURL.getText();
		Calendar fechaAlta = this.dateFechaAlta.getCalendar();
		
		Fecha fecha = new Fecha(fechaCal);
		Fecha fechaAlt = new Fecha(fechaAlta);

		if (nombre.isEmpty()) {
			this.lblError.setText("Nombre no puede estar vacío");
		}else if (dateFecha.getCalendar() == null) {
			this.lblError.setText("La fecha no puede estar vacia");			
		}else if (URL.isEmpty()) {
			this.lblError.setText("URL no puede estar vaci0");
		}else if (dateFechaAlta.getCalendar() == null) {
			this.lblError.setText("La fecha de alta no puede estar vacia");
		}else{
			try {
				this.icon.addClase(nombre,fecha,hora,URL,fechaAlt);
			}catch(ClaseRepetidaEx ex){
				this.lblError.setText(ex.getMessage());
			}
		}
		
	}
}
