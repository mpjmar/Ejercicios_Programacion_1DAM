public class App {
    public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 10; i++) {
			int longitud = (int)(Math.random() * 40) + 1;
			int res = (int)(Math.random() * 6) + 1;
			for (int j = 0; j < longitud; j++) {
				char caracter = switch (res) {
					case 1 -> '*';
					case 2 -> '-';
					case 3 -> '=';
					case 4 -> '.';
					case 5 -> '|';
					case 6 -> '@';
					default -> ' ';
				};
				System.out.print(caracter);
			}
			System.out.println();
		}
	}
}
