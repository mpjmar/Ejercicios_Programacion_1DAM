public class App {
    public static void main(String[] args) throws Exception {
        
		long num = 0;
		long reves = 0;
		boolean correcto = false;
		boolean capicua = false;

		do {
			try {
				num = Integer.parseInt(System.console().readLine("Por favor, introduzca un número entero positivo: "));
				correcto = true;
			}
			catch (NumberFormatException e) {
				System.out.println("Debe introducir un número entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		long n = num;
		while (n > 0) {
			reves = reves * 10 + n % 10;
			n /= 10;
		}
		capicua = (reves == num);

		System.out.printf("""
				El %d%s es capicúa.
				""", num, ((!capicua) ? " no" : ""));
    }
}
