package logica;

import datatypes.DtProfesor;
import datatypes.DtUsuario;

public class Profesor extends Usuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;

	public Profesor(String nickname, String nombre, String apellido, String email, Fecha fecha, String descripcion,
			String biografia, String sitioWeb) {
		super(nickname, nombre, apellido, email, fecha);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
	}

	public Profesor(String nickname, String nombre, String apellido, String email, Fecha fecha) {
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

	@Override
	public String toString() {
		return "Profesor [descripcion=" + descripcion + ", biografia=" + biografia + ", sitioWeb=" + sitioWeb + "]";
	}
	
	public DtProfesor consultaProfesor(Profesor prof) {
		DtProfesor retorno;
		retorno = new DtProfesor(prof.getNickname(),prof.getNombre(),prof.getApellido(),prof.getEmail(),prof.getFecha().getDtFecha());
		return retorno;
	}

	@Override
	public DtUsuario consulta(Usuario uS) {
		
		DtProfesor dtP;
		dtP = new DtProfesor(uS.getNickname(),uS.getNombre(),uS.getApellido(),uS.getEmail(),uS.getFecha().getDtFecha(),this.biografia,this.descripcion,this.sitioWeb, this.biografia);
		
		return dtP;
	}
}
