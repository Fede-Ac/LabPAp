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

public class AltaDictadoDeClase extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorClase icon;//
	private JTextField textNombre;
	private JTextField textFecha;
	private JTextField textHoraIn;
	private JLabel lblError;
	private JTextField textURL;
	private JTextField textFechaAlt;
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la clase");
		lblNombreDeLa.setBounds(12, 24, 198, 15);
		getContentPane().add(lblNombreDeLa);
		
		textNombre = new JTextField();
		textNombre.setBounds(243, 21, 114, 19);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Fecha");
		lblDescripcin.setBounds(12, 54, 124, 15);
		getContentPane().add(lblDescripcin);
		
		textFecha = new JTextField();
		textFecha.setBounds(243, 51, 114, 19);
		getContentPane().add(textFecha);
		textFecha.setColumns(10);
		
		JLabel lblUrl = new JLabel("Hora de inicio");
		lblUrl.setBounds(12, 80, 70, 15);
		getContentPane().add(lblUrl);
		
		textHoraIn = new JTextField();
		textHoraIn.setBounds(243, 81, 114, 19);
		getContentPane().add(textHoraIn);
		textHoraIn.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//para facilitar
				addClasePerformed(e);
			}
		});
		btnIngresar.setBounds(311, 231, 117, 25);
		getContentPane().add(btnIngresar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(12, 231, 117, 25);
		getContentPane().add(btnCancelar);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(239, 41, 41));
		lblError.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblError.setBounds(99, 194, 254, 15);
		getContentPane().add(lblError);
		
		JLabel lblUrl_2 = new JLabel("URL");
		lblUrl_2.setBounds(12, 114, 70, 15);
		getContentPane().add(lblUrl_2);
		
		textURL = new JTextField();
		textURL.setColumns(10);
		textURL.setBounds(243, 111, 114, 19);
		getContentPane().add(textURL);
		
		JLabel lblUrl_2_1 = new JLabel("Fecha de alta");
		lblUrl_2_1.setBounds(12, 144, 70, 15);
		getContentPane().add(lblUrl_2_1);
		
		textFechaAlt = new JTextField();
		textFechaAlt.setColumns(10);
		textFechaAlt.setBounds(243, 141, 114, 19);
		getContentPane().add(textFechaAlt);
		

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
