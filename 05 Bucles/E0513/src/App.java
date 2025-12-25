public class App {
    public static void main(String[] args) throws Exception {
        
		int positivos = 0;
		int negativos = 0;

		System.out.println("Por favor, introduzca 10 números enteros: ");
		for (int i = 0; i < 10; i++)
		{
			try {
				int n = Integer.parseInt(System.console().readLine());
				int foo = n < 0 ? positivos++ : negativos++;
			}
			catch (NumberFormatException e) {
				System.out.println("Por favor, introduce un número entero");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado");
			}
		}
		System.out.printf("Ha introducido %d positivos y %d negativos%n", positivos, negativos);
    }
}
