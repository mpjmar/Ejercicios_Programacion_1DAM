public class App {
    public static void main(String[] args) throws Exception {
        
		int grande = 0;
		int peque = 0;
		boolean correcto = false;
		do {
			try {
				grande = Integer.parseInt(System.console().readLine("Introduzca un número entero positivo (relativamente grande): "));
				peque = Integer.parseInt(System.console().readLine("Introduzca otro número (relativamente pequeño): "));
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un erro inesperado.");
			}
		} while (!correcto);
		System.out.printf("Los números enteros positivos menores que %d que no son divisibles entre %d son los siguientes: %n", grande, peque);
		for (int i = 1; i < grande; i++)
			if (i % peque != 0)
				System.out.printf("%d ", i);
		System.out.println();
    }
}
