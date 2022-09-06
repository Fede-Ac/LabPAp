package logica;

//import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Clase {
	private String nombre;
	private GregorianCalendar fecha;
	private Integer hora;
	private String URL;
	private GregorianCalendar fechaAlt;
	
	//private ArrayList<Clase> clases = new ArrayList<Clase>();
	
	public Clase(String nombre, GregorianCalendar fecha, int hora, String URL, GregorianCalendar fechaAlt) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.URL = URL;
		this.fechaAlt = fechaAlt;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	public int getHoraInicio() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public String getUrl() {
		return URL;
	}
	public void setUrl(String URL) {
		this.URL = URL;
	}
	public GregorianCalendar getFechaAlt() {
		return fechaAlt;
	}
	public void setFechaReg(GregorianCalendar fechaAlt) {
		this.fechaAlt = fechaAlt;
	}
	
	
}
