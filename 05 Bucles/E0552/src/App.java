public class App {

	public static int longitud(long num) {
		int len = 0;

		while (num > 0) {
			len++;
			num /= 10;
		}
		return (len);
	}

	public static long desplazar(long num) {
		long desplazado = 0, invertido = 0;

		num = num * 10 + 1;
		while (num > 9) {
			invertido = invertido * 10 + num % 10;
			num /= 10;
		}
		while (invertido > 1) {
			desplazado = desplazado * 10 + invertido % 10;
			invertido /= 10;
		}
		return (desplazado * 10 + num);
	}

    public static void main(String[] args) throws Exception {

		long num = 0, digit = 0;
		int len = 0;


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

		/* len = longitud(num);
		digit = num / (long)Math.pow(10, len - 1);
		num %= (long)Math.pow(10, len - 1);
		num *= 10;
		digit += num;

		System.out.println("El número resultado es " + digit); */

		System.out.println("El número resultado es " + desplazar(num));
	}
}
