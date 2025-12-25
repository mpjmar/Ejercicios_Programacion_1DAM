public class App {
    public static void main(String[] args) throws Exception {
        
		int numero = 0;
		boolean correcto = false;
		do {
			try {
				numero = Integer.parseInt(System.console().readLine("Por favor, introduzca un número entero: "));
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("El núemero debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		int factorial = 1;
		for (int i = 2; i <= numero; i++)
			factorial *= i;
		System.out.printf("%d! = %d%n", numero, factorial);
    }
}
