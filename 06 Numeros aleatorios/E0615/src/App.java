public class App {
    public static void main(String[] args) throws Exception {

		int nota = 0, nota1 = 0, notaFin = 0, melodia = 4;
		nota = (int)(Math.random() * 7) + 1;
		nota1 = nota;
		do {
			for (int i = 0; i < melodia; i++) {
				System.out.print(switch (nota) {
					case 1 -> " do";
					case 2 -> " re";
					case 3 -> " mi";
					case 4 -> " fa";
					case 5 -> " sol";
					case 6 -> " la";
					case 7 -> " si";
					default -> "error";
				});
				notaFin = nota;
				nota = (int)(Math.random() * 7) + 1;
			}
			System.out.print(" |");
		} while (nota1 != notaFin);
		System.out.println("|");
	}
}
