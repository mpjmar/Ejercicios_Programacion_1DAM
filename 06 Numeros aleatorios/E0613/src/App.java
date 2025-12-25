public class App {
    public static void main(String[] args) throws Exception {

		int dado1 = 0, dado2 = 0;

		do {
			dado1 = (int)(Math.random() * 6) + 1;
			dado2 = (int)(Math.random() * 6) + 1;
			System.out.printf("%d %d%n", dado1, dado2);
		} while (!(dado1 == dado2));
	}
}
