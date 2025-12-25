public class App {
    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura = 0, anchura = 0;

		do {
			try {
				do {
					System.out.print("Por favor, introduzca la anchura del rectángulo (como mínimo 2): ");
					anchura = Integer.parseInt(System.console().readLine());
					System.out.print("Ahora introduzca la altura: ");
					altura = Integer.parseInt(System.console().readLine());
					correcto = anchura > 1 && altura > 1;
					if (!correcto) System.out.println("Lo siento, los datos introducidos no son correctos, el valor mínimo para la anchura y la altura es 2.");
				} while (!correcto);
			}
			catch(NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch(Exception e) {
				System.out.println("Ha ocurrrido un error inesperado.");
			}
		} while (!correcto);

		for (int i = 1; i <= altura; i++) {
			for (int j = 1; j <= anchura; j++)
				System.out.print(i == 1 || i == altura || j == 1 || j == anchura ? "* " : "  ");
			System.out.println();
		}
	}
}
