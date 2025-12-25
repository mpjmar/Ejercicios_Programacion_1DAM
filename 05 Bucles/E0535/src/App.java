public class App {
    public static void main(String[] args) throws Exception {
        
		int altura = 0;
		boolean correcto = false;

		do {
			try {
				altura = Integer.parseInt(System.console().readLine("Por favor, introduce la altura de la X: "));
				correcto = (altura >= 3) && (altura % 2 != 0);
				System.out.println(!correcto ? "Datos incorrectos. Debe introducir una altura impar mayor o igual a 3" : "");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < altura; j++)
				System.out.print(((j == i) || (j == altura - i - 1)) ? "*" : " ");
			System.out.println();
		}
    }
}
