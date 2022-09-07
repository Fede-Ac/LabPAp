package logica;

import excepciones.FechaInvalidaEx;

public class Fecha {
	final int MAXANIO = 2030;
	final int MINANIO = 1950;
	final int MINMES = 1;
	final int MAXMES = 12;
	final int MINDIA = 1;
	final int MAXDIA = 31;
	private int anio;
	private int mes;
	private int dia;
	
	public Fecha(int anio, int mes, int dia) throws FechaInvalidaEx {
		super();
		if (anio > MINANIO && anio <MAXANIO) {
			throw new FechaInvalidaEx("El año ingresado es inválido. Rango permitido: " + MINANIO +"-" +MAXANIO);
		}else if (mes > MINMES && mes < MAXMES) {
			throw new FechaInvalidaEx("El mes ingresado es inválido. Rango permitido: " + MINMES +"-" +MAXMES);
		}else if (dia > MINDIA && dia < MAXDIA) {
			throw new FechaInvalidaEx("El dia ingresado es inválido. Rango permitido: " + MINDIA +"-" +MAXDIA);
		}
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
	}
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) throws FechaInvalidaEx {
		if (anio > MINANIO && anio <MAXANIO) {
			throw new FechaInvalidaEx("El año ingresado es invalido. Rango permitido: " + MINANIO +"-" +MAXANIO);
		}
		this.anio = anio;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) throws FechaInvalidaEx {
		if (mes > MINMES && mes < MAXMES) {
			throw new FechaInvalidaEx("El mes ingresado es invalido. Rango permitido: " + MINMES +"-" +MAXMES);
		}
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) throws FechaInvalidaEx {
		if (dia > MINDIA && dia < MAXDIA) {
			throw new FechaInvalidaEx("El dia ingresado es invalido. Rango permitido: " + MINDIA +"-" +MAXDIA);
		}
		this.dia = dia;
	}

	
	
	
}
