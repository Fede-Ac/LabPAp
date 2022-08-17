package logica;

import java.util.Date;

public class Profesor extends Usuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;

	public Profesor(String nickname, String nombre, String apellido, String email, Date fecha, String descripcion,
			String biografia, String sitioWeb) {
		super(nickname, nombre, apellido, email, fecha);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
	}

	public Profesor(String nickname, String nombre, String apellido, String email, Date fecha) {
		super(nickname, nombre, apellido, email, fecha);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
}