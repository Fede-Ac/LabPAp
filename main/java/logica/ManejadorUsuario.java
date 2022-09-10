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

	public ArrayList<String> toNickString() {
		ArrayList<String> nickUsuarios = new ArrayList<>();
		for(Usuario u : this.usuarios){
			nickUsuarios.add(u.getNickname());
		}
		return nickUsuarios;
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		return usuarios;
	}
	
	public ArrayList<Socio> listarSocio(){
		
		ArrayList<Socio> socios = null;
		
		for(Usuario u : this.usuarios){			
			Socio s = (Socio) u;
			if ( s instanceof Socio)
				socios.add(s);					//Java dice que socios siempre va a ser null y por eso revienta.
		}
		return socios;	
	}

}
	

