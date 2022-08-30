package datatypes;

import java.util.Date;

public class DtProfesor extends DtUsuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private String institucion;

	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fecha, String descripcion,
			String biografia, String sitioWeb, String institucion) {
		super(nickname, nombre, apellido, email, fecha);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.institucion = institucion;
	}

	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fecha) {
		super(nickname, nombre, apellido, email, fecha);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}
	
	public String getInstitucion() {
		return institucion;
	}

	@Override
	public String toString() {
		return "PROFESOR:\nNICK : " + getNickname() + "\n Nombre: " + getNombre() + "\n Apellido: " + getApellido() + "\nEmail: " + getEmail() 
				+ "\nFecha de Nacimiento: " + getFecha().getDay() +  "/" + getFecha().getMonth() + "/" + getFecha().getYear() 
				+ "\nDescripcion: " + descripcion + "\nBiografia: " + biografia + "\nSitioWeb: " + sitioWeb
				+ "\ninstitucion: " + institucion;
	}
	

}
