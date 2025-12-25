public class App {

	public static boolean esPrimo(int n) {
		
		boolean esPrimo = true;
		int i  = 2;

		if (n == 2)
			return (esPrimo);
		while ((i < n / 2) && esPrimo) {
			if (n % i == 0)
				esPrimo = false;
			i++;
		}
		return (esPrimo);
	}

    public static void main(String[] args) throws Exception {
        
		boolean correcto = false;
		int num = 0;

		do {
			try {
				System.out.print("Por favor, introduzca un número entero positivo: ");
				num = Integer.parseInt(System.console().readLine());
				correcto = num > 0;
				if (!correcto) System.out.println("El número debe ser mayor o igual a 0.");
			}
			catch (NumberFormatException e) {
				System.out.println("El número debe ser un entero.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		for (int i = 0; i < 5; i++)
			System.out.printf("%d%s%s%n", num + i, esPrimo(num + i) ? " " : " no ", "es primo");
    }
}
