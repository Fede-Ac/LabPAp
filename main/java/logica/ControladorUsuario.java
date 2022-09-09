package logica;

import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.NoExisteInstitucionDepEx;
import excepciones.UsuarioRepetidoEx;
import interfaces.IControladorUsuario;

import java.util.ArrayList;


public class ControladorUsuario implements IControladorUsuario{

	public ControladorUsuario() {
		super();
	}
	
	public void altaUsuario(DtUsuario dtU) throws UsuarioRepetidoEx, NoExisteInstitucionDepEx{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorInstitucionDep mInstDep = ManejadorInstitucionDep.getInstancia();
		Usuario uN = mU.buscarUsuarioPorNickname(dtU.getNickname());
		Usuario uE = mU.buscarUsuarioPorEmail(dtU.getEmail());
		
		if(uN != null) 
			throw new UsuarioRepetidoEx("El usuario " + uN.getNickname() + " ya esta registrado");
		
		if(uE != null) 
			throw new UsuarioRepetidoEx("El usuario con email " + uE.getEmail() + " ya esta registrado");
		
		if(dtU instanceof DtProfesor) {
			InstitucionDeportiva instDep = mInstDep.buscarInstitucion(((DtProfesor) dtU).getInstitucion().getNombre());
			if (instDep == null)
				throw new NoExisteInstitucionDepEx("No existe la institución deportiva: " +((DtProfesor) dtU).getInstitucion().getNombre());
			uN = new Profesor(dtU.getNickname(), dtU.getNombre(), dtU.getApellido(), dtU.getEmail(),
					dtU.getFecha(), ((DtProfesor) dtU).getDescripcion(), ((DtProfesor) dtU).getBiografia(), ((DtProfesor) dtU).getSitioWeb(),instDep);
		}
		if(dtU instanceof DtSocio) {
			uN = new Socio(dtU.getNickname(), dtU.getNombre(), dtU.getApellido(), dtU.getEmail(), dtU.getFecha());
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
			 dtU = new DtProfesor(p.getNickname(),p.getNombre(),p.getApellido(),p.getEmail(),p.getDtFechaNac(),p.getBiografia(),p.getDescripcion(),p.getSitioWeb(), new DtInstitucionDeportiva(p.getInstitucion().getNombre(),p.getInstitucion().getDescripcion(),p.getInstitucion().getUrl()));
		}	
		else {
			Socio s = (Socio) uS;
			dtU = new DtSocio(s.getNickname(),s.getNombre(),s.getApellido(),s.getEmail(),s.getDtFechaNac());
		}
		
		return dtU;
	}

}
