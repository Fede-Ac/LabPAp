package datatypes;

public class DtSocio extends DtUsuario{

	public DtSocio(String nickname, String nombre, String apellido, String email, DtFecha fecha) {
		super(nickname, nombre, apellido, email, fecha);
	}

	@Override
	public String toString() {
		return "SOCIO \nNICK: " + getNickname() + "\nNombre: " + getNombre() + "\nApellido: "
				+ getApellido() + "\nCorreo electrónico: " + getEmail() +
				"\nFecha de Nacimiento: " + fechaNac.toString();
	}

	
}
