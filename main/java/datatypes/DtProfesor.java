package datatypes;

public class DtProfesor extends DtUsuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private DtInstitucionDeportiva institucion;

	public DtProfesor(String nickname, String nombre, String apellido, String email, DtFecha fecha, String descripcion,
			String biografia, String sitioWeb, DtInstitucionDeportiva institucion) {
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
	
	public DtInstitucionDeportiva getInstitucion() {
		return institucion;
	}
	@Override
	public String toString() {
		
		return "PROFESOR:\nNickname : " + getNickname() + "\nNombre: " + getNombre() + "\nApellido: " + getApellido() + "\nEmail: " + getEmail() 
				+ "\nFecha de Nacimiento: " + fechaNac.toString()
				+ "\nDescripción: " + descripcion + "\nBiografía: " + biografia + "\nSitioWeb: " + sitioWeb
				+ "\nInstitución: \n" + institucion.toString();
	}
	

}
