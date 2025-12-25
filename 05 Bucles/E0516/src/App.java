public class App {
    public static void main(String[] args) throws Exception {
        
		int n = -1;
		boolean correcto = false;
		boolean esPrimo = true;

		do {
			try {
				n = Integer.parseInt(System.console().readLine("Introduzca un número entero y le diré si es primo: "));
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado");
			}
		} while (!correcto);

		if (n < 2 || (n > 2 && n % 2 == 0))
			esPrimo = false;

		int i = 3;
		while (esPrimo && i < n / 2) {
			if (n % i == 0)
				esPrimo = false;
			i += 2;
		}
		System.out.printf("El número introducido%s es primo.%n", esPrimo ? "" : " no");
    }
}
