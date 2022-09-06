package logica;

import java.util.GregorianCalendar;

public class ActividadDeportiva {
	private String nombre;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private GregorianCalendar fechaReg;
	
	public ActividadDeportiva(String nombre, String descripcion, Integer duracion, Float costo, GregorianCalendar fechaReg) {
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

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public GregorianCalendar getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(GregorianCalendar fechaReg) {
		this.fechaReg = fechaReg;
	}
	
	
	
	
}
