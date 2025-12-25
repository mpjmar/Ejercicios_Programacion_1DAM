public class AppLibro {

	public static void dibujaPiramide(int espacios, int asteriscos) {

		for (int i = 0; i < espacios; i++)
			System.out.print(" ");
		for (int i = 0; i < asteriscos; i++)
			System.out.print("*");
		for (int i = 0; i < espacios; i++)
			System.out.print(" ");
	}
	public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura1 = 0, altura2 = 0;

		do {
			try {
				System.out.print("Introduzca la altura de la primera pirámide: ");
				altura1 = Integer.parseInt(System.console().readLine());
				System.out.print("Introduzca la altura de la segunda pirámide: ");
				altura2 = Integer.parseInt(System.console().readLine());
				correcto = altura1 > 1 && altura2 > 1;
				if (!correcto) System.out.println("La altura debe ser mayor que 1.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		int alturaMax = Math.max(altura1, altura2);
		int base1 = altura1 * 2 - 1;
		int base2 = altura2 * 2 - 1;
		int espacios1 = altura1 - 1;
		int espacios2 = altura2 - 1;
		int asteriscos1 = 1;
		int asteriscos2 = 1;

		for (int i = alturaMax; i > 0; i--) {
            if (i > altura1) {
				for (int j = 0; j < base1; j++);
					System.out.print(" ");
			}
			else {
				dibujaPiramide(espacios1, asteriscos1);
				espacios1--;
				asteriscos1 += 2;
			}

			System.out.print(" ");

			if (i > altura2) {
				for (int j = 0; j < base2; j++);
					System.out.print(" ");
			}
			else {
				dibujaPiramide(espacios2, asteriscos2);
				espacios2--;
				asteriscos2 += 2;
			}
            System.out.println();
        }
	}
}
