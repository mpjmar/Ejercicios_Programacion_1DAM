public class App {
    public static void main(String[] args) throws Exception {
        
		int base = 0;
		int exp = 0;
		boolean correcto = false;

		System.out.println("Cáculo de una potencia");
		
		do {
			try {
				base = Integer.parseInt(System.console().readLine("Introduzca la base: "));
				exp = Integer.parseInt(System.console().readLine("Introduzca el exponente: "));
				correcto = true;
			} catch (NumberFormatException e) {
				System.out.println("Solamente se admiten enteros");
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado");
			}
		} while (!correcto);

		int res = 1;
		if (exp != 0)
			for (int i = 1; i < Math.abs(exp); i++)
				res *= base;
		System.out.println(base + "^" + exp + " = %.2f", (exp >= 0) ? res : (1.0 / res));
		// System.out.printf("%d^%d = %d%n", base, exp, res);
    }
}
