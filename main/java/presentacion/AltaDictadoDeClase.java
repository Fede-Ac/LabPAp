package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import excepciones.ClaseRepetidaEx;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import interfaces.IControladorClase;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;


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
		
		dateFecha = new JDateChooser();
		dateFecha.setDateFormatString("d MM y");
		dateFecha.setBounds(243, 51, 114, 20);
		getContentPane().add(dateFecha);
		
		//HORA
		
		JLabel lblHora = new JLabel("Hora de inicio");
		lblHora.setBounds(12, 84, 70, 15);
		getContentPane().add(lblHora);
		
		spinHora = new JSpinField();
		spinHora.setBounds(311, 82, 46, 20);
		getContentPane().add(spinHora);
		
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
		
		dateFechaAlta = new JDateChooser();
		dateFechaAlta.setDateFormatString("d MM y");
		dateFechaAlta.setBounds(243, 141, 114, 20);
		getContentPane().add(dateFechaAlta);
		
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
		Calendar fechaCal = this.dateFecha.getCalendar();
		Integer hora = (int)this.spinHora.getValue();
		String URL = this.textURL.getText();
		Calendar fechaAlta = this.dateFechaAlta.getCalendar();
		
		GregorianCalendar fecha = new GregorianCalendar(fechaCal.YEAR, fechaCal.MONTH, fechaCal.DAY_OF_MONTH);
		GregorianCalendar fechaAlt = new GregorianCalendar(fechaAlta.YEAR, fechaAlta.MONTH, fechaAlta.DAY_OF_MONTH);

		if (nombre.isEmpty()) {
			this.lblError.setText("Nombre no puede estar vacío");
		}else if (dateFecha.getCalendar() == null) {
			this.lblError.setText("La fecha no puede estar vacia");			
		}else if (hora < 0) {
			this.lblError.setText("Hora no puede estar vacío");
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
