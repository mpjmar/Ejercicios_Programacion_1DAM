public class App {
    public static void main(String[] args) throws Exception {

		for (int i = 1; i <= 14; i++) {
			System.out.printf("%s%d. |", (i < 10 ? " " : ""), i);
			for (int j = 0; j < 3; j++) {
				int res = (int)(Math.random() * 6) + 1;
				System.out.printf("%s|", 
				switch (res) {
					case 1, 2, 3 -> "1  ";
					case 4, 5 -> " X ";
					case 6 -> "  2";
					default -> "";
				});
			}
			System.out.println();
		}
		System.out.printf("%nPLENO AL 15 - ");
		for (int i = 0; i < 2; i++) {
			int pleno = (int)(Math.random() * 4) + 1;
			String resultado = pleno < 4 ? String.format("%d", pleno) : "M";
			System.out.printf(i == 0 ? "Local...%s   " : "Visitante...%s%n", resultado);
		}
	}
}
