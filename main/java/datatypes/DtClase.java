package datatypes;

public class DtClase {
	private String nombre;//unico
	private DtFechaHora fechaInicio;
	private DtProfesor profe;
	private String url;
	private DtFecha fechaReg;
	
	public DtClase(String nombre, DtFechaHora fechaInicio, DtProfesor profe, String url, DtFecha fechaReg) {
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

	public DtFechaHora getFechaInicio() {
		return fechaInicio;
	}

	public DtProfesor getProfe() {
		return profe;
	}

	public String getUrl() {
		return url;
	}

	public DtFecha getFechaReg() {
		return fechaReg;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nFecha de inicio: " + fechaInicio + "\nProfesor: " + profe + "\nUrl: " + url
				+ "\nFecha de registro: " + fechaReg.toString();
	}

	
}