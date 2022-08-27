package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import excepciones.NoExistenUsuariosEx;
import interfaces.iControladorUsuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private iControladorUsuario icon;
	private String selectedNickname;
	private JList<String> listaUsuarios;
	
	

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario frame = new ConsultaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws NoExistenUsuariosEx 
	 */
	public ConsultaUsuario(iControladorUsuario icon) throws NoExistenUsuariosEx {
		setTitle("Consulta Usuarios");
		setBounds(100, 100, 450, 300);
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		getContentPane().setLayout(null);
		selectedNickname = null;
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setBounds(12, 12, 70, 15);
		getContentPane().add(lblUsuarios);
		
		DefaultListModel<String>  model = new DefaultListModel<>();
		ArrayList<String> aux = icon.mostrarUsuarios();
		
		for(String agrego : aux) {
			model.addElement(agrego);
		}
		model.addElement("Hola");
		model.addElement("Hola1");
		model.addElement("Hola2");
		this.listaUsuarios = new JList<String>();
		
		listaUsuarios.setBounds(12, 39, 117, 188);
		getContentPane().add(listaUsuarios);

		listaUsuarios.setModel(model);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(12, 231, 117, 25);
		getContentPane().add(btnSeleccionar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioCancelarActionPerformed(e);
			}
		});
		btnVolver.setBounds(311, 231, 117, 25);
		getContentPane().add(btnVolver);
	}
	
	protected void consultaUsuarioCancelarActionPerformed(ActionEvent arg0){
		setVisible(false);
		
	}
	DefaultListModel<Object> listModel = new DefaultListModel<>();
}

