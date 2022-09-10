package datatypes;

import java.util.ArrayList;

public class DtSocio extends DtUsuario{

	private ArrayList<DtClase> clases = new ArrayList<DtClase>();
	
	public DtSocio(String nickname, String nombre, String apellido, String email, DtFecha fecha, ArrayList<DtClase> clases) {
		super(nickname, nombre, apellido, email, fecha);
		this.clases = clases;
	}

	@Override
	public String toString() {
		String datos = "SOCIO \nNICK: " + getNickname() + "\nNombre: " + getNombre() + "\nApellido: "
				+ getApellido() + "\nCorreo electrónico: " + getEmail() +
				"\nFecha de Nacimiento: " + fechaNac.toString()+ "\nClases en las que esta registrado: \n";
		
		String datosClase = "";
		for(DtClase c : clases) {
			datosClase = datosClase + c.getNombre() + " - " + c.getActDep() + "\n";
		}
		
		if(datosClase == "") {
			datosClase = "No esta registrado a ninguna clase";
		}
		
		datos = datos + datosClase;
		
		return datos;
	}

	
}
