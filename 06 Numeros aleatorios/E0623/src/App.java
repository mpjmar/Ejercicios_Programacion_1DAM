public class App {
    public static void main(String[] args) throws Exception {

		int intentos = 5;

		for (int i = 0; i < intentos; i++){
			int tirada = (int)(Math.random() * 6) + 1;
			System.out.print(switch (tirada) {
				case 1 -> "As ";
				case 2 -> "K ";
				case 3 -> "Q ";
				case 4 -> "J ";
				case 5 -> "7 ";
				case 6 -> "8 ";
				default -> "error";
			});
		}
		System.out.println();
	}
}
