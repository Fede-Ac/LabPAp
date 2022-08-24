package logica;

import java.util.ArrayList;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	private ManejadorUsuario() {}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null) 
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public void agregarUsuario(Usuario u) {
		usuarios.add(u);
	}
	
	public Usuario buscarUsuarioPorNickname(String nickname) {
		Usuario usuario=null;
		for(Usuario u: usuarios) {
			if (u.getNickname().equals(nickname))
				usuario = u;
		}
		return usuario;
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		Usuario usuario=null;
		for(Usuario u: usuarios) {
			if (u.getEmail().equals(email))
				usuario = u;
		}
		return usuario;
	}
	
}
