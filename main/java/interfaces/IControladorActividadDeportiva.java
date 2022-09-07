package interfaces;



import excepciones.ActividadDepRepetidaEx;
import logica.Fecha;

import java.lang.Boolean;



public interface IControladorActividadDeportiva {
	public Boolean existeInstitucionD(String nombreInst);
	
	public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, Fecha fecha) throws ActividadDepRepetidaEx;
}
                                   