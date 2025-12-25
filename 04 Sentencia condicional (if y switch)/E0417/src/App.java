public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Por favor, introduzca un número entero: ");
			int n = Integer.parseInt(System.console().readLine());

			int last = n % 10;
			System.out.printf("La última cifra del número introducido es el %d%n", last);
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
