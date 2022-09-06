package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import excepciones.NoExistenUsuariosEx;
import interfaces.Fabrica;
import interfaces.IControladorActividadDeportiva;
import interfaces.IControladorInstitucionDep;
import interfaces.IControladorUsuario;
import interfaces.IControladorActividadDeportiva;
import interfaces.IControladorClase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	
	private AltaDictadoDeClase altaDictadoDeClaseInF;

	private AltaInstitucionDep altaInstitucionDepInF; 
	
	private AltaActividadDeportiva altaActividadDeportivaInF;

	private AltaUsuario altaUsuarioInF;
	
	private ConsultaUsuario consultaUsuarioInF;
	
	private ConsultaActividadDeportiva consultaActividadDepInF;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		//indicializo para usar operaciones
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorClase iconClase = fabrica.getIControladorClase();
		IControladorInstitucionDep icon = fabrica.getIControladorInstitucionDep();
		IControladorActividadDeportiva iconAct = fabrica.getIControladorActividadDeportiva();
		IControladorUsuario iCU = fabrica.getIControladorUsuario();
				
		//crear una instancia de internal frame, ponerla en invisible y añadirla a principal
		altaInstitucionDepInF = new AltaInstitucionDep(icon);
		altaInstitucionDepInF.setVisible(false);
		frame.getContentPane().add(altaInstitucionDepInF);

		//crear una instancia de internal frame, ponerla en invisible y añadirla a principal
		altaUsuarioInF = new AltaUsuario(iCU);
		altaUsuarioInF.setVisible(false);
		frame.getContentPane().add(altaUsuarioInF);
		
		IControladorActividadDeportiva iCAB = fabrica.getIControladorActividadDeportiva();
		consultaActividadDepInF = new ConsultaActividadDeportiva(iCAB);
		consultaActividadDepInF.setVisible(false);
		frame.getContentPane().add(consultaActividadDepInF);
		
		IControladorUsuario icoN = fabrica.getIControladorUsuario();
		//try {
			consultaUsuarioInF = new ConsultaUsuario(icoN);
		/*} catch (NoExistenUsuariosEx e) {
			JOptionPane.showMessageDialog(consultaUsuarioInF, e.getMessage(), "Consulta Usuario", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}*/
		consultaUsuarioInF.setSize(450, 327);
		consultaUsuarioInF.setLocation(100, 100);
		consultaUsuarioInF.setVisible(false);
		frame.getContentPane().add(consultaUsuarioInF);
		//consultaUsuariosInF.getContentPane().setLayout(null);
		
		///////altaInstitucionDepInF = new AltaInstitucionDep(icon);
		//////altaInstitucionDepInF.setVisible(false);
		/////frame.getContentPane().add(altaInstitucionDepInF);
		

		altaActividadDeportivaInF = new AltaActividadDeportiva(iconAct);
		altaActividadDeportivaInF.setVisible(false);
		frame.getContentPane().add(altaActividadDeportivaInF);

		altaDictadoDeClaseInF = new AltaDictadoDeClase(iconClase);
		altaDictadoDeClaseInF.setVisible(false);
		frame.getContentPane().add(altaDictadoDeClaseInF);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Entrenamos UY - principal");
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		

		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioInF.setVisible(true);
			}
		});
		mnUsuarios.add(mntmAltaUsuario);
		
		JMenuItem mntmConsultaUsuaro = new JMenuItem("Consulta Usuario");
		mntmConsultaUsuaro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioInF.inicializarLista();
				consultaUsuarioInF.setVisible(true);
					
			}
		});
		mnUsuarios.add(mntmConsultaUsuaro);
		

		JMenu mnInstitucionesDeportivas = new JMenu("Instituciones Deportivas");
		menuBar.add(mnInstitucionesDeportivas);
		
		JMenuItem mntmAltaInstitucinDep = new JMenuItem("Alta institución dep.");
		mntmAltaInstitucinDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				altaInstitucionDepInF.setVisible(true);

				////altaInstitucionDepInF.setVisible(true);

			}
		});
		mnInstitucionesDeportivas.add(mntmAltaInstitucinDep);
		
		JMenu mnActividadesDeportivas = new JMenu("Actividades Deportivas");
		menuBar.add(mnActividadesDeportivas);
		
		JMenuItem mntmAltaDeActividad = new JMenuItem("Alta de Actividad Deportiva");
		mntmAltaDeActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaActividadDeportivaInF.setVisible(true);
			}
		});
		mnActividadesDeportivas.add(mntmAltaDeActividad);
		JMenu mnDictadoDeClases = new JMenu("Dictado de clases");
		menuBar.add(mnDictadoDeClases);
		
		JMenuItem mntmDictadoDeClases = new JMenuItem("Alta dictado de clase");
		mntmDictadoDeClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaDictadoDeClaseInF.setVisible(true);
			}
		});
		mnDictadoDeClases.add(mntmDictadoDeClases);

		JMenuItem mntmConsultaActividadDep = new JMenuItem("Consulta Actividad Dep.");
		mntmConsultaActividadDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaActividadDepInF.inicializarLista();
				consultaActividadDepInF.setVisible(true);
			}
		});
		mnActividadesDeportivas.add(mntmConsultaActividadDep);

	}
}
