package presentacion;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import interfaces.IControladorUsuario;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class ConsultaUsuario extends JInternalFrame {
	
	
	private static final long serialVersionUID = 1L;
	private IControladorUsuario icon;
	private JList<String> listaUsuarios = new JList<>();

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
	}*/

	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(IControladorUsuario icon) {
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setBounds(12, 12, 70, 15);
		getContentPane().add(lblUsuarios);
		
		//JList listaUsuarios = new JList();
		listaUsuarios.setBounds(12, 43, 116, 138);
		getContentPane().add(listaUsuarios);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(12, 193, 116, 25);
		getContentPane().add(btnSeleccionar);

	}
	
	public void inicializarLista() {
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		int i=0;
		String[] a = icon.mostrarUsuarios();
		for (String s : a) {
			s=a[i];
			modelo.addElement(s);
			i++;	
		}
		this.listaUsuarios.setModel(modelo);
	}
}
