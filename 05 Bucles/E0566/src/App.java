public class App {
    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura = 0;

		do {
			try {
				System.out.print("Por favor, introduzca la altura de la figura: ");
				altura = Integer.parseInt(System.console().readLine());
				correcto = altura % 2 != 0 && altura >= 3;
				if (!correcto) System.out.println("La altura no es correcta, debe ser un número impar mayor o igual que 3.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		for (int i = 0; i < altura / 2; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			System.out.print("*    *");
			/* for (int j = 0; j < 6; j++)
				System.out.print(j == 0 || j == 5 ? "*" : " "); */
			System.out.println();
		}

		for (int i = altura / 2; i >= 0; i--) {
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			System.out.print("*    *");
			/* for (int j = 0; j < 6; j++)
				System.out.print(j == 0 || j == 5 ? "*" : " "); */
			System.out.println();
		}
	}
}
