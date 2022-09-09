package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import interfaces.Fabrica;
import interfaces.IControladorActividadDeportiva;
import interfaces.IControladorInstitucionDep;
import interfaces.IControladorUsuario;
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

	// private RegistroDictadoDeClase regDictadoDeClase;

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
		// indicializo icon
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorClase iConClase = fabrica.getIControladorClase();
		IControladorInstitucionDep iConIntDep = fabrica.getIControladorInstitucionDep();
		IControladorActividadDeportiva iConActDep = fabrica.getIControladorActividadDeportiva();
		IControladorUsuario iConUser = fabrica.getIControladorUsuario();

		// crear una instancia de internal frame, ponerla en invisible y añadirla a
		// principal

		altaInstitucionDepInF = new AltaInstitucionDep(iConIntDep);
		altaInstitucionDepInF.setVisible(false);
		frame.getContentPane().add(altaInstitucionDepInF);

		altaUsuarioInF = new AltaUsuario(iConUser);
		altaUsuarioInF.setVisible(false);
		frame.getContentPane().add(altaUsuarioInF);

		consultaActividadDepInF = new ConsultaActividadDeportiva(iConActDep);
		consultaActividadDepInF.setVisible(false);
		frame.getContentPane().add(consultaActividadDepInF);

		consultaUsuarioInF = new ConsultaUsuario(iConUser);
		consultaUsuarioInF.setSize(450, 327);
		consultaUsuarioInF.setLocation(100, 100);
		consultaUsuarioInF.setVisible(false);
		frame.getContentPane().add(consultaUsuarioInF);

		altaActividadDeportivaInF = new AltaActividadDeportiva(iConActDep);
		altaActividadDeportivaInF.setVisible(false);
		frame.getContentPane().add(altaActividadDeportivaInF);

		altaDictadoDeClaseInF = new AltaDictadoDeClase(iConClase);
		altaDictadoDeClaseInF.setVisible(false);
		frame.getContentPane().add(altaDictadoDeClaseInF);

		// fin crear instancia
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
				altaUsuarioInF.inicializarComboBoxInstituciones();
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
			}
		});
		mnInstitucionesDeportivas.add(mntmAltaInstitucinDep);

		JMenu mnActividadesDeportivas = new JMenu("Actividades Deportivas");
		menuBar.add(mnActividadesDeportivas);

		JMenuItem mntmAltaDeActividad = new JMenuItem("Alta de Actividad Deportiva");
		mntmAltaDeActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					altaActividadDeportivaInF.inicializarComboBoxInstituciones();
					altaActividadDeportivaInF.setVisible(true);
				}
			}
		});
		mnActividadesDeportivas.add(mntmAltaDeActividad);
		JMenu mnDictadoDeClases = new JMenu("Dictado de clases");
		menuBar.add(mnDictadoDeClases);

		JMenuItem mntmDictadoDeClases = new JMenuItem("Alta dictado de clase");
		mntmDictadoDeClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					altaDictadoDeClaseInF.inicializarComboBoxInstituciones();
					altaDictadoDeClaseInF.cambiarComboBoxActividadesDep();
					altaDictadoDeClaseInF.cambiarComboBoxProfesores();
					altaDictadoDeClaseInF.setVisible(true);
				}else {
					//JOptionPane.showMessageDialog(this, "No puede haber campos no opcionales vacíos", "Agregar Usuario",
					//		JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		mnDictadoDeClases.add(mntmDictadoDeClases);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registro dictado de clase");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					
				}
			}
		});
		mnDictadoDeClases.add(mntmNewMenuItem);

		JMenuItem mntmConsultaActividadDep = new JMenuItem("Consulta Actividad Dep.");
		mntmConsultaActividadDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					consultaActividadDepInF.inicializarComboBoxInstituciones();
					consultaActividadDepInF.cambiarComboBoxActividadesDep();
					consultaActividadDepInF.setVisible(true);
				}
			}
		});
		mnActividadesDeportivas.add(mntmConsultaActividadDep);

	}
}
