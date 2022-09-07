package datatypes;

public class DtProfesor extends DtUsuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private String institucion;

	public DtProfesor(String nickname, String nombre, String apellido, String email, DtFecha fecha, String descripcion,
			String biografia, String sitioWeb, String institucion) {
		super(nickname, nombre, apellido, email, fecha);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.institucion = institucion;
	}

	public DtProfesor(String nickname, String nombre, String apellido, String email, DtFecha fecha) {
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
		
		return "PROFESOR:\nNickname : " + getNickname() + "\nNombre: " + getNombre() + "\nApellido: " + getApellido() + "\nEmail: " + getEmail() 
				+ "\nFecha de Nacimiento: " + fecha.toString()
				+ "\nDescripción: " + descripcion + "\nBiografía: " + biografia + "\nSitioWeb: " + sitioWeb
				+ "\nInstitución: " + institucion;
	}
	

}
