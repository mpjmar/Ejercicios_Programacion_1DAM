public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Introduzca un número entero positivo (de 5 cifras como máximo): ");
			int n = Integer.parseInt(System.console().readLine());

			int first = 0;
			if (n < 10) first = n;
			else if (n < 100) first = n / 10;
			else if (n < 1000) first = n / 100;
			else if (n < 10000) first = n / 1000;
			else if (n < 100000) first = n / 10000;
			else {
				System.out.println("El número introducido tiene más de 5 cifras.");
				return ;
			}
			System.out.printf("La primera cifra del número introducido es el %d%n", first);

		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
