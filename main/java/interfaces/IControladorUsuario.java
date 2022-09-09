package interfaces;

import java.util.ArrayList;

import datatypes.DtInstitucionDeportiva;
import datatypes.DtUsuario;
import excepciones.NoExisteInstitucionDepEx;
import excepciones.UsuarioRepetidoEx;


public interface IControladorUsuario {
	public void altaUsuario(DtUsuario dtU) throws UsuarioRepetidoEx, NoExisteInstitucionDepEx;
	
	public DtUsuario consultaUsuario(String email);
	
	public String[] mostrarUsuarios();

	public ArrayList<String> listarInstituciones();

	DtInstitucionDeportiva getDtinstitucionDeportiva(String institucion);
}

