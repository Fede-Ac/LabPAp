package datatypes;


public class DtClase {
	private String nombre;
	private DtFecha fecha;
	//private DtFecha horaInicio;
	private Integer horaInicio;
	private String url;
	private DtFecha fechaReg;
	
	public DtClase(String nombre, DtFecha fecha, /*DtFecha horaInicio*/Integer horaInicio, String url, DtFecha fechaReg) {
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

	public DtFecha getFecha() {
		return fecha;
	}

	public /*DtFecha*/Integer getHoraInicio() {
		return horaInicio;
	}

	public String getUrl() {
		return url;
	}

	public DtFecha getFechaReg() {
		return fechaReg;
	}
	
	
	
}