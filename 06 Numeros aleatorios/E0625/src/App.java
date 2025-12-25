public class App {

	public static boolean esPrimo(int num) {
		boolean esPrimo = true;

		if (num == 1 || num == 2)
			return (esPrimo);

		int div = 2;
		while (div < num / 2) {
			if (num % div == 0)
				esPrimo = false;
			div++;
		}
		return (esPrimo);
	}

	public static boolean esMult5(int num) {
		return (num % 5 == 0);
	}

    public static void main(String[] args) throws Exception {

		int num = 0;
		for (int i = 0; i < 100; i++) {
			num = (int)(Math.random() * (201 - 10)) + 10;
			System.out.printf(esPrimo(num) ? "#%d# " : esMult5(num) ? "[%d] " : "%d ", num);
		}
		System.out.println();
	}
}
