public class App {
    public static void main(String[] args) throws Exception {

		boolean correcto = true;
		int altura = 0, espacios = 0;

		do {
			try {
				do {
					System.out.print("Introduzca la altura (5 como mínimo): ");
					altura = Integer.parseInt(System.console().readLine());
					correcto = altura > 4;
					if (!correcto) System.out.println("La altura debe ser como mínimo 5.");
				} while (!correcto);

				do {
					System.out.print("Introduzca el número de espacios entre los números (1 como mínimo): ");
					espacios = Integer.parseInt(System.console().readLine());
					correcto = espacios > 0;
					if (!correcto) System.out.println("Los espacios deben ser 1 como mínimo.");
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
			for (int j = 1; j <= 9 + espacios * 2; j ++) {
				if (i == 1 || i == 3 || i == altura)
					System.out.print((j == 1 || j == altura ||
									(j >= 2 + espacios && j <= 5 + espacios) || 
									j >= 6 + espacios * 2 && j <= 9 + espacios * 2) ? "*" : " ");
				else if (i == 2)
					System.out.print((j == 1 || j == 2 + espacios || j == 6 + espacios * 2) ? "*" : " ");
				else
					System.out.print((j == 1 || j == 5 + espacios || j == 9 + espacios * 2) ? "*" : " ");
			}
			System.out.println();
		}
	}
}
