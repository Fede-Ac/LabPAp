package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/////import interfaces.Fabrica;
/////import interfaces.IControladorInstitucionDep;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	
	//private AltaInstitucionDep altaInstitucionDepInF; 

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
		//////Fabrica fabrica = Fabrica.getInstancia();
		//////IControladorInstitucionDep icon = fabrica.getIControladorInstitucionDep();
		
		//crear una instancia de internal frame, ponerla en invisible y añadirla a principal
		///////altaInstitucionDepInF = new AltaInstitucionDep(icon);
		//////altaInstitucionDepInF.setVisible(false);
		/////frame.getContentPane().add(altaInstitucionDepInF);
		
		
		
	
	
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
		
		JMenu mnInstitucionesDeportivas = new JMenu("Instituciones Deportivas");
		menuBar.add(mnInstitucionesDeportivas);
		
		JMenuItem mntmAltaInstitucinDep = new JMenuItem("Alta institución dep.");
		mntmAltaInstitucinDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////altaInstitucionDepInF.setVisible(true);
			}
		});
		mnInstitucionesDeportivas.add(mntmAltaInstitucinDep);
	}
}
