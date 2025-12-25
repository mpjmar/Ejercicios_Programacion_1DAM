public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("Cálculo del tiempo de caída de un objeto.");
			System.out.print("Introduzca la altura (en metros) desde la que cae un objeto: ");
			int h = Integer.parseInt(System.console().readLine());
			
			if (h < 0)
				System.out.println("La altura no puede ser negativa");
			else
			{
				final double G = 9.81;
				Double t = Math.sqrt(2 * h / G);
				System.out.printf("El objeto tarda %.2f segundos en caer.%n", t);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
