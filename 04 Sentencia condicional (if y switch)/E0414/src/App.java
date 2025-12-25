public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			String div2 = "impar";
			String div5 = "no es ";

			System.out.print("Por favor, introduzca un número entero: ");
			int num = Integer.parseInt(System.console().readLine());

			if (num % 2 == 0)
				div2 = "par";
			if (num % 5 == 0)
				div5 = "";

			System.out.printf("El número introducido es %s y %sdivisible entre 5.%n", div2, div5);
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
