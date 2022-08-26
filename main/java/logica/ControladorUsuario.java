package logica;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.NoExistenUsuariosEx;
import excepciones.UsuarioRepetidoEx;
import interfaces.iControladorUsuario;

import java.util.ArrayList;


public class ControladorUsuario implements iControladorUsuario{

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
							  dtU.getFecha(), ((DtProfesor) dtU).getDescripcion(), ((DtProfesor) dtU).getBiografia(), ((DtProfesor) dtU).getSitioWeb());
		}
		if(dtU instanceof DtSocio) {
			uN = new Socio(dtU.getNickname(), dtU.getNombre(), dtU.getApellido(), dtU.getEmail(), dtU.getFecha());
		}
		
		mU.agregarUsuario(uN);
	}
	public ArrayList<String> mostrarUsuarios() throws NoExistenUsuariosEx{ // Retorna un set(String): ArrayList
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU == null)
			throw new NoExistenUsuariosEx ("Aun no se ha creado ningun Usuario");
		ArrayList<String> users = mU.toNickString();
		return users;
	}	
	public DtUsuario consultaUsuario(String email){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario uS = mU.buscarUsuarioPorEmail(email);
		DtUsuario dtU;
		
		if (uS instanceof Profesor) {
			dtU = new DtProfesor(uS.getNickname(),uS.getNombre(),uS.getApellido(),uS.getEmail(),uS.getFecha());
		}	
		else {
			dtU = new DtSocio(uS.getNickname(),uS.getNombre(),uS.getApellido(),uS.getEmail(),uS.getFecha());
		}
		
		return dtU;
	}

}
