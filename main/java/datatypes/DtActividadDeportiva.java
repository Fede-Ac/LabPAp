package datatypes;

import java.util.ArrayList;
import java.util.Date;

public class DtActividadDeportiva {
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private Date fechaReg;
	private ArrayList<DtClase> clases;
	
	public DtActividadDeportiva(String nombre, String descripcion, Integer duracion, Float costo, Date fechaReg, ArrayList<DtClase> clases) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fechaReg = fechaReg;
		this.clases = clases;
	}

	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public Float getCosto() {
		return costo;
	}
	
	public Date getFechaReg() {
		return fechaReg;
	}	
	
	public ArrayList<DtClase> getClases() {
		return clases;
	}
}