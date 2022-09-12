package logica;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import datatypes.DtFecha;
import datatypes.DtUsuario;

@MappedSuperclass
public abstract class Usuario {
	@Id
	private String nickname;//unico
	private String nombre;
	private String apellido;
	private String email;//unico
	private Calendar fechaNac;
	
	public Usuario(String nickname, String nombre, String apellido, String email, DtFecha fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;	
		Calendar c = new GregorianCalendar(fechaNac.getAnio(), fechaNac.getMes(), fechaNac.getDia());
		this.fechaNac = c;
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
		DtFecha dtF = new DtFecha(fechaNac);
		return dtF;
	}
	public void setDtFechaNac(DtFecha fechaNac) {
		Calendar c = new GregorianCalendar(fechaNac.getAnio(), fechaNac.getMes(), fechaNac.getDia());
		this.fechaNac = c;
	}
	//public abstract DtUsuario consulta(Usuario uS);
	
}
