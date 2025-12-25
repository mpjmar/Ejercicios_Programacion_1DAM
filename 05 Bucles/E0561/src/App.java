public class App {
    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura = 0;

		do {
			try {
				System.out.print("Introduzca la altura de la V (un número mayopr o igual a 3): ");
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

		for (int i = 0; i < altura - 1; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			for (int j = 0; j < 3; j++)
				System.out.print("*");
			for (int j = 0; j < altura * 2 - 1 - i * 2; j ++)
				System.out.print(" ");
			for (int j = 0; j < 3; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int j = 0; j < 6 + altura; j++)
			System.out.print(j < altura - 1 ? " " : "*");
		System.out.println();
	}
}
