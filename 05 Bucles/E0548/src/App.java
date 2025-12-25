public class App {

	public static boolean findDigit(long num, int digit) {
		
		boolean found = false;

		while (!found && num > 0) {
			found = (int)num % 10 == digit;
			num /= 10; 
		}
		return found;
	}
	public static void main(String[] args) throws Exception {

		long num = 0;
		boolean found = false;

		try {
			System.out.print("Introduzca un número entero: ");
			num = Long.parseLong(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}

		System.out.print("Dígitos que aparecen en el número: ");
		for (int i = 0; i < 10; i++)
			System.out.print(findDigit(num, i) ? (i + " ") : "");
		System.out.println();

		System.out.print("Dígitos que no aparecen: ");
		for (int i = 0; i < 10; i++)
			System.out.print(!findDigit(num, i) ? (i + " ") : "");
	}
}
