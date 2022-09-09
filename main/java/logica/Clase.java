package logica;

import java.util.ArrayList;

import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtFechaHora;

public class Clase {
	private String nombre;//unico
	private DtFechaHora fechaInicio;
	private String url;
	private DtFecha fechaReg;
	//links
	private Profesor profe;
	//private ArrayList<Socio> socios;
	private ArrayList<Registro> registros = new ArrayList<Registro>();
	
	public Clase(String nombre, DtFechaHora fechaInicio, Profesor profe, String url, DtFecha fechaReg) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.profe = profe;
		this.url = url;
		this.fechaReg = fechaReg;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DtFechaHora getDtFechaInicio() {
		return fechaInicio;
	}

	public void setDtFechaInicio(DtFechaHora fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Profesor getProfe() {
		return profe;
	}

	public void setProfe(Profesor profe) {
		this.profe = profe;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DtFecha getDtFechaAlta() {
		return fechaReg;
	}

	public void setDtFechaAlta(DtFecha fechaReg) {
		this.fechaReg = fechaReg;
	}

	public DtClase getDtClase() {
		DtClase dt = new DtClase(nombre, fechaInicio, profe.getDtProfesor(), url, fechaReg);
		return dt;
	}
	
}
