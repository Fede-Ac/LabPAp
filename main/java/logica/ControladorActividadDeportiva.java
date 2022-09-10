package logica;

import interfaces.IControladorActividadDeportiva;

import java.util.ArrayList;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import excepciones.ActividadDepRepetidaEx;
import excepciones.NoExisteActividadDepEx;

public class ControladorActividadDeportiva implements IControladorActividadDeportiva{
	public ControladorActividadDeportiva() {
		super();
	}
	
	@Override 
	public Boolean existeInstitucionD(String nombreInst) {
		Boolean exists = false; 
		ManejadorInstitucionDep manejador = ManejadorInstitucionDep.getInstancia();
		exists = manejador.existeInstitucion(nombreInst);
		return exists;
	}
	
	@Override
	public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, DtFecha fecha) throws ActividadDepRepetidaEx{
		Boolean exists = false; 
		ManejadorActividadDeportiva manejador = ManejadorActividadDeportiva.getInstancia();
		ManejadorInstitucionDep mI = ManejadorInstitucionDep.getInstancia();
		exists = manejador.existeActividad(nombre);
		
		if(existeInstitucionD(nombreInst)){
			if(exists == false) {
				ActividadDeportiva nuevaActividad = new ActividadDeportiva(nombre, descripcion, duracion, costo, fecha);
				InstitucionDeportiva inst = mI.buscarInstitucion(nombreInst);
				inst.agregarActividadDeportiva(nuevaActividad);
				manejador.add(nuevaActividad);
			}
			else {
				throw new ActividadDepRepetidaEx("La actividad de nombre: " + nombre + " ya existe.");
			}
		}
		else {
			throw new ActividadDepRepetidaEx("La institución deportiva " + nombreInst + " no existe.");
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

	@Override
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep) throws NoExisteActividadDepEx {
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actividad = mAD.buscarActividadDeportiva(actDep);
		if(actividad == null) {
			throw new NoExisteActividadDepEx("No existe la actividad deportiva");
		}
		DtActividadDeportiva dtActividad = actividad.getDtActividadDeportiva();
		
		return dtActividad;
	}
	
	@Override
	public DtActividadDeportiva RegistroDictadoDeClase(String regClas) throws NoExisteActividadDepEx{
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actividad = mAD.buscarActividadDeportiva(regClas);
		if(actividad == null) {
			throw new NoExisteActividadDepEx("No existe la actividad deportiva");
		}
		DtActividadDeportiva dtActividad = actividad.getDtActividadDeportiva();
		
		return dtActividad;
	}
	@Override
	public ArrayList<String> listarClases(String actividadDeportiva) {
		ManejadorActividadDeportiva mA = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actDep = mA.buscarActividadDeportiva(actividadDeportiva);
		ArrayList<Clase> clas = actDep.getClases();
		ArrayList<String> actClasNombre = new ArrayList<String>();
		for(Clase i : clas) {
			actClasNombre.add(i.getNombre());
		}
		return actClasNombre;
	}
	@Override
	public DtClase getDtClase(String clase) {
		ManejadorClase mC = ManejadorClase.getInstancia();
		Clase cl = mC.buscarClase(clase);
		DtClase dt = cl.getDtClase();
		return dt;
	}
	
}
