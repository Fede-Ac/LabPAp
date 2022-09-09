package logica;

import java.util.ArrayList;

import datatypes.DtFecha;
import datatypes.DtFechaHora;
import excepciones.ClaseRepetidaEx;
import excepciones.NoExistenUsuariosEx;
import interfaces.IControladorClase;

public class ControladorClase implements IControladorClase{
	
	public ControladorClase() {
		super();
	}
	
	public void addClase(String actDep,String nombreClase, DtFechaHora fechaInicio, String nomProf, String URL, DtFecha fechaReg) throws ClaseRepetidaEx, NoExistenUsuariosEx {
		ManejadorClase mid = ManejadorClase.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario us = mU.buscarUsuarioPorNickname(nomProf);
		if (us==null)
			throw new NoExistenUsuariosEx("el usuario" + nomProf + "no existe");
		if (!mid.existeClase(nombreClase)) {
			//verificar que sea profesor
			Clase clase = new Clase(nombreClase, fechaInicio, (Profesor)us, URL, fechaReg);
			mid.add(clase);
		}else{
			throw new ClaseRepetidaEx("La clase de nombre: " + nombreClase + " ya existe.");
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
	public ArrayList<String> listarActividadesDeportivas(String institucion) {
		ManejadorInstitucionDep mI = ManejadorInstitucionDep.getInstancia();
		InstitucionDeportiva institucionDep = mI.buscarInstitucion(institucion);
		ArrayList<ActividadDeportiva> actDep = institucionDep.getActDeportivas();
		ArrayList<String> actDepNombre = new ArrayList<String>();
		for(ActividadDeportiva i : actDep) {
			actDepNombre.add(i.getNombre());
		}
		return actDepNombre;
	}


}
