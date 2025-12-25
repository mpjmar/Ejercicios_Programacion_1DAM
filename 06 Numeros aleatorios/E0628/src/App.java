public class App {
    public static void main(String[] args) throws Exception {

		int altura = 0;
		final int ANCHO = 6;

		do {
			altura = (int)(Math.random() * (14 - 3) + 3);
		} while (altura % 2 == 0);

		for (int i = 1; i <= altura; i++) {
			for (int j = 1; j <= ANCHO + 1; j++)
				System.out.print((j == 1 || j == ANCHO || i == Math.ceil(altura / 2.00) && j <= ANCHO) ? "*" : " ");
			for (int j = 1; j <= ANCHO + 1; j++)
				if (i == 1 || i == altura)
					System.out.print(j > 1 && j < ANCHO ? "*" : " ");
				else
					System.out.print(j == 1 || j == ANCHO ? "*" : " ");
			for (int j = 1; j <= ANCHO + 1; j++)
				System.out.print(j == 1 || i == altura && j <= ANCHO ? "*" : " ");
			for (int j = 1; j <= ANCHO; j++)
				if (i == 1)
					System.out.print(j == 1 || j == ANCHO ? " " : "*");
				else
					System.out.print((j == 1 || j == ANCHO || i == Math.ceil(altura / 2.00)) ? "*" : " ");
			
			System.out.println();
		}
	}
}
