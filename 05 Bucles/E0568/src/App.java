public class App {

	public static long invertido(long num) {
		
		long invertido = 0;
		
		while (num > 0) {
			invertido = invertido * 10 + num % 10;
			num /= 10;
		}
		return (invertido);
	}

	public static long dislocado(long num) {
		
		long dislocado = 0;
		int digito = 0;

		while (num > 0) {
			digito = (int)(num % 10);
			dislocado = dislocado * 10 + (digito % 2 == 0 ? digito + 1 : digito - 1);
			num /= 10;
		}
		return (invertido(dislocado));
	}

    public static void main(String[] args) throws Exception {

		long numero = 0;

		try {
			System.out.print("Por favor, introduzca un número: ");
			numero = Long.parseLong(System.console().readLine());
		}
		catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		long dislocado = dislocado(numero);
		System.out.printf("Dislocando el %d sale el %d%n", numero, dislocado);
	}
}
