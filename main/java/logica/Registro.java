package logica;

import datatypes.DtFecha;

public class Registro {
	private DtFecha fechaReg;
	//links (ver cuando se haga el CU)
	
	public Registro(DtFecha fechaReg) {
		super();
		this.fechaReg = fechaReg;
	}

	public DtFecha getDtFechaReg() {
		return fechaReg;
	}

	public void setDtFechaReg(DtFecha fechaReg) {
		this.fechaReg = fechaReg;
	}

}
