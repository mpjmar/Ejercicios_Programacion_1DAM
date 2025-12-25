public class App {
    public static void main(String[] args) throws Exception {
        
		try {
			System.out.println("Este programa ordena tres números introducidos por teclado.");
			System.out.println("Por favor, vaya introduciendo los tres números y pulsando INTRO: ");
			int a = Integer.parseInt(System.console().readLine());
			int b = Integer.parseInt(System.console().readLine());
			int c = Integer.parseInt(System.console().readLine());

			if (a <= b && a <= c && b <= c)
				System.out.printf("Los números introducidos ordenados de menor a mayor son %d, %d y %d%n", a, b, c);
			else if (a <= b && a <= c && c <= b)
				System.out.printf("Los números introducidos ordenados de menor a mayor son %d, %d y %d%n", a, c, b);
			else if (b <= a && b <= c && a <= c)
				System.out.printf("Los números introducidos ordenados de menor a mayor son %d, %d y %d%n", b, a, c);
			else if (b <= c && b <= a && c <= a)
				System.out.printf("Los números introducidos ordenados de menor a mayor son %d, %d y %d%n", b, c, a);
			else if (c <= a && c <= b && a <= b)
				System.out.printf("Los números introducidos ordenados de menor a mayor son %d, %d y %d%n", c, a, b);
			else if (c <= b && c <= a && b <= a)
				System.out.printf("Los números introducidos ordenados de menor a mayor son %d, %d y %d%n", c, b, a);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input");
		} catch (Exception e) {
			System.out.println("Unexpected error");
		}
    }
}
