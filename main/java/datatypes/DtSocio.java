package datatypes;

import java.util.Date;

public class DtSocio extends DtUsuario{

	public DtSocio(String nickname, String nombre, String apellido, String email, Date fecha) {
		super(nickname, nombre, apellido, email, fecha);
	}

	@Override
	public String toString() {
		return "SOCIO \n NICK: " + getNickname() + "\n Nombre: " + getNombre() + "\n Apellido: "
				+ getApellido() + "\n correo electronico: " + getEmail() +
				"\n Fecha de Nacimiento: " + getFecha().getDay() +  "/" + getFecha().getMonth() + "/" + getFecha().getYear();
	}

	
}
