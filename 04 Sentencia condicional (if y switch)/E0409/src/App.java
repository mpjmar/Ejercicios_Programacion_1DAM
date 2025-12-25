public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("Este programa resuelve ecuaciones de segundo grado.");
			System.out.println("ax\\^2 + bx + c = 0");
			System.out.println("Por favor, introduzca los valores.");
	
			System.out.print("a = ");
			int a = Integer.parseInt(System.console().readLine());
	
			System.out.print("b = ");
			int b = Integer.parseInt(System.console().readLine());
	
			System.out.print("c = ");
			int c = Integer.parseInt(System.console().readLine());
	
			double discr = b * b - (4 * a * c);
	
			if (a == 0 && b == 0 && c == 0)
				System.out.println("La ecuación tiene infinitas soluciones.");
			else if (a == 0 && b == 0 && c != 0)
				System.out.println("La ecuación no tiene solución.");
			else if (a != 0 && b != 0 && c == 0)
			{
				System.out.println("x1 = 0");
				System.out.println("x2 = " + (-b / a));
			}
			else if (a != 0 && b != 0 && c != 0) {
				if (discr < 0)
					System.out.println("La ecuación no tiene soluciones reales");
				else {
					System.out.println("x1 = " + (-b + Math.sqrt(discr)) / (2 * a));
					System.out.println("x2 = " + (-b - Math.sqrt(discr)) / (2 * a));
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
