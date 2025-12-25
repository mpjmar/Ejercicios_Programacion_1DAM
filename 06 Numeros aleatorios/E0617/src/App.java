public class App {
    public static void main(String[] args) throws Exception {

		int ancho = 0, alto = 0;
		boolean correcto = false;

		do {
			try {
				System.out.print("Por favor, introduzca la altura de la pecera (como mínimo 4): ");
				alto = Integer.parseInt(System.console().readLine());
				System.out.print("Ahora introduzca la anchura (como mínimo 4): ");
				ancho = Integer.parseInt(System.console().readLine());
				correcto = alto > 3 && ancho > 3;
				if (!correcto) System.out.println("Las dimensiones no son correctas.");
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		int y = (int)(Math.random() * alto - 2) + 2;
		int x = (int)(Math.random() * ancho - 2) + 2;
		System.out.println(y + " " + x);

		for (int i = 1; i <= alto; i++) {
			for (int j = 1; j <= ancho; j++)
				System.out.print((i == 1 || i == alto || j == 1 || j == alto) ? "* " : (i == y && j == x) ? "& " : "  ");
			System.out.println();
		}
	}
}
