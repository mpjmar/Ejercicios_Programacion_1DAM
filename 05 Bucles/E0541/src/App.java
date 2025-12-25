public class App {
    public static void main(String[] args) throws Exception {
        
		long num = 0;
		int pares = 0, impares = 0;
		boolean correcto = false;

		do {
			try {
				System.out.println("Por favor, introduzca un número entero positivo: ");
				num = Integer.parseInt(System.console().readLine());
				correcto = num > 0;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		long n = num;
		while (n > 0) {
			if (n % 2 == 0) pares++;
			else impares++;
			n /= 10;
		}

		System.out.printf("El %d contiene %d dígitos pares y %d dígitos impares.%n", num, pares, impares);
    }
}
