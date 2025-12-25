public class App {

	public static int longitud(int n) {
		int  len = 0;
		while (n > 0) {
			n /= 10;
			len++;
		}
		return (len);
	}

	/* public static void partirNum(int num, int len, int pos) {

		int pow = len - pos + 1;

		int n1 = num / (int)Math.pow(10, pow);
		int n2 = num % (int)Math.pow(10, pow);

		System.out.printf("Los números partidos son el %d y el %d%n", n1, n2);
	} */

	public static int invertido(int num) {
		
		int invertido = 1;

		while (num > 0) {
			invertido = invertido * 10 + num % 10;
			num /= 10;
		}
		return (invertido);
	}

	public static void partirNum(int num, int pos) {

		int n1 = 0, n2 = 0;

		while (num > 1) {
			if (pos > 0)
				n1 = n1 * 10 + num % 10;
			else
				n2 = n2 * 10 + num % 10;
			num /= 10;
			pos--;
		}

		System.out.printf("Los números partidos son el %d y el %d%n", n1, n2);
	}

    public static void main(String[] args) throws Exception {
        
		boolean correcto = false;
		int num = 0, pos = 0, longitud = 0;

		do {
			try {
				do {
					System.out.print("Por favor, introduzca un número entero positivo: ");
					num = Integer.parseInt(System.console().readLine());
					longitud = longitud(num);
					correcto = num >= 99;
					if (!correcto) System.out.println("El número debe tener al menos 2 dígitos.");
				} while (!correcto);
				do {
					System.out.print("Por favor, introduzca la posición a partir de la cual quere partir el número: ");
					pos = Integer.parseInt(System.console().readLine());
					correcto = pos < longitud; 
					if (!correcto) System.out.println("La posición debe ser menor que la longitud del número.");
				} while (!correcto);
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		partirNum(invertido(num), pos - 1);
    }
}
