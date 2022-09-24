package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import datatypes.DtActividadDeportiva;
import interfaces.IControladorActividadDeportiva;
import excepciones.NoExisteActividadDepEx;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.Collections;
import java.awt.List;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class RankingActividadDeportiva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorActividadDeportiva icon;
	private JScrollPane actividadesDeportivas;
	private JButton btnOk;
	private String[] columnNames = { "Actividad Deportiva", "N° de clases", "Costo", "Descripción"};
	private String[][] datosTabla;
	private JTable table;
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingActividadDeportiva frame = new RankingActividadDeportiva();
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
	public RankingActividadDeportiva(IControladorActividadDeportiva icad) {
		
		
		setBounds(100, 100, 601, 416);
		getContentPane().setLayout(null);
		
		icon = icad;
		
		actividadesDeportivas = new JScrollPane();
		actividadesDeportivas.setBounds(35, 38, 521, 295);
		getContentPane().add(actividadesDeportivas);
		
		datosTabla = inicializarLista();
		table = new JTable(datosTabla, columnNames);
		actividadesDeportivas.setViewportView(table);

		
		
		btnOk = new JButton("Aceptar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AceptarActionPerformed();
			}
		});
		btnOk.setBounds(481, 349, 98, 24);
		getContentPane().add(btnOk);

	}
	
	public String[][] inicializarLista(){
		ArrayList<String> a = icon.getActividadesDeportivas();
		String[][] data = new String[a.size()+1][4];
		try {
			DtActividadDeportiva dtad, dtadnew = icon.ConsultaActividadDeportiva(a.get(1));
			boolean yaAgregado = false;
			int cont = 0, numClass = 0, numClassNew;
			
			while(cont <= a.size()-1) {
				for(String s : a) {
					yaAgregado = false;
					dtad = icon.ConsultaActividadDeportiva(s);
					ArrayList<String> clases = icon.listarClases(dtad.getNombre());
					numClassNew = clases.size();
					
					//Comprueba si la actividad no fue agregada al string data
					for(int i = 0; i <= cont; i++) {
						if (dtad.getNombre() == data[i][0]) {
							yaAgregado = true;
						}
					}
					
					//Si la actividad no está en data y su cantidad de clases es menor que la de la última actividad, se agrega a data
					if (numClassNew <= numClass && yaAgregado == false) {
						dtadnew = icon.ConsultaActividadDeportiva(s);
						numClass = numClassNew; 
					}
					

				}
				
				data[cont][0] = dtadnew.getNombre();
				data[cont][1] = String.valueOf(icon.listarClases(dtadnew.getNombre()).size());
				data[cont][2] = String.valueOf(dtadnew.getCosto());
				data[cont][3] = dtadnew.getDescripcion();
				cont++;
			}
			
		}
		catch(NoExisteActividadDepEx e) {
			e.printStackTrace();
		}
		return data;
	}

	
	
	/*
	public void inicializarLista() {
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		ArrayList<String> a = icon.getActividadesDeportivas();
		for (String s : a) {
			modelo.addElement(s);
		}
		listActividades.setModel(modelo);
	}	
	
	public void selectedFromListActionPerformed (ActionEvent arg0) throws NoExisteActividadDepEx{
		actividadSelected = listActividades.getSelectedValue();
		if(listActividades.getSelectedValue() != null) {
			this.textAreaActividades.setVisible(true);
			DtActividadDeportiva dtad = icon.ConsultaActividadDeportiva(actividadSelected);
			this.textAreaActividades.setText(dtad.toString());
		}
		
	}
	
	public void limpiarTextAreaActionPerformed(ActionEvent arg0){
		this.textAreaActividades.setText("");
		JOptionPane.showMessageDialog(this.textAreaActividades, "Area de texto Limpiada con exito","Limpiar Area",JOptionPane.INFORMATION_MESSAGE);
	}

	
	class Sortbyroll implements Comparator<DefaultListModel<String>>
	{
	    // Used for sorting in ascending order of
	    // roll number
	    public int compare(Student a, Student b)
	    {
	        return a.rollno - b.rollno;
	    }
	}
	
	*/
	
	public void AceptarActionPerformed() {
		this.setVisible(false);
	}
}
