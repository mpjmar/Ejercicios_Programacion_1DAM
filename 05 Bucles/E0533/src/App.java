public class App {
    public static void main(String[] args) throws Exception {
        
		int altura = 0;
		boolean correcto = false;

		do {
			try {
				altura = Integer.parseInt(System.console().readLine("Introduzca la altura: "));
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		for (int i = 0; i < altura - 1; i++) {
			for (int j = 0; j <= altura; j++)
				System.out.print((j == 1 || j == altura) ? "* " : "  ");
			System.out.println();
		}
		for (int i = 0; i < altura; i++)
			System.out.print(i < 2 ? "  " : "* ");
		System.out.println();
    }
}
