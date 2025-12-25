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
		}while (!correcto);

		for (int i = 0; i < altura; i++) {
			if (i < altura - 1)
				System.out.println("*");
			else
				for (int j = 0; j < altura / 2 + 1; j++)
					System.out.print("* ");
		}
		System.out.println();
    }
}
