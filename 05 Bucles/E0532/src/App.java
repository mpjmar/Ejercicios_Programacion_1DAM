public class App {
    public static void main(String[] args) throws Exception {
        
		long num = 0;
		boolean correcto = false;
		do {
			try {
				num = Integer.parseInt(System.console().readLine("Por favor, introduzca un número entero positivo: "));
				System.out.print(num >= 0 ? "" : "El número debe ser positivo.");
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		long reves = 0;
		int digito = 0;
		int suma = 0;
		while (num > 0) {
			reves = reves * 10 + num % 10;
			num /= 10;
		}
		System.out.print("Digitos pares: ");
		while (reves > 0) {
			digito = (int)(reves % 10);
			if (digito % 2 == 0) {
				System.out.printf("%d ", digito);
				suma += digito;
			}
			reves /= 10;
		}
		System.out.println();
		System.out.printf("Suma de los dígitos pares: %d%n", suma);
    }
}
