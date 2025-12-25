public class AppClaude {

	 // Dibuja una fila de la pirámide con espacios antes y después
	 public static void dibujaFila(int fila, int altura) {
        // Espacios antes
        for (int j = 0; j < altura - fila; j++)
            System.out.print(" ");
        // Asteriscos
        for (int j = 0; j < fila * 2 - 1; j++)
            System.out.print("*");
        // Espacios después para completar el ancho
        for (int j = 0; j < altura - fila; j++)
            System.out.print(" ");
    }

    // Dibuja espacios cuando la pirámide no tiene contenido en esa fila
    public static void dibujaEspacios(int cantidad) {
        for (int j = 0; j < cantidad; j++)
            System.out.print(" ");
    }

    // Dibuja una pirámide completa alineada por la base
    public static void dibujaPiramide(int filaActual, int alturaMax, int alturaPiramide) {
        int base = alturaPiramide * 2 - 1;
        
        if (filaActual <= alturaMax - alturaPiramide) {
            // La pirámide no ha empezado, dibuja espacios
            dibujaEspacios(base);
        } else {
            // Dibuja la fila correspondiente de la pirámide
            int fila = filaActual - (alturaMax - alturaPiramide);
            dibujaFila(fila, alturaPiramide);
        }
    }
	
    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int altura1 = 0, altura2 = 0;

		do {
			try {
				System.out.print("Introduzca la altura de la primera pirámide: ");
				altura1 = Integer.parseInt(System.console().readLine());
				System.out.print("Introduzca la altura de la segunda pirámide: ");
				altura2 = Integer.parseInt(System.console().readLine());
				correcto = altura1 > 1 && altura2 > 1;
				if (!correcto) System.out.println("La altura debe ser mayor que 1.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		int alturaMax = Math.max(altura1, altura2);

		for (int i = 1; i <= alturaMax; i++) {
            dibujaPiramide(i, alturaMax, altura1);
            System.out.print(" ");
            dibujaPiramide(i, alturaMax, altura2);
            System.out.println();
        }
	}
}
