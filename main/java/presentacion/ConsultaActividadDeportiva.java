package presentacion;

import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;

import interfaces.IControladorActividadDeportiva;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class ConsultaActividadDeportiva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorActividadDeportiva icon;
	private JList<String> list = new JList<String>();
	private JLabel lblLista;
	private JTextArea textArea;
	private boolean a;
	private Component textAreaInformacion;
	
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaActividadDeportiva frame = new ConsultaActividadDeportiva();
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
	public ConsultaActividadDeportiva(IControladorActividadDeportiva icon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				a = true;
				list.clearSelection();
			}
		});
		//
		this.icon = icon;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consultar una actividad deportiva");
		//
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 52, 121, 151);
		getContentPane().add(scrollPane);
		list.addListSelectionListener(new ListSelectionListener() {


			public void valueChanged(ListSelectionEvent arg0) {
				if(!a) {
					lblLista.setText("Actividad Deportiva:");
					
				}
				
			}
		});
		
		scrollPane.setViewportView(list);
		
		lblLista = new JLabel("Institucion:");
		lblLista.setBounds(28, 25, 154, 15);
		getContentPane().add(lblLista);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(194, 52, 202, 151);
		getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblInstitucion_1 = new JLabel("Informacion:");
		lblInstitucion_1.setBounds(194, 25, 104, 15);
		getContentPane().add(lblInstitucion_1);

	}
	
	public void inicializarLista() {
		/*a=false;
		lblLista.setText("Institucion:");
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		ArrayList<String> instituciones = icon.listarInstituciones();
		for (String s : instituciones) {
			modelo.addElement(s);
		}
		list.setModel(modelo);*/
	}	
	
	public void cambiarListaActividadDeportiva() {
		/*lblLista.setText("Actividad Deportiva:");
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		//ArrayList<String> actividadesDeportivas = icon.listarActividadesDeportivas(list.getSelectedValue());
		ArrayList<String> aa = new ArrayList<String>();
		for (String a : aa) {
			modelo.addElement(a);
		}
		list.setModel(modelo);*/
	}
}
