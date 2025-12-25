public class App {

	public static int factorial(int num) {
		
		int factorial = num;
		for (int i = 1; i < num; i++)
			factorial *= i;
		return (factorial);
	}
    public static void main(String[] args) throws Exception {
        
		int num = 0;
		boolean correcto = false;
		
		do {
			try {
				System.out.print("Por favor, introduzca un número entero positivo: ");
				num = Integer.parseInt(System.console().readLine());
				correcto = num >= 0;
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);
		
		for (int i = 1; i <= num; i++)
			System.out.printf("%d! = %d%n", i, factorial(i));
    }
}
