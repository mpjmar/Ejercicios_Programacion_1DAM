public class App {

	public static boolean esPrimo(int num) {

		boolean esPrimo = true;
		int div = 3;

		if (num == 1 || num == 2)
			return (esPrimo);

		while (div < num && esPrimo) {
			if (num % div == 0)
				return (!esPrimo);
			div++;
		}
		return (esPrimo);
	}
    public static void main(String[] args) throws Exception {

		boolean correcto = false;
		int num = 0, max = 0, min = Integer.MAX_VALUE, suma = 0, cont = 0;

		do {
			try {
				System.out.println("Por favor, vaya introduciendo números enteros positivos. Para terminar, introduzca un número primo: ");
				do {
					num = Integer.parseInt(System.console().readLine());
					correcto = num > 0;
					if (!correcto) 
						System.out.println("Los números deben ser positivos.");
					else {
						if (!esPrimo(num)) {
							suma += num;
							max = max < num ? num : max;
							min = min > num ? num : min;
							cont++;
						}
					}
				} while (!esPrimo(num));
			}
			catch (NumberFormatException e) {
				System.out.println("Los números deben ser enteros.");
			}
			catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado.");
			}
		} while (!correcto);

		System.out.printf("""
				Ha introducido %d números no primos.
				Máximo: %d
				Mínimo: %d
				Media: %.2f
				""", cont, max, min, suma / (double)cont);

	}
}
