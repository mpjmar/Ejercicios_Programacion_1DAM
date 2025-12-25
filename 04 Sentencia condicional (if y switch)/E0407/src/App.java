public class App {
    public static void main(String[] args) throws Exception {

		try {
			System.out.println("Este programa calcula la media de tres notas.");
			System.out.print("Por favor, introduzca la primera nota: ");
			double nota1 = Double.parseDouble(System.console().readLine());
			System.out.print("Ahora introduzca la segunda nota: ");
			double nota2 = Double.parseDouble(System.console().readLine());
			System.out.print("Por último, introduzca la tercera nota: ");
			double nota3 = Double.parseDouble(System.console().readLine());
			System.out.printf("La media es %.2f%n", (nota1 + nota2 + nota3) / 3);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
