public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Introduzca un número entero (5 cifras como máximo): ");
			int n = Integer.parseInt(System.console().readLine());

			boolean capicua = false;
			if (n < 10) 
				capicua = true;
			if (!capicua && n < 1000) {
				int first = n / ((n < 100) ? 10 : 100);
				int last = n % 10;
				if (first == last)
					capicua = true;
			}
			if (!capicua && n < 100000) {
				int first = n / ((n < 10000) ? 1000 : 10000);
				int second = ...
				int last = n % 10;
				int penult = ...
			}
			if (n >= 100000) {
				System.out.println("El número tiene más de 5 cifras.");
				return ;
			}

			if (n < 100000)
				System.out.printf("El número introducido %ses capicúa.%n", first == last ? "" : "no ");

		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
