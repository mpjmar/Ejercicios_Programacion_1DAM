public class App {
    public static void main(String[] args) throws Exception {

		long num = 0;
		int suma = 0, digitos = 0;

		try {
			System.out.print("Introduzca un número: ");
			num = Long.parseLong(System.console().readLine());
		}
		catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		}
		catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}

		while (num > 0) {
			suma += num % 10;
			num /= 10;
			digitos++;
		}
		System.out.println("La media de sus dígitos es " + suma / (double)digitos);
	}
}
