package logica;

public class Clase {
	private String nombre;
	private Fecha fecha;
	private Integer hora;
	private String URL;
	private Fecha fechaAlt;
	
	public Clase(String nombre, Fecha fecha, int hora, String URL, Fecha fechaAlt) {
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
	public Fecha getFecha() {
		return fecha;
	}
	public void setFecha(Fecha fecha) {
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
	public Fecha getFechaAlt() {
		return fechaAlt;
	}
	public void setFechaReg(Fecha fechaAlt) {
		this.fechaAlt = fechaAlt;
	}
	
	
}
