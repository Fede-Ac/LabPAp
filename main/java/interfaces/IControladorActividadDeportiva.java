package interfaces;

import datatypes.DtFecha;

import excepciones.ActividadDepRepetidaEx;

import java.lang.Boolean;



public interface IControladorActividadDeportiva {
	public Boolean existeInstitucionD(String nombreInst);
	
	public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, DtFecha fecha) throws ActividadDepRepetidaEx;
}
                                   