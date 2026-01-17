public class Ameba {

	private int peso;

	public Ameba() {
		this.peso = 3;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void come(int peso) {
		this.peso += peso - 1;
	}

	public void come(Ameba a) {
		this.peso += a.getPeso() - 1;
		a.setPeso(0);
	}

	@Override
	public String toString() {
		return String.format("Soy una ameba y peso %d microgramos", peso);
	}
}
