public class App {
    public static void main(String[] args) throws Exception {
        
		int altura = 0;
		char caracter = 0;
		boolean correcto = false;

		do {
			try {
				altura = Integer.parseInt(System.console().readLine("Por favor, introduzca la altura de la pirámide: "));
				caracter = System.console().readLine("Introduzca el caracter de relleno: ").charAt(0);
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero");
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("Debe introducir un caracter correcto");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado");
			}
		} while (!correcto);
	
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < altura - i - 1; j++)
				System.out.print(" ");
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print((j == 0 
								|| j == i * 2 
								|| i == altura - 1) ?
								caracter : " ");
			}
			System.out.println();
		}
    }
}
