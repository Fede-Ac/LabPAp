package logica;

import java.util.ArrayList;

public class ManejadorInstitucionDep {
	private static ManejadorInstitucionDep instancia = null;
	
	private ArrayList<InstitucionDeportiva> instDeportivas = new ArrayList<>();
	
	private ManejadorInstitucionDep() {}
	
	public static ManejadorInstitucionDep getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorInstitucionDep();
		}
		return instancia;
	}

	public boolean existeInstitucion(String nombre) {
		Boolean existe = false; 
		for (InstitucionDeportiva instDep : instDeportivas) {
			if (instDep.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}
	
	public InstitucionDeportiva buscarInstitucion(String nombre) {
		InstitucionDeportiva institucion=null;
		for(InstitucionDeportiva i: instDeportivas) {
			if (i.getNombre().equals(nombre))
				institucion = i;
		}
		return institucion;
	}

	public void add(InstitucionDeportiva instDep) {
		instDeportivas.add(instDep);		
	}
	
	public ArrayList<InstitucionDeportiva> listarInstituciones(){
		return instDeportivas;
	}
	
	
}
