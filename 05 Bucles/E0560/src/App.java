public class App {
    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura = 0;

		do {
			try {
				System.out.print("Introduzca la altura de los calcetines: ");
				altura = Integer.parseInt(System.console().readLine());
				correcto = altura >= 4;
				if (!correcto) System.out.println("La altura debe ser mayor o igual a 4.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		for (int i = 0; i < altura; i++) {
			if (i < altura - 2)
				for (int j = 0; j < 3; j++)
					System.out.print("*");
			else
				for (int j = 0; j < 6; j++)
					System.out.print("*");
			System.out.println();
		}
	}
}
