package logica;

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
	public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, Fecha fecha) throws ActividadDepRepetidaEx{
		Boolean exists = false; 
		ManejadorActividadDeportiva manejador = ManejadorActividadDeportiva.getInstancia();
		exists = manejador.existeActividad(nombre);
		
		if(existeInstitucionD(nombreInst)){
			if(exists == false) {
				ActividadDeportiva nuevaActividad = new ActividadDeportiva(nombre, nombreInst, descripcion, duracion, costo, fecha);
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
}
