public class App {

	public static int longitud(long num) {
		
		int longitud = 0;

		while (num > 0) {
			num /= 10;
			longitud++;
		}
		return (longitud);
	}

	public static long invertido(long num) {
		
		long invertido = 0;
		
		while (num > 0) {
			invertido = invertido * 10 + num % 10;
			num /= 10;
		}
		return (invertido);
	}

	public static long cambiaDigito(long num, int pos, int dig) {

		long aux = 0, nuevoNum = 0;
		long invertido = invertido(num);

		for (int i = 0; i < pos; i++) {
			aux = aux * 10 + invertido % 10;
			invertido /= 10;
		}
		invertido = invertido * 10 + dig;
		aux /= 10;

		for (int i = 0; i < pos; i++) {
			invertido = invertido * 10 + aux % 10;
			aux /= 10;
		}
		nuevoNum = invertido(invertido);
		return (nuevoNum);
	}

    public static void main(String[] args) throws Exception {
        
		boolean correcto = false;
		long num = 0;
		int pos = 0, digito = 0, len = 0;

		do {
			try {
				do {
					System.out.print("Por favor, introduzca un número entero positivo: ");
					num = Integer.parseInt(System.console().readLine());
					correcto = num > 0;
					if (!correcto) System.out.println("El número debe ser un entero positivo.");
				} while (!correcto);
				do {
					System.out.print("Introduzca la posición dentro del número: ");
					pos  = Integer.parseInt(System.console().readLine());
					len = longitud(num);
					correcto = pos > 0 && pos < len;
					if (!correcto) System.out.println("La posición debe ser un número entre 1 y la longitud del número.");
				} while (!correcto);
				do {
					System.out.print("Introduzca el nuevo dígito: ");
					digito = Integer.parseInt(System.console().readLine());
					correcto = digito > 0 && digito < 10;
					if (!correcto) System.out.println("El dígito debe estar comprendido entre 1 y 9.");
				} while (!correcto);
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		long nuevoNum = cambiaDigito(num, pos, digito);
		System.out.println("El número resultante es " + nuevoNum);
    }
}
