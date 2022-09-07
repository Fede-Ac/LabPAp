package datatypes;

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
		return "Fecha: año: " + anio + ", mes: " + mes + ", día: " + dia;
	}
}
