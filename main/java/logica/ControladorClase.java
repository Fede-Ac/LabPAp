package logica;

import java.util.GregorianCalendar;

import excepciones.ClaseRepetidaEx;
import interfaces.IControladorClase;

public class ControladorClase implements IControladorClase{
	public ControladorClase() {
		super();
	}
	public void addClase(String nombre, GregorianCalendar fecha, int hora, String URL, GregorianCalendar fechaAlt) throws ClaseRepetidaEx {
		ManejadorClase mid = ManejadorClase.getInstancia();
		if (!mid.existeClase(nombre)) {
			Clase clase = new Clase(nombre, fecha, hora, URL, fechaAlt);
			mid.add(clase);
		}else{
			throw new ClaseRepetidaEx("La clase de nombre: " + nombre + " ya existe.");
		}
}
	

}