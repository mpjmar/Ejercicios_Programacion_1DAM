public class App {

	public static void dibujaPiramide(int altura) {

		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < altura - i - 1; j++)
				System.out.print(" ");
			for (int j = 0; j < 6 + i * 2; j++)
				if (i % 2 == 0)
					System.out.print("*");
				else {
					if (j <= i)
						System.out.print("*");
					else if (j > i && j <= i + 4)
						System.out.print(" ");
					else
						System.out.print("*");
				}
			System.out.println();
		}
	}

    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura = 0;

		do {
			try {
				System.out.print("Introduzca la altura de la pirámide: ");
				altura = Integer.parseInt(System.console().readLine());
				correcto = altura >= 3;
				if (!correcto) System.out.println("La altura debe ser mayor o igual a 3.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		dibujaPiramide(altura);
	}
}
