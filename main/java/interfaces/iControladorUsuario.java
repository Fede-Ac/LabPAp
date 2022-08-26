package interfaces;
import java.util.ArrayList;

import datatypes.DtUsuario;
import excepciones.NoExistenUsuariosEx;
import excepciones.UsuarioRepetidoEx;


public interface iControladorUsuario {
	public void altaUsuario(DtUsuario dtU) throws UsuarioRepetidoEx;
	
	public DtUsuario consultaUsuario(String email);
	public ArrayList<String> mostrarUsuarios() throws NoExistenUsuariosEx;
}

