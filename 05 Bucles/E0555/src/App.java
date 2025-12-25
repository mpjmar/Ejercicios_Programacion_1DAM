public class App {

	public static int longitud(long num) {
		int len = 0;
		while (num > 0) {
			num /= 10;
			len++;
		}
		return (len);
	}
    public static void main(String[] args) throws Exception {

		long num = 0, desplazado = 0;

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

		desplazado = num % 10;
		num /= 10;
		desplazado *= (long)(Math.pow(10, longitud(num)));
		desplazado += num;
		System.out.println("El número resultado es " + desplazado);
	}
}
