public class App {
    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura = 0;
		final int ANCHO = 6;

		do {
			try {
				do {
					System.out.print("Introduzca la altura (número impar mayor o igual a 5): ");
					altura = Integer.parseInt(System.console().readLine());
					correcto = altura >= 5 && altura % 2 != 0;
					if (!correcto) System.out.println("La altura introducida no es correcta.");
				} while (!correcto);
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		for (int i = 1; i <= altura; i++) {
			for (int j = 1; j <= ANCHO; j++)
				System.out.print((i == 1 || i == (altura / 2.0) + 1 || i == altura || j == 1 || j == ANCHO) ? "M" : " ");
			System.out.println();
		}
	}
}
