package logica;

import java.util.Date;

public class Registro {
	private Date fechaReg;

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public Registro(Date fechaReg) {
		super();
		this.fechaReg = fechaReg;
	}

}
