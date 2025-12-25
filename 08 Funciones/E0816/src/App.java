import matematicas.Varias;

public class App {
	public static void main (String[] args) {

		int col = 0;
		for (int i = 1; i <= 9999; i++) {
			if (Varias.esCapicua(i)) {
				System.out.print(i + "  ");
				col++;
			}
			if (col == 14) {
				System.out.println();
				col = 0;
			}
		}
		System.out.println();
	}
}