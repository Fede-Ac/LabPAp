package logica;

import java.util.ArrayList;

public class ManejadorClase {
	private static ManejadorClase instancia = null;
	
	private ArrayList<Clase> clases = new ArrayList<Clase>();
	
	private ManejadorClase() {}
	
	public static ManejadorClase getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorClase();
		}
		return instancia;
	}
	
	public boolean existeClase(String nombre) {
		Boolean existe = false; 
		for (Clase cls : clases) {
			if (cls.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}
	
	public void add(Clase clase) {
		clases.add(clase);		
	}

	

}
