import java.security.spec.ECFieldF2m;

public class App {
    public static void main(String[] args) throws Exception {
		
		int altura = 0;
		boolean correcto = false;

		do {
			try {
				System.out.print("Por favor, introduzca la altura del rombo: ");
				altura = Integer.parseInt(System.console().readLine());
				correcto = altura >= 3 && altura % 2 != 0;
				if (!correcto) 
					System.out.println("Datos incorrectos. Debe introducir una altura impar mayor o igual a 3.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		System.out.println();

		for (int i = 0; i < altura / 2 + 1; i++) {
			for (int j = 0; j < altura / 2 - i; j++)
				System.out.print(" ");
			for (int j = 0; j < altura; j++)
			{
				if (j == 0 || j == i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		for (int i = 0; i < altura / 2; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print(" ");
			for (int j = 0; j <= altura / 2 - i - 1; j++) {
				if (j == 0 || j == altura / 2 - i - 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
