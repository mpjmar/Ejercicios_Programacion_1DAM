public class App {
    public static void main(String[] args) throws Exception {

		int color = 0;

		for (int i = 0; i < 3; i++) {
			color = (int)(Math.random() * 3) + 1;
			System.out.print(switch (color) {
				case 1 -> "rojo";
				case 2 -> "azul";
				case 3 -> "verde";
				case 4 -> "amarillo";
				case 5 -> "violeta";
				case 6 -> "naranja";
				default -> "error";
			});
			System.out.print(i < 2 ? ", " : " ");
		}
		System.out.println();
	}
}
