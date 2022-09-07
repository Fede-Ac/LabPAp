package logica;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoEx;
import interfaces.IControladorUsuario;

import java.util.ArrayList;


public class ControladorUsuario implements IControladorUsuario{

	public ControladorUsuario() {
		super();
	}
	
	public void altaUsuario(DtUsuario dtU) throws UsuarioRepetidoEx{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario uN = mU.buscarUsuarioPorNickname(dtU.getNickname());
		Usuario uE = mU.buscarUsuarioPorEmail(dtU.getEmail());
	
		if(uN != null) 
			throw new UsuarioRepetidoEx("El usuario " + uN.getNickname() + " ya esta registrado");
		
		if(uE != null) 
			throw new UsuarioRepetidoEx("El usuario con email " + uE.getEmail() + " ya esta registrado");
		
		
		
		if(dtU instanceof DtProfesor) {
			
			//se busca si la institucion existe, si no existe tira un error, si existe se la pasa por parametro al constructor
			
			uN = new Profesor(dtU.getNickname(), dtU.getNombre(), dtU.getApellido(), dtU.getEmail(),
					new Fecha(dtU.getFecha()), ((DtProfesor) dtU).getDescripcion(), ((DtProfesor) dtU).getBiografia(), ((DtProfesor) dtU).getSitioWeb());
		}
		if(dtU instanceof DtSocio) {
			//Fecha fecha = new Fecha(dtU.getFecha());
			uN = new Socio(dtU.getNickname(), dtU.getNombre(), dtU.getApellido(), dtU.getEmail(), new Fecha(dtU.getFecha()));
		}
		
		mU.agregarUsuario(uN);
	}
	public String[] mostrarUsuarios(){ // Retorna un set(String): ArrayList
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> users = mU.toNickString();
		String[] users_ret = new String[users.size()];
		int i = 0;
		for(String s : users) {
			users_ret[i]=s;
			i++;
		}		
		return users_ret;
	}	
	public DtUsuario consultaUsuario(String nick){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario uS = mU.buscarUsuarioPorNickname(nick);
		DtUsuario dtU;
		
		if (uS instanceof Profesor) {
			Profesor p = (Profesor) uS;
			 dtU = new DtProfesor(p.getNickname(),p.getNombre(),p.getApellido(),p.getEmail(),p.getFecha().getDtFecha(),p.getBiografia(),p.getDescripcion(),p.getSitioWeb(),null);
			 // missing institution.
				
		}	
		else {
			Socio s = (Socio) uS;
			dtU = new DtSocio(s.getNickname(),s.getNombre(),s.getApellido(),s.getEmail(),s.getFecha().getDtFecha());
		}
		
		return dtU;
	}

}
