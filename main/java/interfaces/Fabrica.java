package interfaces;

import logica.ControladorInstitucionDep;
import logica.ControladorClase;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica() {}
	
	public static Fabrica getInstancia() {
		if (instancia == null) {
			instancia = new Fabrica();
		}
		return instancia;
	}
	
	public IControladorInstitucionDep getIControladorInstitucionDep() {
		return new ControladorInstitucionDep();
	}
	
	public IControladorClase getIControladorClase() {
		return new ControladorClase();
	}
	
}
