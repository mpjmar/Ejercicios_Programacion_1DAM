public class Tiempo {
	
	private int horas;
	private int min;
	private int seg;

	public Tiempo(int horas, int min, int seg) {
		this.horas = horas;
		this.min = min;
		this.seg = seg;
	}

	public int getHoras() {
		return this.horas;
	}

	public int getMin() {
		return this.min;
	}

	public int getSeg() {
		return this.seg;
	}

	public Tiempo suma(Tiempo t) {
		Tiempo res = new Tiempo(this.horas, this.min, this.seg);
		res.horas += t.getHoras();
		res.min += t.getMin();
		res.seg += t.getSeg();

		if (res.seg >= 60) {
			res.min++;
			res.seg -= 60;
		}
		if (res.min >= 60) {
			res.horas++;
			res.min -= 60;
		}
		return res;
	}

	public Tiempo resta(Tiempo t) {
		Tiempo res = new Tiempo(this.horas, this.min, this.seg);
		res.horas -= t.getHoras();
		res.min -= t.getMin();
		res.seg -= t.getSeg();
		return res;
	}

	public String toString() {
		return this.horas + "h " + this.min + "m " + this.seg + "s";
	}
}
