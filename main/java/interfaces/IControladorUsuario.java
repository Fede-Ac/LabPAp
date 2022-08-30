package interfaces;
import java.util.ArrayList;

import datatypes.DtUsuario;
import excepciones.NoExistenUsuariosEx;
import excepciones.UsuarioRepetidoEx;


public interface IControladorUsuario {
	public void altaUsuario(DtUsuario dtU) throws UsuarioRepetidoEx;
	
	public DtUsuario consultaUsuario(String email);
	public String[] mostrarUsuarios();
}

