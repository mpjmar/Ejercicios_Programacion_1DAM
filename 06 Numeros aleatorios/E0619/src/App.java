public class App {
    public static void main(String[] args) throws Exception {

		int num = 0, maxPar = 0, minImpar = 200, sum = 0;;

		for (int i = 0; i < 50; i++) {
			num = (int)(Math.random() * 301) - 100;
			System.out.printf("%d ", num);
			sum += num;
			if (num % 2 == 0)
				maxPar = maxPar < num ? num : maxPar;
			else
				minImpar = minImpar > num ? num : minImpar;
		}
		System.out.println();
		System.out.printf("""
				Máximo de los pares: %d
				Mínimo de los impares: %d
				Media: %d
				""", maxPar, minImpar, sum / 50);
	}
}
