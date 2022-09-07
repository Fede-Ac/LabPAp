package datatypes;

import java.util.Calendar;

public class DtFechaHora extends DtFecha{
	//formato 24hs
	private int hora;
	private int min;
	private int seg;
	public DtFechaHora(int anio, int mes, int dia, int hora, int min, int seg) {
		super(anio, mes, dia);
		this.hora = hora;
		this.min = min;
		this.seg = seg;
	}
	public DtFechaHora(Calendar cal) {
		super(cal);
		this.hora = cal.get(Calendar.HOUR);
		this.min = cal.get(Calendar.MINUTE);
		this.seg = cal.get(Calendar.SECOND);
	}
	public int getHora() {
		return hora;
	}
	public int getMin() {
		return min;
	}
	public int getSeg() {
		return seg;
	}
	@Override
	public String toString() {
		return "Fecha: " + getAnio() + "/" + getMes() + "/" + getDia() + " hora: " + hora + ":" + min + ":" + seg;
	}

}
