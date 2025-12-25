public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Por favor, introduzca el número de Kb: ");
			double kb = Double.parseDouble(System.console().readLine());
			System.out.printf("%.1fKB son %.1fMb%n", kb, kb / 1024);
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid imput");
		}
		catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
