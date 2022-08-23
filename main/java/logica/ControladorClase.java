package logica;

import excepciones.ClaseRepetidaEx;
import interfaces.IControladorClase;

public class ControladorClase implements IControladorClase{
	public ControladorClase() {
		super();
	}
	public void addClase(String nombre, Date fecha, Date horaInicio, String url, Date fechaReg) throws ClaseRepetidaEx {
		ManejadorClase mid = ManejadorClase.getInstancia();
		if (!mid.existeClase(nombre)) {
			Clase clase = new Clase(nombre, fecha, horaInicio, url, fechaReg);
			mid.add(clase);
		}else{
			throw new ClaseRepetidaEx("La clase de nombre: " + nombre + " ya existe.");
		}
}
	

}
