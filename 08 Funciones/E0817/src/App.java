import matematicas.Varias;

public class App {

	public static boolean esBinario(long bin) {
		for (int i = 0; i < Varias.digitos(bin); i++)
			if (Varias.digitoN(bin, i) != 0 && Varias.digitoN(bin, i) != 1)
				return false;
		return true;
	}

	public static int convierteADecimal(int bin) {
		return convierteADecimal((long) bin);
	}

	public static int convierteADecimal(long bin) { // REVISAR!!!
		int decimal = 0;
		int digitos = Varias.digitos(bin);
		for (int i = 0; i < digitos; i++) {
			int digito = Varias.digitoN(bin, digitos - 1 - i);
			if (digito == 1)
				decimal += (int) Varias.potencia(2, i);
		}
		return decimal;
	}

	public static void main (String[] args) {
		boolean esBinario = false;
		long num = 0;
		do {
			try {
				System.out.print("Introduzca un número binario: ");
				num = Long.parseLong(System.console().readLine());
				esBinario = esBinario(num);
				if (!esBinario) System.out.println("El número introducido no es binario.");
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!esBinario);
		System.out.printf("%d en binario es %d en decimal.%n", num, convierteADecimal(num));
	}
}