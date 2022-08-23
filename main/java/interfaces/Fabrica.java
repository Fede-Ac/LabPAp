package interfaces;

import logica.ControladorUsuario;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica() {}
	
	public static Fabrica getInstancia() {
		if (instancia == null) {
			instancia = new Fabrica();
		}
		return instancia;
	}
	
	public iControladorUsuario getIControladorUsuario() {
		return new ControladorUsuario();
	}
	
}
