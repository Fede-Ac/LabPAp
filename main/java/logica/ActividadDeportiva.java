package logica;

public class ActividadDeportiva {
	private String nombre;
	private String nombreInst;
	private String descripcion;
	private Integer duracion;
	private Float costo;
	private Fecha fechaReg;
	
	public ActividadDeportiva(String nombre, String nombreInst, String descripcion, Integer duracion, Float costo, Fecha fechaReg) {
		super();
		this.nombre = nombre;
		this.nombreInst = nombreInst;
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
	
	public void setNombreInst(String nombreInst) {
		this.nombreInst = nombreInst;
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

	public Fecha getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Fecha fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getNombreInst() {
		return nombreInst;
	}
	
	
	
	
}
