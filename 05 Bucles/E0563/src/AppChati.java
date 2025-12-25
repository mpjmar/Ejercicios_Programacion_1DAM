public class AppChati {
    public static void main(String[] args) {

        boolean correcto = false;
		int h1 = 0, h2 = 0;

		do {
			try {
				System.out.print("Introduzca la altura de la primera pirámide: ");
				h1 = Integer.parseInt(System.console().readLine());
				System.out.print("Introduzca la altura de la segunda pirámide: ");
				h2 = Integer.parseInt(System.console().readLine());
				correcto = h1 > 1 && h2 > 1;
				if (!correcto) System.out.println("La altura debe ser mayor que 1.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);


        int maxAltura = Math.max(h1, h2);

        for (int fila = 1; fila <= maxAltura; fila++) {
            // Primera pirámide
            imprimirFilaPiramide(fila, h1, maxAltura);

            // Espacio entre pirámides
            System.out.print(" ");

            // Segunda pirámide
            imprimirFilaPiramide(fila, h2, maxAltura);

            // Salto de línea
            System.out.println();
        }

    }

    private static void imprimirFilaPiramide(int filaActual, int altura, int alturaMax) {
        int offset = alturaMax - altura; // diferencia para alinear por la base

        if (filaActual <= offset) {
            // Fila por encima de la pirámide
            for (int i = 0; i < (altura * 2 - 1); i++) {
                System.out.print(" ");
            }
        } else {
            int nivel = filaActual - offset; // fila real dentro de la pirámide
            int espacios = altura - nivel;
            int asteriscos = 2 * nivel - 1;

            // Espacios iniciales
            for (int i = 0; i < espacios; i++) {
                System.out.print(" ");
            }

            // Asteriscos
            for (int i = 0; i < asteriscos; i++) {
                System.out.print("*");
            }
        }
    }
}
