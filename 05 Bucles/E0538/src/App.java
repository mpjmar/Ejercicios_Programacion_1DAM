public class App {

    public static void main(String[] args) throws Exception {

		int altura = 0;
		boolean correcto = false;

		do {
			try {
				System.out.print("Por favor, introduzca la altura del reloj de arena: ");
				altura = Integer.parseInt(System.console().readLine());
				correcto = altura >= 3 && altura % 2 != 0;
				if (!correcto) System.out.println("Datos incorrectos. Debe introducir una altura mayor o igual a 3.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} 
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		/* for (int i = 0; i < altura / 2; i++) {
			for (int j = 0; j < altura - i; j++)
				System.out.print((j < i ? " " : "*"));
			System.out.println();
		}

		for (int i = 1; i <= altura / 2 + 1; i++) {
			for (int j = 0; j < altura / 2 - i + 1; j++)
				System.out.print(" ");
			for (int j = 0; j < i * 2 - 1; j++)
				System.out.print("*");
			System.out.println();
		}  */

		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < altura; j++)
				System.out.print(((j == i) || (j == altura - i - 1)) ? "*" : " ");
			System.out.println();
		}
	}
}
