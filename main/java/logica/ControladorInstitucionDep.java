package logica;

import interfaces.IControladorInstitucionDep;
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

}
