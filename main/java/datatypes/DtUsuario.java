package datatypes;

import java.util.Date;

public class DtUsuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fecha;
	
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fecha) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fecha = fecha;
	}
	
	public DtUsuario() {
		super();
	}

	public String getNickname() {
		return nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getEmail() {
		return email;
	}
	public Date getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "DtUsuario [nickname=" + nickname + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", fecha=" + fecha + "]";
	}
	
	
	
}
