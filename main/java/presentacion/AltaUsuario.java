package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import excepciones.UsuarioRepetidoEx;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import interfaces.iControladorUsuario;

public class AltaUsuario extends JInternalFrame {
	public AltaUsuario() {
	}
	private static final long serialVersionUID = 1L;
	private iControladorUsuario icon;//
	
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textURL;
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
	
	
	/*public AltaInstitucionDep(IControladorInstitucionDep icon) {
		//
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Agregar una Institución deportiva");
		//
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la institución");
		lblNombreDeLa.setBounds(12, 44, 198, 15);
		getContentPane().add(lblNombreDeLa);
		
		textNombre = new JTextField();
		textNombre.setBounds(243, 42, 114, 19);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(12, 94, 124, 15);
		getContentPane().add(lblDescripcin);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(243, 92, 114, 19);
		getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(12, 138, 70, 15);
		getContentPane().add(lblUrl);
		
		textURL = new JTextField();
		textURL.setBounds(243, 145, 114, 19);
		getContentPane().add(textURL);
		textURL.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//para facilitar
				addInstitucionDepActionPerformed(e);
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
		

	}
	
	protected void addInstitucionDepActionPerformed(ActionEvent arg0) {
		String nombre = this.textNombre.getText();
		String descripcion = this.textDescripcion.getText();
		String URL = this.textURL.getText();
		if (nombre.isEmpty()) {
			this.lblError.setText("Nombre no puede estar vacio");
		}else if (descripcion.isEmpty()) {
			this.lblError.setText("Descripción no puede estar vacio");			
		}else if (URL.isEmpty()) {
			this.lblError.setText("URL no puede estar vacio");
		}else{
			try {
				this.icon.addInstitucionDep(this.textNombre.getText(),this.textDescripcion.getText(),this.textURL.getText());
			}catch(InstitucionDepRepetidaEx ex){
				
			}
		}
		
	}
	*/
}
