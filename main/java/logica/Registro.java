package logica;

import java.util.Calendar;

import datatypes.DtFecha;

public class Registro {
	private DtFecha fechaReg;
	//links (ver cuando se haga el CU)
	private Clase clase;
	private Socio socio;
	
	public Registro(Clase clase, Socio socio) {
		super();
		this.clase = clase;
		this.socio = socio;
		this.clase.agregarRegistro(this);
		this.socio.agregarRegistro(this);
		Calendar c = Calendar.getInstance();
		fechaReg = new DtFecha(c);
	}

	public DtFecha getDtFechaReg() {
		return fechaReg;
	}

	public Clase getClase() {
		return clase;
	}

	public Socio getSocio() {
		return socio;
	}

}
