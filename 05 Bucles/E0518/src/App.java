import java.security.spec.ECFieldF2m;

public class App {
    public static void main(String[] args) throws Exception {
		boolean correcto = false;
		int n1 = 0, n2 = 0;

		do {
			try {
				n1 = Integer.parseInt(System.console().readLine("Introduzca un número entero: "));
				n2 = Integer.parseInt(System.console().readLine("introduzca otro número entero distinto al anterior: "));
				correcto = n1 != n2;
				if (!correcto) 
					System.out.println("Los números intoducidos no son válidos, deben ser distintos.");
			}
			catch (NumberFormatException e) {
				System.out.println("Debe introducir un número entero");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado");
			}
		} while (!correcto);

		if (n1 > n2)
		{
			int tmp = n1;
			n1 = n2;
			n2 = tmp;
		}

		for (int i = n1; i <= n2; i += 7)
			System.out.print(i + " ");
		System.out.println();
    }
}
