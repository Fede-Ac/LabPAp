package logica;

import java.util.ArrayList;

import datatypes.DtFecha;
import datatypes.DtFechaHora;
import datatypes.DtProfesor;
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

	@Override
	public ArrayList<String> listarProfesores(String institucion) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<Usuario> usuarios = mU.listarUsuarios();
		ArrayList<String> profesores = new ArrayList<String>();
		for(Usuario u : usuarios) {
			if(u instanceof Profesor) {
				if(((Profesor) u).getInstitucion().getNombre().equals(institucion)) {
					profesores.add(u.getNickname());
				}
				
			}
		}
		
		return profesores;
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
	
	


}
