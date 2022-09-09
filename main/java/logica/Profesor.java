package logica;

import java.util.ArrayList;

import datatypes.DtFecha;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import datatypes.DtUsuario;

public class Profesor extends Usuario {
	private String descripcion;
	private String biografia;//opcional
	private String sitioWeb;//opcional
	//links
	private InstitucionDeportiva institucion;	
	private ArrayList<Clase> clases;

	public Profesor(String nickname, String nombre, String apellido, String email, DtFecha fecha, String descripcion,
			String biografia, String sitioWeb, InstitucionDeportiva institucion) {
		super(nickname, nombre, apellido, email, fecha);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.institucion = institucion;
	}

	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}

	public Profesor(String nickname, String nombre, String apellido, String email, DtFecha fecha) {
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
	
	public ArrayList<Clase> getClases() {
		return clases;
	}
	
	public DtProfesor getDtProfesor() {
		return new DtProfesor(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getDtFechaNac(), this.descripcion,
				this.biografia, this.sitioWeb, this.institucion.getDtInstitucionDeportiva());
	}
	
	public DtProfesor consultaProfesor(Profesor prof) {
		DtProfesor retorno;
		retorno = new DtProfesor(prof.getNickname(), prof.getNombre(), prof.getApellido(), prof.getEmail(),
				prof.getDtFechaNac());
		return retorno;
	}

	@Override
	public DtUsuario consulta(Usuario uS) {

		DtProfesor dtP;
		dtP = new DtProfesor(uS.getNickname(), uS.getNombre(), uS.getApellido(), uS.getEmail(),
				uS.getDtFechaNac(), this.biografia, this.descripcion, this.sitioWeb,
				new DtInstitucionDeportiva(((Profesor) uS).getInstitucion().getNombre(),
						((Profesor) uS).getInstitucion().getDescripcion(), ((Profesor) uS).getInstitucion().getUrl()));

		return dtP;
	}
}
