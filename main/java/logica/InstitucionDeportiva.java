package logica;

import java.util.ArrayList;

import datatypes.DtInstitucionDeportiva;

public class InstitucionDeportiva {
	private String nombre;
	private String descripcion;
	private String url;
	//links
	private ArrayList<ActividadDeportiva> actDeportivas = new ArrayList<>();
	private ArrayList<Profesor> profesores;

	public InstitucionDeportiva(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<ActividadDeportiva> getActDeportivas() {
		return actDeportivas;
	}
	
	public DtInstitucionDeportiva getDtInstitucionDeportiva() {
		return new DtInstitucionDeportiva(this.nombre, this.descripcion, this.url);
	}
}
