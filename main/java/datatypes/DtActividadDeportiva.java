package datatypes;

import java.util.ArrayList;

public class DtActividadDeportiva {
	private String nombre;
	private String descripcion;
	private int duracion;
	private Float costo;
	private DtFecha fechaReg;
	
	private ArrayList<DtClase> clases;
	
	public DtActividadDeportiva(String nombre, String descripcion, int duracion, Float costo, DtFecha fechaReg,
			ArrayList<DtClase> clases) {
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

	public int getDuracion() {
		return duracion;
	}

	public Float getCosto() {
		return costo;
	}

	public DtFecha getFechaReg() {
		return fechaReg;
	}

	public ArrayList<DtClase> getClases() {
		return clases;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nDescripción: " + descripcion + "\nDuración: " + duracion
				+ "\nCosto: " + costo + "\nFecha Registro: " + fechaReg + "\nClases=" + clases;
	}
	
	
}