package presentacion;

import javax.swing.JInternalFrame;

import javax.swing.JComboBox;

import java.awt.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.toedter.calendar.JDateChooser;

import excepciones.NoExisteActividadDepEx;
import interfaces.IControladorActividadDeportiva;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RegistroDictadoDeClase extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorActividadDeportiva icon;
	private JLabel lblInstitucion;
	private JTextArea textArea;
	private JComboBox<String> comInst;
	private JComboBox<String> comActDep;
	private JComboBox<String> comClase;
	private JComboBox<String> comSocios;
	//private JScrollPane scrollPane;
	private JTextArea textArea2;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDictadoDeClase frame = new RegistroDictadoDeClase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public RegistroDictadoDeClase(IControladorActividadDeportiva ico) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				//list.clearSelection();
			}
		});
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Registro de Dictado de Clase");
		setBounds(100, 100, 440, 331);
		getContentPane().setLayout(null);
		
		//INSTITUCION
		
		lblInstitucion = new JLabel("Institución:");
		lblInstitucion.setBounds(30, 28, 86, 14);
		getContentPane().add(lblInstitucion);
		
		comInst = new JComboBox<String>();
		comInst.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiarComboBoxActividadesDep();
				if((String)comActDep.getSelectedItem() != null)
					try {
						textArea.setText(icon.RegistroDictadoDeClase((String)comActDep.getSelectedItem()).toString());
					} catch (NoExisteActividadDepEx e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		comInst.setBounds(223, 28, 140, 22);
		getContentPane().add(comInst);
		
		//ACTIVIDADES
		
		JLabel lblActDep = new JLabel("Actividad Deportiva:");
		lblActDep.setBounds(30, 61, 86, 14);
		getContentPane().add(lblActDep);
		
		comActDep = new JComboBox<String>();
		comActDep.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiarComboBoxClase();
				if((String)comActDep.getSelectedItem() != null) {
					try {
						textArea.setText(icon.RegistroDictadoDeClase((String)comActDep.getSelectedItem()).toString());
					} catch (NoExisteActividadDepEx e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			}
		});
		comActDep.setBounds(223, 61, 140, 22);
		getContentPane().add(comActDep);
		
		//CLASES
		
		JLabel lblClases = new JLabel("Clases:");
		lblClases.setBounds(30, 94, 86, 14);
		getContentPane().add(lblClases);
		
		comClase = new JComboBox<String>();
		comClase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if((String)comClase.getSelectedItem() != null)
					textArea2.setText(icon.getDtClase((String)comClase.getSelectedItem()).toString());
			
			}
		});
		comClase.setBounds(223, 94, 140, 22);
		getContentPane().add(comClase);
		
		//DATOS DE CLASE
		
		JLabel lblDatos = new JLabel("Datos");
		lblDatos.setBounds(30, 127, 46, 14);
		getContentPane().add(lblDatos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(223, 125, 140, 57);
		getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		//SOCIOS
		
		JLabel lblNewLabel_4 = new JLabel("Socios");
		lblNewLabel_4.setBounds(30, 188, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		comSocios = new JComboBox<String>();
		
		
		
		comSocios.setBounds(223, 188, 140, 22);
		getContentPane().add(comSocios);
		
		//FECHA
		
		JLabel lblNewLabel_5 = new JLabel("Fecha");
		lblNewLabel_5.setBounds(30, 217, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d MM y");
		dateChooser.setBounds(223, 221, 140, 20);
		getContentPane().add(dateChooser);
		
		//CANCELAR
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(30, 267, 107, 23);
		getContentPane().add(btnNewButton);
		
		//ACEPTAR
		
		JButton btnNewButton_1 = new JButton("Acceptar");
		btnNewButton_1.setBounds(295, 267, 107, 23);
		getContentPane().add(btnNewButton_1);
		
		
	}
	
	//COMBO BOX INSTITUCIONES
	
	public void inicializarComboBoxInstituciones() {
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		ArrayList<String> instituciones = icon.listarInstituciones();
		for (String s : instituciones) {
			modelo.addElement(s);
		}
		comInst.setModel(modelo);
	}
	
	//COMBO BOX ACTIVIDAD DEPORTIVA
	
	public void cambiarComboBoxActividadesDep() {
		DefaultComboBoxModel<String> modelo2 = new DefaultComboBoxModel<String>();
		ArrayList<String> actDeps = icon.listarActividadesDeportivas((String)comInst.getSelectedItem());
		for (String a : actDeps) {
			modelo2.addElement(a);
		}
		comActDep.setModel(modelo2);
		if((String)comActDep.getSelectedItem() != null)
			try {
				textArea.setText(icon.RegistroDictadoDeClase((String)comActDep.getSelectedItem()).toString());
			} catch (NoExisteActividadDepEx e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//COMBO BOX CLASE
	
	public void cambiarComboBoxClase() {
		DefaultComboBoxModel<String> modelo3 = new DefaultComboBoxModel<String>();
		ArrayList<String> clas = icon.listarClases((String)comActDep.getSelectedItem());
		for (String c : clas) {
			modelo3.addElement(c);
		}
		comClase.setModel(modelo3);
		if((String)comClase.getSelectedItem() != null)
		textArea2.setText(icon.getDtClase((String)comClase.getSelectedItem()).toString());
	}
}
