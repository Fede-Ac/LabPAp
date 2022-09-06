package presentacion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

import excepciones.ActividadDepRepetidaEx;
import interfaces.IControladorActividadDeportiva;

import javax.swing.JTextArea;

import java.util.GregorianCalendar;
import java.util.Calendar;
import javax.swing.JSpinner;

public class AltaActividadDeportiva extends JInternalFrame {
	private IControladorActividadDeportiva icon;
	private JTextField nombre;
	private JTextArea descripcion;
	private JLabel lblError;
	private JDateChooser fechaCreacion;
	private JSpinner duracion;
	private JSpinner costo;
	private JTextField nombreInst;
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		this.icon = icon;
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 12, 55, 14);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(61, 10, 114, 18);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNombreInst = new JLabel("Nombre Inst.");
		lblNombreInst.setBounds(212, 12, 79, 14);
		getContentPane().add(lblNombreInst);
		
		nombreInst = new JTextField();
		nombreInst.setColumns(10);
		nombreInst.setBounds(299, 10, 114, 18);
		getContentPane().add(nombreInst);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(12, 38, 79, 14);
		getContentPane().add(lblDescripcion);
		
		descripcion = new JTextArea();
		descripcion.setBounds(97, 38, 193, 52);
		getContentPane().add(descripcion);
		
		JLabel lblDuracion = new JLabel("Duración");
		lblDuracion.setBounds(12, 102, 55, 14);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(12, 163, 55, 14);
		getContentPane().add(lblCosto);
		
		JLabel lblAltaActividad = new JLabel("Fecha de alta");
		lblAltaActividad.setBounds(212, 163, 78, 14);
		getContentPane().add(lblAltaActividad);
		
		fechaCreacion = new JDateChooser();
		fechaCreacion.setDateFormatString("d MM y");
		fechaCreacion.setBounds(299, 163, 98, 19);
		getContentPane().add(fechaCreacion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddActividadActionPerformed(e);
			}
		});
		btnAceptar.setBounds(299, 233, 79, 24);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(77, 233, 98, 24);
		getContentPane().add(btnCancelar);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(239, 41, 41));
		lblError.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblError.setBounds(115, 186, 227, 33);
		getContentPane().add(lblError);
		
		duracion = new JSpinner();
		duracion.setBounds(97, 102, 78, 18);
		getContentPane().add(duracion);
		
		costo = new JSpinner();
		costo.setBounds(97, 161, 78, 18);
		getContentPane().add(costo);

	}
	
	protected void AddActividadActionPerformed(ActionEvent arg0) {
		String nombre = this.nombre.getText();
		String nombreInst = this.nombreInst.getText();
		String descripcion = this.descripcion.getText();
		Integer duracion = (int)this.duracion.getValue();
		Integer costo = (int)this.costo.getValue();
		Calendar fechaCal = this.fechaCreacion.getCalendar();
		
		GregorianCalendar fecha = new GregorianCalendar(fechaCal.YEAR, fechaCal.MONTH, fechaCal.DAY_OF_MONTH);
		
		if (nombre.isEmpty()) {
			this.lblError.setText("El nombre no puede estar vacío");
		}else if (descripcion.isEmpty()) {
			this.lblError.setText("La descripción no puede estar vacía");			
		}else if (duracion < 0) {
			this.lblError.setText("La duración no puede ser menor o igual a cero");
		}else if (costo < 0) {
			this.lblError.setText("El costo no puede ser menor o igual a cero");
		}else if (fechaCreacion.getCalendar() == null) {
			this.lblError.setText("La fecha no puede estar vacía");
		}else if (nombreInst.isEmpty()) {
			this.lblError.setText("La institución deportiva no puede estar vacía");
		}else{
			try {
				this.icon.AltaActividadDeportiva(nombre,nombreInst,descripcion,duracion,costo,fecha);
			}catch(ActividadDepRepetidaEx ex){
				this.lblError.setText(ex.getMessage());
			}
		}
	}
}
