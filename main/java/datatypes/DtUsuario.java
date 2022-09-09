package datatypes;

public abstract class DtUsuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	protected DtFecha fechaNac;
	
	public DtUsuario(String nickname, String nombre, String apellido, String email, DtFecha fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
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
	public DtFecha getFecha() {
		return fechaNac;
	}

	@Override
	public String toString() {
		return "Nickname: " + nickname + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEmail: " + email
				+ "\nFecha: " + fechaNac;
	}
	
	
	
}
