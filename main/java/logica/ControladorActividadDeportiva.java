package logica;

import java.util.GregorianCalendar;

import interfaces.IControladorActividadDeportiva;

import excepciones.ActividadDepRepetidaEx;

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
	public void AltaActividadDeportiva(String nombre, String descripcion, int duracion, float costo, GregorianCalendar fecha) throws ActividadDepRepetidaEx{
		Boolean exists = false; 
		ManejadorActividadDeportiva manejador = ManejadorActividadDeportiva.getInstancia();
		exists = manejador.existeActividad(nombre);
		
		
		if(exists == false) {
			ActividadDeportiva nuevaActividad = new ActividadDeportiva(nombre, descripcion, duracion, costo, fecha);
			manejador.add(nuevaActividad);
		}
		else {
			throw new ActividadDepRepetidaEx("La actividad de nombre: " + nombre + " ya existe.");
		}
	}

	
}
