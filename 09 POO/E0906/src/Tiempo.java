public class Tiempo {
	
	private int seg;

	public Tiempo(int horas, int min, int seg) {
		this.seg = horas * 3600 + min * 60 + seg;
	}

	public int getSeg(Tiempo t) {
		return this.seg;
	}

	public int suma(Tiempo t) {
		return this.seg + t.getSeg(t);
	}

	public int resta(Tiempo t) {
		return this.seg - t.getSeg(t);
	}

	@Override
	public String toString() {
		int horas = this.seg / 3600;
		int min = (this.seg - horas * 3600) / 60;
		return String.format("%2dh:%2dm:%2ds", horas, min, seg % 60);
	}
}
