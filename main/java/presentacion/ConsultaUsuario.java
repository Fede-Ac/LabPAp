package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import excepciones.NoExistenUsuariosEx;
import interfaces.iControladorUsuario;

public class ConsultaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private iControladorUsuario icon;
	private String selectedNickname;
	
	

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
	 */
	public ConsultaUsuario(iControladorUsuario icon) {
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
		
		JList<String> listaUsuarios = new JList<String>();
		listaUsuarios.setBounds(22, 49, 90, 188);
		getContentPane().add(listaUsuarios);
		llenarLista(listaUsuarios);
	}


	protected void llenarLista(JList<String> aLlenar){
		try {
			ArrayList<String> aux = icon.mostrarUsuarios();
			aux.forEach((n)-> aLlenar.add(n, aLlenar));
			
		} catch (NoExistenUsuariosEx e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),"ConsultaSocio",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}
