package presentacion;

import java.awt.Color;


import javax.swing.JInternalFrame;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

import datatypes.DtFecha;
import excepciones.ActividadDepRepetidaEx;
import interfaces.IControladorActividadDeportiva;

import javax.swing.JTextArea;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class AltaActividadDeportiva extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorActividadDeportiva icon;
	private JTextField nombre;
	private JTextArea descripcion;
	private JLabel lblError;
	private JDateChooser fechaCreacion;
	private JSpinner duracion;
	private JSpinner costo;
	private JComboBox<String> comInst;
	/**
	 * Launch the application.
	/* 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaActividadDeportiva frame = new AltaActividadDeportiva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public AltaActividadDeportiva(IControladorActividadDeportiva icon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				internalFrameClosedEvent(e);
			}
		});
		//
		setBounds(100, 100, 490, 327);
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Agregar una Actividad deportiva");
		getContentPane().setLayout(null);
		//
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 12, 67, 14);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(170, 10, 114, 18);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNombreInst = new JLabel("Institución");
		lblNombreInst.setBounds(12, 42, 140, 14);
		getContentPane().add(lblNombreInst);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(12, 80, 100, 14);
		getContentPane().add(lblDescripcion);
		
		descripcion = new JTextArea();
		descripcion.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		descripcion.setBounds(141, 80, 193, 52);
		getContentPane().add(descripcion);
		
		JLabel lblDuracion = new JLabel("Duración (minutos)");
		lblDuracion.setBounds(12, 144, 152, 14);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo ($ UYU)");
		lblCosto.setBounds(12, 176, 114, 14);
		getContentPane().add(lblCosto);
		
		JLabel lblAltaActividad = new JLabel("Fecha de alta");
		lblAltaActividad.setBounds(12, 209, 100, 14);
		getContentPane().add(lblAltaActividad);
		
		fechaCreacion = new JDateChooser();
		fechaCreacion.setBounds(185, 204, 120, 19);
		fechaCreacion.setDateFormatString("d/MM/y");
		getContentPane().add(fechaCreacion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(299, 259, 114, 24);
		btnAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddActividadActionPerformed(e);
			}
		});
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(99, 259, 98, 24);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnCancelar);
		
		lblError = new JLabel("");
		lblError.setBounds(135, 223, 227, 24);
		lblError.setForeground(new Color(239, 41, 41));
		lblError.setFont(new Font("Dialog", Font.PLAIN, 10));
		getContentPane().add(lblError);
		
		duracion = new JSpinner();
		duracion.setBounds(187, 142, 78, 18);
		getContentPane().add(duracion);
		
		costo = new JSpinner();
		costo.setBounds(187, 174, 78, 18);
		getContentPane().add(costo);
		
		comInst = new JComboBox<String>();
		comInst.setBounds(170, 39, 114, 22);
		getContentPane().add(comInst);

	}
	
	protected void AddActividadActionPerformed(ActionEvent arg0) {
		String nombre = this.nombre.getText();
		String nombreInst = (String)this.comInst.getSelectedItem();
		String descripcion = this.descripcion.getText();
		Integer duracion = (int)this.duracion.getValue();
		Integer costo = (int)this.costo.getValue();
		Calendar fechaCal = this.fechaCreacion.getCalendar();
		
		DtFecha fecha = new DtFecha(fechaCal);
		
		if (nombre.isEmpty()) {
			this.lblError.setText("El nombre no puede estar vacío");
		}else if (comInst.getSelectedItem() == null) {
			this.lblError.setText("La institución deportiva no puede estar vacía");
		}else if (descripcion.isEmpty()) {
			this.lblError.setText("La descripción no puede estar vacía");			
		}else if (duracion <= 0) {
			this.lblError.setText("La duración no puede ser menor o igual a cero");
		}else if (costo < 0) {
			this.lblError.setText("El costo no puede ser menor a cero");
		}else if (fechaCreacion.getCalendar() == null) {
			this.lblError.setText("La fecha no puede estar vacía");
		}else{
			try {
				this.icon.AltaActividadDeportiva(nombre,nombreInst,descripcion,duracion,costo,fecha);
				JOptionPane.showMessageDialog(this, "La actividad deportiva se ha registrado con éxito", "Actividad deportiva",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}catch(ActividadDepRepetidaEx ex){
				this.lblError.setText(ex.getMessage());
			}
		}
	}
	
	protected void internalFrameClosedEvent(InternalFrameEvent e) {
		this.nombre.setText(null);
		this.descripcion.setText(null);
		this.duracion.setValue(0);
		this.costo.setValue(0);
		this.lblError.setText(null);
		
	}
	
	public void inicializarComboBoxInstituciones() {
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		ArrayList<String> instituciones = icon.listarInstituciones();
		for (String s : instituciones) {
			modelo.addElement(s);
		}
		comInst.setModel(modelo);
	}
}
