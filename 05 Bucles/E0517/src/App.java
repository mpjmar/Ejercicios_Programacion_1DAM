public class App {
    public static void main(String[] args) throws Exception {
        
		int n = 0;
		boolean correcto = false;

		do {
			try {
				n = Integer.parseInt(System.console().readLine("Introduzca un número entero positivo: "));
				correcto = n > 0;
				if (!correcto){
					System.out.printf("""
							El número intoducido no es correcto.
							Debe introducir un número positivo.
							""");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Debe introducir un número entero");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado");
			}
		} while (!correcto);

		int suma = 0;
		for (int i = 0; i < 100; i++)
			suma += n + i;
		System.out.printf("La suma de los 100 números siguientes a %d es %d%n", n, suma);
    }
}
