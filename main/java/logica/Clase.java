package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtFechaHora;

@Entity
public class Clase {
	@Id
	private String nombre;//unico
	private Calendar fechaInicio;
	private String url;
	private Calendar fechaReg;
	//links
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
		Calendar c = new GregorianCalendar(fechaInicio.getAnio(),fechaInicio.getMes(),fechaInicio.getDia(),fechaInicio.getHora(),fechaInicio.getMin());
		this.fechaInicio = c;
		this.profe = profe;
		this.url = url;
		Calendar c2 = new GregorianCalendar(fechaReg.getAnio(), fechaReg.getMes(), fechaReg.getDia());
		this.fechaReg = c2;

		profe.agregarClase(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DtFechaHora getDtFechaInicio() {
		
		DtFechaHora dtF = new DtFechaHora(fechaInicio, fechaInicio.get(Calendar.HOUR), fechaInicio.get(Calendar.MINUTE));
		return dtF;
	}

	public void setDtFechaInicio(DtFechaHora fechaInicio) {
		Calendar c = new GregorianCalendar(fechaInicio.getAnio(), fechaInicio.getMes(), fechaInicio.getDia());//no da hora y minuto
		this.fechaInicio = c;
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
		DtFecha dtF = new DtFecha(fechaReg);
		return dtF;
	}

	public void setDtFechaAlta(DtFecha fechaReg) {
		Calendar c = new GregorianCalendar(fechaReg.getAnio(), fechaReg.getMes(), fechaReg.getDia());
		this.fechaReg = c;
	}
	
	public ArrayList<Registro> getRegistros(){
		return (ArrayList<Registro>)registros;
	}
	
	public void agregarRegistro(Registro r) {
		registros.add(r);
	}

	public DtClase getDtClase() {
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actDep = mAD.buscarActividadDeportivaPorClase(this);
		String actDepNombre = actDep.getNombre();
		
		DtFecha dtF = new DtFecha(fechaReg);
		DtFechaHora dtFH = new DtFechaHora(fechaInicio, fechaInicio.get(Calendar.HOUR), fechaInicio.get(Calendar.MINUTE));
		DtClase dt = new DtClase(nombre, dtFH, profe.getNickname(), url, dtF, actDepNombre);
		return dt;
	}
	
}
