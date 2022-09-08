package interfaces;



import excepciones.ActividadDepRepetidaEx;
import logica.Fecha;

import java.lang.Boolean;
import java.util.ArrayList;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;



public interface IControladorActividadDeportiva {
	public Boolean existeInstitucionD(String nombreInst);
	
	public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, Fecha fecha) throws ActividadDepRepetidaEx;

	public ArrayList<String> listarInstituciones();

	public ArrayList<String> listarActividadesDeportivas(String institucion);
	
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep);
}
                                   