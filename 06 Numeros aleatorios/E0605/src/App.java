public class App {
    public static void main(String[] args) throws Exception {

		int min = 199, max = 0, cont = 0, sum = 0;
		for (int i = 0; i < 50; i++) {
			int num = (int)(Math.random() * (200 - 100)) + 100;
			System.out.printf("%d ", num);
			min = num < min ? num : min;
			max = num > max ? num : max;
			sum += num;
			cont++;
		}
		System.out.println();
		System.out.printf("""
				Mínimo: %d
				Máximo: %d
				Media: %d
				""", min, max, sum / cont);
	}
}
