package logica;

import java.util.Calendar;

import datatypes.DtFechaHora;
import excepciones.FechaInvalidaEx;
import excepciones.HoraInvalidaEx;

public class FechaHora extends Fecha{
	//formato 24hs
	final int MAXHORA = 23;
	final int MINHORA = 0;
	final int MINMIN = 0;
	final int MAXMIN = 59;
	final int MINSEG = 0;
	final int MAXSEG = 59;
	private int hora;
	private int min;
	private int seg;

	public FechaHora(int anio, int mes, int dia, int hora, int min, int seg) throws HoraInvalidaEx, FechaInvalidaEx {
		super(anio, mes, dia);
		if (hora >= MAXHORA && hora <=MINHORA) {
			throw new HoraInvalidaEx("La hora ingresada es inválida. Rango permitido: " + MINHORA +"-" +MAXHORA);
		}else if (min >= MINMIN && min <= MAXMIN) {
			throw new HoraInvalidaEx("Los minutos ingresados son inválidos. Rango permitido: " + MINMIN +"-" +MAXMIN);
		}else if (seg >= MINSEG && seg <= MAXSEG) {
			throw new HoraInvalidaEx("Los segundos ingresados son inválidos. Rango permitido: " + MINSEG +"-" +MAXSEG);
		}
		this.hora = hora;
		this.min = min;
		this.seg = seg;
	}
	
	public FechaHora(Calendar cal) {
		super(cal);
		this.hora = cal.get(Calendar.HOUR);
		this.min = cal.get(Calendar.MINUTE);
		this.seg = cal.get(Calendar.SECOND);
	}

	public FechaHora(DtFechaHora fechaHora) throws FechaInvalidaEx {
		super(fechaHora.getAnio(),fechaHora.getMes(),fechaHora.getDia());
		this.hora = fechaHora.getHora();
		this.min = fechaHora.getMin();
		this.seg = fechaHora.getSeg();
	}
	
	public int getHora() {
		return hora;
	}

	public void setHora(int hora) throws HoraInvalidaEx {
		if (hora >= MAXHORA && hora <=MINHORA) {
			throw new HoraInvalidaEx("La hora ingresada es inválida. Rango permitido: " + MINHORA +"-" +MAXHORA);
		}
		this.hora = hora;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) throws HoraInvalidaEx {
		if (min >= MINMIN && min <= MAXMIN) {
			throw new HoraInvalidaEx("Los minutos ingresados son inválidos. Rango permitido: " + MINMIN +"-" +MAXMIN);
		}
		this.min = min;
	}

	public int getSeg() {
		return seg;
	}

	public void setSeg(int seg) throws HoraInvalidaEx {
		if (seg >= MINSEG && seg <= MAXSEG) {
			throw new HoraInvalidaEx("Los segundos ingresados son inválidos. Rango permitido: " + MINSEG +"-" +MAXSEG);
		}
		this.seg = seg;
	}
	
	public DtFechaHora getDtFechaHora() {
		return new DtFechaHora(this.getAnio(),this.getMes(),this.getDia(),this.hora,this.min,this.seg);
	}
	
}
