public class App {
    public static void main(String[] args) throws Exception {

		int numero = 0, digito = 0, buenaS = 0, malaS = 0;

		try {
			System.out.print("Introduzca un número: ");
			numero = Integer.parseInt(System.console().readLine());
		}
		catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		int num = numero;
		while (num > 0) {
			digito = num % 10;
			switch (digito) {
				case 3, 7, 8, 9 -> buenaS++;
				case 0, 1, 2, 4, 5, 6 -> malaS++;
				default -> System.out.println("eError");
			}
			num /= 10;
		}
		System.out.printf("El número %d%s es un número afortunado.%n", numero, buenaS > malaS ? "" : " no");
	}
}
