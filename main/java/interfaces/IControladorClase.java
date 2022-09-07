package interfaces;

import excepciones.ClaseRepetidaEx;
import logica.Fecha;

public interface IControladorClase {
	public void addClase(String nombre, Fecha fecha, int hora, String URL, Fecha fechaAlt) throws ClaseRepetidaEx;
}
