package logica;

import java.util.ArrayList;

public class ManejadorClase {
	private static ManejadorClase instancia = null;
	
	private ArrayList<InstitucionDeportiva> clases = new ArrayList<>();
	
	private ManejadorClase() {}
	
	public static ManejadorClase getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorClase();
		}
		return instancia;
	}
	
	public boolean existeClase(String nombre) {
		Boolean existe = false; 
		for (Clase clase : clases) {
			if (clase.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}
	
	public void add(InstitucionDeportiva clase) {
		instDeportivas.add(instDep);		
	}

	

}
