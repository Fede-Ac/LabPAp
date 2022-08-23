package interfaces;

import excepciones.ClaseRepetidaEx;

public interface IControladorClase {
	public void addClase(String nombre, Date fecha, Date horaInicio, String url, Date fechaReg) throws ClaseRepetidaEx;
}
