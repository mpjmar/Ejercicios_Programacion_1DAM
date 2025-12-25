public class App {
    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura = 0;

		do {
			try {
				System.out.print("Por favor, introduce la altura del árbol: ");
				altura = Integer.parseInt(System.console().readLine());
				correcto = altura >= 4;
				if (!correcto) System.out.println("Lo siento, la altura debe ser mayor o igual a 4");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);


		int altArbol = altura - 2;

		for (int j = 0; j < altura - 2; j++)
			System.out.print(j < altura - 3 ? " " : "*");
		System.out.println();

		for (int i = 0; i < altArbol; i++) {
			int j = 0;
			while (j < altArbol + i) {
				System.out.print((j == altArbol - i - 1 || j == altArbol + i - 1 || i == altArbol - 1) ? "^" : " ");
				j++;
			}
			System.out.println();
		}

		for (int j = 0; j < altura - 2; j++)
			System.out.print(j < altura - 3 ? " " : "Y");
		System.out.println();
		
	}
}
