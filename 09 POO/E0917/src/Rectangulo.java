public class Rectangulo {
	
	private int base;
	private int altura;
	private static int cantR = 0;

	public Rectangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
		cantR++;
	}

	public static int getRectangulosCreados() {
		return cantR;
	}

	@Override
	public String toString() {
		String rectangulo = "";
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < base; j++)
				rectangulo += "*";
			rectangulo += "\n";
		}
		return rectangulo;
	}
}
