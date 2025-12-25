import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

		System.out.print("Por favor, introduzca el primer número: ");
		double x = s.nextDouble();
		System.out.print("Introduzca el segundo número: ");
		double y = s.nextDouble();

		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("x + y = " + (x + y));
		System.out.println("x - y = " + (x - y));
		System.out.println("x / y = " + (x / y));
		System.out.println("x * y = " + (x * y));
    }
}
