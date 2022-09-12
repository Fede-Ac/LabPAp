package logica;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;

//@Entity
public class ActividadDeportiva {
	//@Id
	private String nombre;//unico
	private String descripcion;
	private int duracion;
	private Float costo;
	private DtFecha fechaReg;
	//links
	//@OneToMany(cascade = CascadeType.ALL)
	private ArrayList<Clase> clases = new ArrayList<Clase>();
	
	
	public ActividadDeportiva() {
		super();
	}

	public ActividadDeportiva(String nombre, String descripcion, int duracion, Float costo, DtFecha fechaReg) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public DtFecha getDtFechaReg() {
		return fechaReg;
	}

	public void setDtFechaReg(DtFecha fechaReg) {
		this.fechaReg = fechaReg;
	}

	public ArrayList<Clase> getClases() {
		return clases;
	}

	public void setClases(ArrayList<Clase> clases) {
		this.clases = clases;
	}

	public void agregarClase(Clase c) {
		clases.add(c);
	}
	
	public DtActividadDeportiva getDtActividadDeportiva() {
		
		ArrayList<DtClase> dtClases = new ArrayList<DtClase>();
		for(Clase c : clases) {
			dtClases.add(c.getDtClase());
		}
		DtActividadDeportiva dt = new DtActividadDeportiva(nombre, descripcion, duracion, costo, fechaReg, dtClases);
		return dt;
	}
	
	
	
	
}
