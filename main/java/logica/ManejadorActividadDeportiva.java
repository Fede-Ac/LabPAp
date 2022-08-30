package logica;

import java.util.ArrayList;

public class ManejadorActividadDeportiva {
	private static ManejadorActividadDeportiva instancia = null;
	
	private ArrayList<ActividadDeportiva> actDeportivas = new ArrayList<>();
	
	private ManejadorActividadDeportiva() {}
	
	public static ManejadorActividadDeportiva getInstancia() {
		if(instancia == null) {
			instancia = new ManejadorActividadDeportiva();
		}
		return instancia;
	}
	
	public boolean existeActividad(String nombre) {
		Boolean existe = false; 
		for (ActividadDeportiva actDep : actDeportivas) {
			if (actDep.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}

	public void add(ActividadDeportiva actDep) {
		actDeportivas.add(actDep);		
	}
}
