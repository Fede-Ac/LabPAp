package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtFechaHora;

@Entity
public class Clase {
	@Id
	private String nombre;//unico
	@Transient
	private DtFechaHora fechaInicio;
	private String url;
	private Calendar fechaReg;
	//links
	@Transient
	private Profesor profe;
	//private ArrayList<Socio> socios;
	@OneToMany(mappedBy="clase",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<Registro>();
	
	
	
	public Clase() {
		super();
	}

	public Clase(String nombre, DtFechaHora fechaInicio, Profesor profe, String url, DtFecha fechaReg) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.profe = profe;
		this.url = url;
		Calendar cal = new GregorianCalendar(fechaReg.getAnio(),fechaReg.getMes(),fechaReg.getDia());
		
		this.fechaReg = cal;
		profe.agregarClase(this);
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
		return null;
	}

	public void setDtFechaAlta(DtFecha fechaReg) {
		//this.fechaReg = fechaReg;
	}
	
	public ArrayList<Registro> getRegistros(){
		return null;
	}
	
	public void agregarRegistro(Registro r) {
		registros.add(r);
	}

	public DtClase getDtClase() {
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actDep = mAD.buscarActividadDeportivaPorClase(this);
		String actDepNombre = actDep.getNombre();
		
		//DtClase dt = new DtClase(nombre, fechaInicio, profe.getNickname(), url, fechaReg, actDepNombre);
		return null;
	}
	
}
