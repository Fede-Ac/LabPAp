package interfaces;

import excepciones.InstitucionDepRepetidaEx;

public interface IControladorInstitucionDep {
	public void addInstitucionDep(String nombre, String descripcion, String URL) throws InstitucionDepRepetidaEx;
	
	//public void updateInstitucionDep(String nombre, String descripcion, String URL);
}
