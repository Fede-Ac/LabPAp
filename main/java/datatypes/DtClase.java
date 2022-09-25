package datatypes;

public class DtClase {
	private String nombre;//unico
	private DtFechaHora fechaInicio;
	private String profe;
	private String url;
	private DtFecha fechaReg;
	private String actDep;
	private int cantRegistros;
	
	public DtClase(String nombre, DtFechaHora fechaInicio, String profe, String url, DtFecha fechaReg, String actDep, int cantRegistros) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.profe = profe;
		this.url = url;
		this.fechaReg = fechaReg;
		this.actDep = actDep;
		this.cantRegistros = cantRegistros;
	}
	
	public String getNombre() {
		return nombre;
	}

	public DtFechaHora getFechaInicio() {
		return fechaInicio;
	}

	public String getProfe() {
		return profe;
	}

	public String getUrl() {
		return url;
	}

	public DtFecha getFechaReg() {
		return fechaReg;
	}
	
	public String getActDep() {
		return actDep;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nFecha de inicio: " + fechaInicio + "\nProfesor: " + profe + "\nUrl: " + url
				+ "\nFecha de registro: " + fechaReg.toString() + "\nRegistros: " + cantRegistros;
	}

	
}