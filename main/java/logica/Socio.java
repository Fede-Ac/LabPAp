package logica;


import java.util.ArrayList;

import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtSocio;
import datatypes.DtUsuario;

public class Socio extends Usuario{
	//link
	private ArrayList<Registro> registros = new ArrayList<Registro>();
	
	public Socio(String nickname, String nombre, String apellido, String email, DtFecha fechaNac) {
		super(nickname, nombre, apellido, email, fechaNac);
	}

	//@Override
	//public DtUsuario consulta(Usuario uS) {
	//	return new DtSocio(uS.getNickname(),uS.getNombre(),uS.getApellido(),uS.getEmail(),uS.getDtFechaNac());
	//}
	
	public ArrayList<Registro> getRegistros(){
		return registros;
	}
	
	public void agregarRegistro(Registro r) {
		registros.add(r);
	}

	public DtSocio getDtSocio() {
		
		ArrayList<DtClase> clases = new ArrayList<DtClase>();
		for(Registro r : registros) {
			clases.add(r.getClase().getDtClase()); 
		}
		return new DtSocio(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getDtFechaNac(), clases);
	}
}
