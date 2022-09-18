package logica;

import interfaces.IControladorInstitucionDep;

import java.util.ArrayList;

import excepciones.InstitucionDepRepetidaEx;

public class ControladorInstitucionDep implements IControladorInstitucionDep {
	public ControladorInstitucionDep() {
		super();
	}
	
	@Override
	public void addInstitucionDep(String nombre, String descripcion, String URL) throws InstitucionDepRepetidaEx{
		ManejadorInstitucionDep mid = ManejadorInstitucionDep.getInstancia();
		if (!mid.existeInstitucion(nombre)) {
			InstitucionDeportiva instDep = new InstitucionDeportiva(nombre, descripcion, URL);
			mid.add(instDep);
		}else{
			throw new InstitucionDepRepetidaEx("La institución de nombre: " + nombre + " ya existe.");
		}
	}
	
	@Override
	public ArrayList<String> listarInstituciones() {
		ManejadorInstitucionDep mI = ManejadorInstitucionDep.getInstancia();
		ArrayList<InstitucionDeportiva> instituciones = mI.listarInstituciones();
		ArrayList<String> institucionesNombre = new ArrayList<String>();
		for(InstitucionDeportiva i : instituciones) {
			institucionesNombre.add(i.getNombre());
		}
		return institucionesNombre;
	}

	@Override
	public void updateInstDep(String nombre, String desc, String url) {
		ManejadorInstitucionDep mid = ManejadorInstitucionDep.getInstancia();
		InstitucionDeportiva instDep = mid.buscarInstitucion(nombre);
		instDep.setDescripcion(desc);
		instDep.setUrl(url);
		mid.updateInstitucionDep(instDep);
	}

}
