public class Movil extends Terminal {
	
	private final String[] TARIFA = {"rata", "mono", "bisonte"};
	private final double[] COSTE = {0.06, 0.12, 0.30};
	private String tarifa;
	private double euros;

	public Movil(String num, String tarifa) {
		super(num);
		this.tarifa = tarifa;
		this.euros = 0;
	}

	public String getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public double getTarificados() {
		return euros;
	}

	public void setTarificados(double euros) {
		this.euros = euros;
	}

	@Override
	public String toString() {
		return String.format(super.toString() + " - tarificados %.2f euros (tarifa %s)", euros, this.tarifa);
	}

	public void llama(Terminal t, int seg) {
		double min = seg / 60.0;
		super.llama(t, seg);
		for (int i = 0; i < TARIFA.length; i++)
			if (this.tarifa.equals(TARIFA[i]))
				this.euros += min * COSTE[i];
	}
}
