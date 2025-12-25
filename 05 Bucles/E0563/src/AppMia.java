public class AppMia {

	public static void dibujaFilaPiramide(int altura, int alturaMax, int fila) {

		int diferencia = alturaMax - altura;
		int filaReal = fila - diferencia;
		int base = altura * 2 - 1;

		if (diferencia > fila) {
			for (int i = 0; i < base; i++) 
				System.out.print(" ");
		}
		else {
			for (int i = 0; i < base; i++)
				System.out.print((i < altura - 1 - filaReal || i >= altura + filaReal) ? " " : "*");
		}
	}

	public static void dibujaEspacios(int espacios) {
			
		for (int i = 0; i < espacios; i++)
			System.out.print(" ");
	}

	public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura1 = 0, altura2 = 0, espacios = 0;

		do {
			try {
				System.out.print("Introduzca la altura de la primera pirámide: ");
				altura1 = Integer.parseInt(System.console().readLine());

				System.out.print("Introduzca la altura de la segunda pirámide: ");
				altura2 = Integer.parseInt(System.console().readLine());

				correcto = altura1 > 1 && altura2 > 1;
				if (!correcto) System.out.println("La altura debe ser mayor que 1.");

				System.out.print("Introduce el número de espacios que quieres entre ambas: ");
				espacios = Integer.parseInt(System.console().readLine());

			} catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		int alturaMax = Math.max(altura1, altura2);

		for (int i = 0; i < alturaMax; i++) {
			dibujaFilaPiramide(altura1, alturaMax, i);
			dibujaEspacios(espacios);
			dibujaFilaPiramide(altura2, alturaMax, i);
			System.out.println();
		}
	}
}
