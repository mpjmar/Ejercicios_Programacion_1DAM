public class AppAdrian {

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
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		int alturaMax = Math.max(altura1, altura2);

		for (int i = 0; i < alturaMax; i++) {
			int nivel1 = i - (alturaMax - altura1);
			int nivel2 = i - (alturaMax - altura2);

			if (nivel1 >= 0) {
				for (int j = 0; j < altura1 + nivel1; j++)
					System.out.print(j < altura1 - nivel1 - 1 ? " " : "*");
			} else {
				for (int j = 0; j < altura1 * 2 - 1; j++)
					System.out.print(" ");
			}
			System.out.print(" ");

			if (nivel2 >= 0) {
				for (int j = 0; j < altura2 + nivel2; j++)
					System.out.print(j < altura2 - nivel2 - 1 ? (i >= alturaMax - altura1) ? "  " : " " : "*");
			}
			System.out.println();
		}
	}
}
