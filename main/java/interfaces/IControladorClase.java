package interfaces;

import excepciones.ClaseRepetidaEx;

import java.util.GregorianCalendar;


public interface IControladorClase {
	public void addClase(String nombre, GregorianCalendar fecha, int hora, String URL, GregorianCalendar fechaAlt) throws ClaseRepetidaEx;
}
