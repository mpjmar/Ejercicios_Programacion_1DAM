public class Piramide {
	
	private int altura;
	private static int cantP = 0;

	public Piramide(int altura) {
		this.altura = altura;
		cantP++;
	}

	public static int getPiramidesCreadas() {
		return cantP;
	}

	@Override
	public String toString() {
		String triangulo = "";
		for (int i = 1; i <= altura; i++) {
			for (int j = 0; j < altura - i; j++)
				triangulo += " ";
			for (int j = 0; j < i * 2 - 1; j++)
				triangulo += "*";
			triangulo += "\n";
		}
		return triangulo;
	}
}
