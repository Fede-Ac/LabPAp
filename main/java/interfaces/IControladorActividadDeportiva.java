package interfaces;



import excepciones.ActividadDepRepetidaEx;
import excepciones.NoExisteActividadDepEx;

import java.lang.Boolean;
import java.util.ArrayList;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;

public interface IControladorActividadDeportiva {
	public Boolean existeInstitucionD(String nombreInst);
	
	public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, DtFecha fecha) throws ActividadDepRepetidaEx;

	public ArrayList<String> listarInstituciones();

	public ArrayList<String> listarActividadesDeportivas(String institucion);
	
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep) throws NoExisteActividadDepEx;
	
	public ArrayList<String> listarClases(String clase);

	public DtClase getDtClase(String clase);
}
                                   