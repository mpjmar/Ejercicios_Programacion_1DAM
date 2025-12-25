public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("Este programa resuelve ecuaciones de primer grado del tipo ax + b = 0");
			System.out.print("Por favor, introduzca el valor de a: ");
			int a = Integer.parseInt(System.console().readLine());
			System.out.print("Ahora introduzca el valor de b: ");
			int b = Integer.parseInt(System.console().readLine());
	
			double x = -b / (float)a;
			if (a != 0)
				System.out.printf("x - %.2f", x);
			else 
				System.out.println("Esa ecuación no tiene solución real.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}