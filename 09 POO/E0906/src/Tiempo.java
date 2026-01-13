public class Tiempo {
	
	private int seg;

	public Tiempo(int horas, int min, int seg) {
		this.seg = horas * 3600 + min * 60 + seg;
	}

	public Tiempo (int seg) {
		this.seg = seg;
	}

	public int getSeg(Tiempo t) {
		return this.seg;
	}

	public Tiempo suma(Tiempo t) {
		return new Tiempo(this.seg + t.getSeg(t));
	}

	public Tiempo resta(Tiempo t) {
		return new Tiempo(this.seg - t.getSeg(t));
	}

	@Override
	public String toString() {
		int horas = this.seg / 3600;
		int min = (this.seg - horas * 3600) / 60;
		return String.format("%2dh:%2dm:%2ds", horas, min, seg % 60);
	}
}
