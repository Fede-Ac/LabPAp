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
	private JLabel lblActividadesDeportivas;
	private JScrollPane actividadesDeportivas;
	private JList<String> listActividades = new JList<String>();
	private JScrollPane dataActividades;
	private JTextArea textAreaActividades = new JTextArea();
	private JButton btnOk;
	private String actividadSelected;
	private List list;
	
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
		actividadesDeportivas.setBounds(35, 38, 364, 295);
		getContentPane().add(actividadesDeportivas);
		actividadesDeportivas.setViewportView(listActividades);
		
		lblActividadesDeportivas = new JLabel("Actividades Deportivas");
		actividadesDeportivas.setColumnHeaderView(lblActividadesDeportivas);
		
		list = new List();
		actividadesDeportivas.setRowHeaderView(list);
		listActividades.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				actividadSelectedAcionPerformed(arg0);
			}
		});
		
		dataActividades = new JScrollPane();
		dataActividades.setBounds(438, 38, 87, 295);
		getContentPane().add(dataActividades);
		

		dataActividades.setViewportView(textAreaActividades);
		textAreaActividades.setVisible(false);
		textAreaActividades.setEditable(false);
		
		btnOk = new JButton("Aceptar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AceptarActionPerformed();
			}
		});
		btnOk.setBounds(481, 349, 98, 24);
		getContentPane().add(btnOk);

	}
	
	
	
	public void inicializarLista() {
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		ArrayList<String> a = icon.getActividadesDeportivas();
		for (String s : a) {
			modelo.addElement(s);
		}
		listActividades.setModel(modelo);
	}	
	
	public void actividadSelectedAcionPerformed(ListSelectionEvent e){
		actividadSelected = listActividades.getSelectedValue();
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
	
	public void AceptarActionPerformed() {
		this.setVisible(false);
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
}
