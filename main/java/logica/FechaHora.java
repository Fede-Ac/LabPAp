package logica;

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
	
	
}
