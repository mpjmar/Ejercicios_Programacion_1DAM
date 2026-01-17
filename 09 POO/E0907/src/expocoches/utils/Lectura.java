package expocoches.utils;

public class Lectura {

	public static int leeEntero(String mensaje, int min, int max) {
		int opcion = -1;
		boolean correcto = false;

		do {
			try {
				opcion = Integer.parseInt(System.console().readLine(mensaje));
				correcto = opcion >= min && opcion <= max;
				if (!correcto)
					System.out.println("La opción introducida no es correcta.");
			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
		} while (!correcto);

		return opcion;
	}
}
