package datatypes;

import java.util.Calendar;

public class DtFecha {
	private int anio;
	private int mes;
	private int dia;
	
	public DtFecha(int anio, int mes, int dia) {
		super();
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
	}
	
	public DtFecha(Calendar cal) {
		this.anio = cal.get(Calendar.YEAR);
		this.mes = cal.get(Calendar.MONTH);
		this.dia = cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getAnio() {
		return anio;
	}
	public int getMes() {
		return mes;
	}
	public int getDia() {
		return dia;
	}
	@Override
	public String toString() {
		return "Fecha: " + anio + "/" + mes + "/" + dia;
	}
}
