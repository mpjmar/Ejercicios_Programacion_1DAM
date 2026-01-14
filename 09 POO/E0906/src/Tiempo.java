public class Tiempo {
	
	private int seg;

	public Tiempo() {
		this.seg = 0;
	}

	public Tiempo (int seg) {
		this.seg = seg;
	}

	public Tiempo(int horas, int min, int seg) {
		this.seg = horas * 3600 + min * 60 + seg;
	}

	public int getHoras() {
		return seg / 3600;
	}

	public int getMin() {
		return (seg % 3600) / 60;
	}

	public int getSeg() {
		return seg % 60;
	}

	public Tiempo suma(Tiempo t) {
		return new Tiempo(this.seg + t.getSeg());
	}

	public Tiempo resta(Tiempo t) {
		return new Tiempo(this.seg - t.getSeg());
	}

	@Override
	public String toString() {
		return String.format("%2dh:%2dm:%2ds", getHoras(), getMin(), getSeg());
	}
}
