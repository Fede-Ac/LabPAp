package interfaces;

import java.util.ArrayList;

import excepciones.InstitucionDepRepetidaEx;

public interface IControladorInstitucionDep {
	public void addInstitucionDep(String nombre, String descripcion, String URL) throws InstitucionDepRepetidaEx;

	public ArrayList<String> listarInstituciones();

	public void updateInstDep(String nombre, String desc, String url);

}
