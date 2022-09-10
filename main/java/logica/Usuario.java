package logica;

import datatypes.DtFecha;
import datatypes.DtUsuario;

public abstract class Usuario {
	private String nickname;//unico
	private String nombre;
	private String apellido;
	private String email;//unico
	private DtFecha fechaNac;
	
	public Usuario(String nickname, String nombre, String apellido, String email, DtFecha fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
	}
	
	public Usuario() {
		super();
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public DtFecha getDtFechaNac() {
		return fechaNac;
	}
	public void setDtFechaNac(DtFecha fechaNac) {
		this.fechaNac = fechaNac;
	}
	//public abstract DtUsuario consulta(Usuario uS);
	
}
