package logica;


import java.util.Date;

import datatypes.DtSocio;
import datatypes.DtUsuario;

public class Socio extends Usuario{

	public Socio(String nickname, String nombre, String apellido, String email, Date fecha) {
		super(nickname, nombre, apellido, email, fecha);
	}

	@Override
	public String toString() {
		return "Socio [getNickname()=" + getNickname() + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getEmail()=" + getEmail() + ", getFecha()=" + getFecha() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public DtUsuario consulta(Usuario uS) {
		return new DtSocio(uS.getNickname(),uS.getNombre(),uS.getApellido(),uS.getEmail(),uS.getFecha());
	}

}
