public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.print("Por favor, introduzca el número de Mb: ");
			double mb = Double.parseDouble(System.console().readLine());
			System.out.printf("%.1fMb son %.1fKb%n", mb, mb * 1024);
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid imput");
		}
		catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
