package datatypes;

public class DtFechaHora {
	//formato 24hs
	private int hora;
	private int min;
	private int seg;
	public DtFechaHora(int hora, int min, int seg) {
		super();
		this.hora = hora;
		this.min = min;
		this.seg = seg;
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
		return "hora: " + hora + ":" + min + ":" + seg;
	}

}
