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
	
	public ActividadDeportiva buscarActividadDeportiva(String nombre) {
		ActividadDeportiva actDep=null;
		for(ActividadDeportiva a: actDeportivas) {
			if (a.getNombre().equals(nombre))
				actDep = a;
		}
		return actDep;
	}
	
	public ActividadDeportiva buscarActividadDeportivaPorClase(Clase clase) {
		ActividadDeportiva actDep=null;
		for(ActividadDeportiva a: actDeportivas) {
			ArrayList<Clase> clases = a.getClases();
			for(Clase c : clases) {
				if (c.getNombre().equals(clase.getNombre()))
					actDep = a;
			}
			
		}
		return actDep;
	}
	
	public void add(ActividadDeportiva actDep) {
		actDeportivas.add(actDep);		
	}
}
