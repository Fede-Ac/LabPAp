package logica;


import java.util.ArrayList;

import datatypes.DtFecha;
import datatypes.DtSocio;
import datatypes.DtUsuario;

public class Socio extends Usuario{
	//link
	private ArrayList<Clase> clases;
	
	public Socio(String nickname, String nombre, String apellido, String email, DtFecha fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
	}

	@Override
	public DtUsuario consulta(Usuario uS) {
		return new DtSocio(uS.getNickname(),uS.getNombre(),uS.getApellido(),uS.getEmail(),uS.getDtFechaNac());
	}

	public DtSocio getDtSocio() {
		return new DtSocio(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getDtFechaNac());
	}
}
