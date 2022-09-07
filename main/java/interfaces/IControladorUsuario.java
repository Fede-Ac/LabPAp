package interfaces;

import datatypes.DtUsuario;

import excepciones.UsuarioRepetidoEx;


public interface IControladorUsuario {
	public void altaUsuario(DtUsuario dtU) throws UsuarioRepetidoEx;
	
	public DtUsuario consultaUsuario(String email);
	public String[] mostrarUsuarios();
}

