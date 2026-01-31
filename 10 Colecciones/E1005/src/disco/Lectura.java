package disco;

public class Lectura {
	
	public static String leerString() {

		String entrada = "";
		
		try {
			entrada = System.console().readLine();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		return entrada;
	}

	public static int stringToInt(String entrada) {

		int num = -1;
		
		try {
			num = Integer.parseInt(entrada);
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		return num;
	}

	public static int leerEntero() {

		int entrada = -1;

		try {
			entrada = Integer.parseInt(System.console().readLine());
		} catch (NumberFormatException e) {
			System.out.println("El número debe ser un entero.");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado.");
		}
		return entrada;
	}

	public static int leerEntero(int min, int max) {

		int entrada = -1;
		boolean correcto = false;

		while (!correcto) {
			try {
				entrada = Integer.parseInt(System.console().readLine());
				correcto = entrada >= min && entrada <= max;
				if (!correcto)
					System.out.printf("Opción incorrecta. Introduzca una opción del %d al %d.%n", min, max);
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		}
		return entrada;
	}
}
