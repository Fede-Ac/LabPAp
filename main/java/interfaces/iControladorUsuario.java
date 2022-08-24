package interfaces;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoEx;

public interface iControladorUsuario {
	public void altaUsuario(DtUsuario dtU) throws UsuarioRepetidoEx;
}
