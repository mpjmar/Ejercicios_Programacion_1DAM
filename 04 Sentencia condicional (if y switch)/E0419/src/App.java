public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Por favor, introduzca un número entero (5 cifras como máximo): ");
			int n = Integer.parseInt(System.console().readLine());

			int digits = 0;
			n = Math.abs(n);
			// if (n < 0) n *= -1;
			if (n < 10) digits = 1;
			else if (n < 100) digits = 2;
			else if (n < 1000) digits = 3;
			else if (n < 10000) digits = 4;
			else if (n < 100000) digits = 5;
			else {
				System.out.println("El número introducido tiene más de 5 dígitos");
				return ;
			}
			System.out.printf("El número introducido tiene %d dígitos%n", digits);

		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
