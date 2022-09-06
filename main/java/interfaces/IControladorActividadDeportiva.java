package interfaces;

import excepciones.ActividadDepRepetidaEx;

import java.lang.Boolean;

import java.util.GregorianCalendar;



public interface IControladorActividadDeportiva {
	public Boolean existeInstitucionD(String nombre);
	
	public void AltaActividadDeportiva(String nombre, String descripcion, int duracion, float costo, GregorianCalendar fecha) throws ActividadDepRepetidaEx;
}
                                   