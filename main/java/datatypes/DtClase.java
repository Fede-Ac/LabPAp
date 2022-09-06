package datatypes;

import java.util.ArrayList;
import java.util.Date;

public class DtClase {
	private String nombre;
	private Date fecha;
	private Date horaInicio;
	private String url;
	private Date fechaReg;
	
	public DtClase(String nombre, Date fecha, Date horaInicio, String url, Date fechaReg) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
	}
	public String getNombre() {
		return nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public String getUrl() {
		return url;
	}

	public Date getFechaReg() {
		return fechaReg;
	}
	
	
	
}