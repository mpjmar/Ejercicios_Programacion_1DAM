public class App {

	public static long invert(long num) {
		long invert = 0;

		while (num > 0) {
			invert = invert * 10 + num % 10;
			num /= 10;
		}
		return (invert);
	}

	public static long gusano(long num) {
		long last = 0, invert = 0;
		
		while (num > 0) {
			last = num % 10;
			num = num / 10;
			if (last != 0 && last != 8)
				invert = invert * 10 + last;
		}
		return (invert(invert));
	}

    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		long num = 0;

		do {
			try {
				System.out.print("Introduzca un número mayor que 0: ");
				num = Long.parseLong(System.console().readLine());
				correcto = num > 0;
				if (!correcto) System.out.println("El número debe ser mayor que 0.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		System.out.println(num != gusano(num) ? ("Después de haber sido comido por el gusano numérico se queda en " + gusano(num)) 
												: "El gusano numérico no se ha comido ningún dígito.");
	}
}
